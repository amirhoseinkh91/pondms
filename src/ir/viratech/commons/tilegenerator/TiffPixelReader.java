package ir.viratech.commons.tilegenerator;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.ToPointHelper;
import org.geotools.coverage.grid.io.imageio.geotiff.GeoTiffIIOMetadataDecoder;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import it.geosolutions.imageioimpl.plugins.tiff.TIFFImageReader;
import it.geosolutions.imageioimpl.plugins.tiff.TIFFImageReaderSpi;

public class TiffPixelReader
{

	private TiffPixelReader(ImageReader reader, int imageIndex, int band, PointCrsTransformer pointTransformer,
	                        PointCrsTransformer rawPointTransformer,
	                        GridCoverage2D coverage, Envelope2D envelope, double noDataValue,
	                        FileInputStream fileInputStream)
	{
		this.reader = reader;
		this.imageIndex = imageIndex;
		this.band = band;
		this.pointTransformer = pointTransformer;
		this.rawPointTransformer = rawPointTransformer;
		this.param = reader.getDefaultReadParam();
		this.coverage = coverage;
		this.envelope = envelope;
		this.noDataValue = noDataValue;
		this.fileInputStream = fileInputStream;

		//////////////////////

		// try
		// {
		// this.image = this.reader.read(this.imageIndex);
		// }
		// catch (IOException e)
		// {
		// throw new RuntimeException(e);
		// }
		// this.raster = this.image.getRaster();
	}

	public void dispose()
	        throws IOException
	{
		this.reader.dispose();
		this.coverage.dispose(true);
		if (this.fileInputStream != null)
		{
			this.fileInputStream.close();
		}
	}

	public void readData(Rectangle region)
	        throws IOException
	{
		this.param.setSourceRegion(region);
		this.image = this.reader.read(this.imageIndex, this.param);
		this.raster = this.image.getRaster();

		this.curX = region.x;
		this.curY = region.y;

		//////////////////////

		// this.curX = 0;
		// this.curY = 0;
	}

	public double getPixel(int x, int y)
	{
		return this.raster.getSampleDouble(x - this.curX, y - this.curY, this.band);
	}

	public double[] getPixels(int x, int y, int w, int h, double[] r)
	{
		return this.raster.getSamples(x - this.curX, y - this.curY, w, h, this.band, r);
	}

	public double[] readPixels(int x, int y, int w, int h, double[] r)
	        throws IOException
	{
		this.readData(new Rectangle(x, y, w, h));
		return this.raster.getSamples(x - this.curX, y - this.curY, w, h, this.band, r);
	}

	public double getPixel(DirectPosition2D dp)
	{
		Point2D point = ToPointHelper.toPoint2D(this.coverage.getGridGeometry(), dp);
		return this.getPixel((Point2D.Double) point);
	}

	public double getPixel(Point2D.Double dp)
	{
		if (!this.envelope.contains(dp))
		{
			return Double.NaN;
		}
		this.coverage.evaluate(dp, this.doubleArr);
		if (this.isNoData(this.doubleArr[0]))
		{
			return Double.NaN;
		}
		return this.doubleArr[0];
	}

	public double getPixel(double x, double y)
	{
		DirectPositionCreator positionCreator = new DirectPositionCreator();
		return this.getPixel(positionCreator.create(new PointF(x, y), null));
	}

	public boolean isNoData(double v)
	{
		return v == this.noDataValue || (Double.isNaN(v) & Double.isNaN(this.noDataValue));
	}

	public int getWidth()
	{
		try
		{
			return this.reader.getWidth(this.imageIndex);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public int getHeight()
	{
		try
		{
			return this.reader.getHeight(this.imageIndex);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public static TiffPixelReader[] getAllReaders(File file)
	        throws IOException
	{
		return getAllReaders(new FileInputStream(file), file);
	}

	public static TiffPixelReader[] getAllReaders(InputStream stream)
	        throws IOException
	{
		return getAllReaders(stream, null);
	}

	private static TiffPixelReader[] getAllReaders(InputStream stream, File file)// boolean
	                                                                             // closeFile)
	        throws IOException
	{
		FileInputStream fileInputStream = null;
		if (file != null)// closeFile)
		{
			fileInputStream = (FileInputStream) stream;
		}

		stream = new BufferedInputStream(stream);

		// stream.mark(100 * 1024 * 1024);

		ImageReader reader = createReader();
		ImageInputStream imageInputStream = ImageIO.createImageInputStream(stream);
		// ImageInputStream imageInputStream =
		// ImageIO.createImageInputStream(new RandomAccessFile(file, "r"));
		reader.setInput(imageInputStream);

		GeoTiffReader tiffReader = new GeoTiffReader(imageInputStream);
		// , new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, true));

		GeoTiffIIOMetadataDecoder metadata = tiffReader.getMetadata();
		double noDataValue = metadata.getNoData();
		// metadata.get

		GridCoverage2D coverage = tiffReader.read(null);
		// CoordinateReferenceSystem crs =
		// coverage.getCoordinateReferenceSystem();
		CoordinateReferenceSystem crs = tiffReader.getCoordinateReferenceSystem();
		Envelope2D envelope = coverage.getEnvelope2D();

		if (envelope.getDimension() != 2)
		{
			throw new RuntimeException("Invalid coordinate reference system for the image. Not 2d.");
		}

		double originX = envelope.getMinimum(0);
		double originY = envelope.getMinimum(1);
		double maxX = envelope.getMaximum(0);
		double maxY = envelope.getMaximum(1);

		List<TiffPixelReader> res = new ArrayList<>();

		// stream.reset();
		reader = createReader();
		// imageInputStream = ImageIO.createImageInputStream(stream);
		imageInputStream.seek(0);
		reader.setInput(imageInputStream);

		ImageReadParam param = reader.getDefaultReadParam();
		param.setSourceRegion(new Rectangle(0, 0, 1, 1));

		int imagesCount = reader.getNumImages(true);
		for (int i = 0; i < imagesCount; i++)
		{
			BufferedImage image = reader.read(i, param);

			double width = reader.getWidth(i);
			double height = reader.getHeight(i);
			double scaleX = (maxX - originX) / width;
			double scaleY = (maxY - originY) / height;

			PointCrsTransformer pointTransformer = new PointCrsTransformer(crs, originX, originY, scaleX, scaleY);
			PointCrsTransformer rawPointTransformer = new PointCrsTransformer(crs, 0, 0, 1, 1);

			int bandsCount = image.getRaster().getNumBands();
			for (int j = 0; j < bandsCount; j++)
			{
				res.add(new TiffPixelReader(reader, i, j, pointTransformer, rawPointTransformer, coverage, envelope,
				                            noDataValue, fileInputStream));
			}
		}

		return res.toArray(new TiffPixelReader[res.size()]);
	}

	private static TIFFImageReader createReader()
	        throws IOException
	{
		TIFFImageReaderSpi spi = new TIFFImageReaderSpi();
		return (TIFFImageReader) spi.createReaderInstance();
	}

	public ImageReader getReader()
	{
		return this.reader;
	}

	public int getImageIndex()
	{
		return this.imageIndex;
	}

	public int getBand()
	{
		return this.band;
	}

	public BufferedImage getImage()
	{
		return this.image;
	}

	public WritableRaster getRaster()
	{
		return this.raster;
	}

	public PointCrsTransformer getPointTransformer()
	{
		return this.pointTransformer;
	}

	public double getNoDataValue()
	{
		return this.noDataValue;
	}

	public GridCoverage2D getCoverage()
	{
		return this.coverage;
	}

	public Envelope2D getEnvelope()
	{
		return this.envelope;
	}

	public PointCrsTransformer getRawPointTransformer()
	{
		return this.rawPointTransformer;
	}

	private final FileInputStream fileInputStream;

	private final ImageReadParam param;
	private double[] doubleArr = new double[1];

	private BufferedImage image;
	private WritableRaster raster;
	private int curX, curY;

	private final double noDataValue;
	private final GridCoverage2D coverage;
	private final Envelope2D envelope;
	private final ImageReader reader;
	private final int imageIndex;
	private final int band;
	private final PointCrsTransformer pointTransformer;
	private final PointCrsTransformer rawPointTransformer;

}

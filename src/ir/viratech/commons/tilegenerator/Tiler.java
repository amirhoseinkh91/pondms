package ir.viratech.commons.tilegenerator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;

import javax.imageio.ImageIO;

import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

public class Tiler
{

	public TiffPixelReader reader;
	public PointTilesTransformer targetPT;
	public int maxZoom;
	public Gradient gradiant;
	public Path baseDirectory;
	private final RectF extents = new RectF();

	public RectF createTiles()
	        throws IOException
	{
		FileSystemProvider fsProvider = this.baseDirectory.getFileSystem().provider();

		File bdFile = this.baseDirectory.toFile();
		if (!bdFile.exists() || !bdFile.isDirectory()
		    || Files.newDirectoryStream(this.baseDirectory).iterator().hasNext())
		{
			throw new RuntimeException();
		}

		this.setFirstZoom();

		Path tilesDirectory = this.baseDirectory.resolve(this.targetPT.getZoom() + "");
		fsProvider.createDirectory(tilesDirectory);

		RectI baseRect = this.createBaseTiles(tilesDirectory);
		this.createZoomTiles(baseRect);

		return this.extents;
	}

	private void setFirstZoom()
	{
		int zoom = this.maxZoom;
		this.targetPT.setZoom(zoom);
		this.init();

		long sourceArea = (long) this.sourceD.x * this.sourceD.y;
		double targetW = this.b2.x - this.b1.x;
		double targetH = this.b2.y - this.b1.y;

		while (zoom > 0)
		{
			if (targetW * targetH / 2 < sourceArea)
			{
				break;
			}

			zoom -= 1;
			targetW /= 2;
			targetH /= 2;
		}

		this.targetPT.setZoom(zoom);
		this.init();
	}

	private void init()
	{
		this.sourceD.set(this.reader.getWidth(), this.reader.getHeight());

		Envelope2D envelope = this.reader.getEnvelope();
		PointCrsTransformer transformer = this.reader.getRawPointTransformer();

		this.extents.reset();

		this.b1.set(envelope.x, envelope.y);
		transformer.toLatLon(this.b1);
		this.extents.expandToPoint(this.b1);
		this.targetPT.fromLatLon(this.b1);

		this.b2.set(envelope.x + envelope.width, envelope.y + envelope.height);
		transformer.toLatLon(this.b2);
		this.extents.expandToPoint(this.b2);
		this.targetPT.fromLatLon(this.b2);
	}

	public Tuple2<Double, Double> findMinMax()
	        throws IOException
	{
		int dim = 1000;
		int w = this.reader.getWidth();
		int h = this.reader.getHeight();

		double[] values = new double[dim * dim];

		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;

		for (int tx = 0; tx < w; tx += dim)
		{
			for (int ty = 0; ty < h; ty += dim)
			{
				int cw = Math.min(tx + dim, w) - tx;
				int ch = Math.min(ty + dim, h) - ty;
				this.reader.readPixels(tx, ty, cw, ch, values);
				int count = cw * ch;

				for (int i = 0; i < count; i++)
				{
					double v = values[i];
					if (this.reader.isNoData(v))
					{
						continue;
					}
					min = Math.min(min, v);
					max = Math.max(max, v);
				}
			}
		}

		return new Tuple2<>(min, max);
	}

	private final PointF b1 = new PointF(), b2 = new PointF();
	private final PointI sourceD = new PointI();

	private RectI createBaseTiles(Path baseTilesDirectory)
	        throws IOException
	{
		DirectPositionCreator dpCreator = new DirectPositionCreator();

		int tileSize = this.targetPT.getTileSize();
		int zoom = this.targetPT.getZoom();

		BufferedImage image = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		WritableRaster raster = image.getRaster();
		int[] pixels = new int[tileSize * tileSize * 4];
		Pixels2D pixels2d = new Pixels2D();
		pixels2d.setData(pixels, 0, 0, tileSize, tileSize);

		Color col = new Color();

		PointI p0 = new PointI(), ti = new PointI();
		PointF tf = new PointF();

		RectI bounds = new RectI((int) Math.floor(this.b1.x / tileSize),
		                         (int) Math.floor(this.b1.y / tileSize),
		                         (int) Math.ceil(this.b2.x / tileSize) - 1,
		                         (int) Math.ceil(this.b2.y / tileSize) - 1);

		DirectPosition2D dp = new DirectPosition2D();

		for (ti.x = bounds.getMinX(); ti.x <= bounds.getMaxX(); ti.x++)
		{
			for (ti.y = bounds.getMinY(); ti.y <= bounds.getMaxY(); ti.y++)
			{
				p0.set(ti.x * tileSize, ti.y * tileSize);

				for (int i = 0; i < tileSize; i++)
				{
					for (int j = 0; j < tileSize; j++)
					{
						tf.set(p0.x + i, p0.y + j);
						this.targetPT.toLatLon(tf);

						double v = this.reader.getPixel(dpCreator.create(tf, dp));
						this.gradiant.getColor(v, col);

						// if (col.getAlpha() != 0 && Math.abs(v) > 1e-30 &&
						// Math.abs(v) < 1e30)
						// {
						// int a = 2;
						// }

						pixels2d.setColor(col);
						pixels2d.set(i, tileSize - 1 - j);
					}
				}

				raster.setPixels(0, 0, tileSize, tileSize, pixels);

				File file = baseTilesDirectory.resolve(this.getTileFileName(zoom, ti.x, ti.y)).toFile();
				ImageIO.write(image, "png", file);
			}
		}

		return bounds;
	}

	private void createZoomTiles(RectI baseRect)
	        throws IOException
	{
		int tileSize = this.targetPT.getTileSize();
		FileSystemProvider fsProvider = this.baseDirectory.getFileSystem().provider();

		BufferedImage image = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();

		g.setBackground(new java.awt.Color(0, 0, 0, 0));

		RectI nextRect = new RectI();
		PointI ti = new PointI();

		for (int zoom = this.targetPT.getZoom() - 1; zoom >= 0; zoom--)
		{
			Path previousDirectory = this.baseDirectory.resolve((zoom + 1) + "");
			Path currentDirectory = this.baseDirectory.resolve(zoom + "");
			fsProvider.createDirectory(currentDirectory);

			for (ti.x = baseRect.getMinX() / 2; ti.x <= baseRect.getMaxX() / 2 + 1; ti.x++)
			{
				for (ti.y = baseRect.getMinY() / 2; ti.y <= baseRect.getMaxY() / 2 + 1; ti.y++)
				{
					g.clearRect(0, 0, tileSize, tileSize);

					BufferedImage pImage;
					File f;
					boolean bl = false;

					int tx2 = ti.x * 2;
					int ty2 = ti.y * 2;

					f = previousDirectory.resolve(this.getTileFileName(zoom + 1, tx2, ty2 + 1)).toFile();
					if (f.exists())
					{
						pImage = ImageIO.read(f);
						g.drawImage(pImage, 0, 0,
						            tileSize / 2, tileSize / 2,
						            0, 0, tileSize, tileSize, null);
						bl = true;
					}
					f = previousDirectory.resolve(this.getTileFileName(zoom + 1, tx2 + 1, ty2 + 1)).toFile();
					if (f.exists())
					{
						pImage = ImageIO.read(f);
						g.drawImage(pImage, tileSize / 2, 0,
						            tileSize, tileSize / 2,
						            0, 0, tileSize, tileSize, null);
						bl = true;
					}
					f = previousDirectory.resolve(this.getTileFileName(zoom + 1, tx2, ty2)).toFile();
					if (f.exists())
					{
						pImage = ImageIO.read(f);
						g.drawImage(pImage, 0, tileSize / 2,
						            tileSize / 2, tileSize,
						            0, 0, tileSize, tileSize, null);
						bl = true;
					}
					f = previousDirectory.resolve(this.getTileFileName(zoom + 1, tx2 + 1, ty2)).toFile();
					if (f.exists())
					{
						pImage = ImageIO.read(f);
						g.drawImage(pImage, tileSize / 2, tileSize / 2,
						            tileSize, tileSize,
						            0, 0, tileSize, tileSize, null);
						bl = true;
					}

					if (bl)
					{
						File file = currentDirectory.resolve(this.getTileFileName(zoom, ti.x, ti.y)).toFile();
						ImageIO.write(image, "png", file);
						nextRect.expandToPoint(ti);
					}
				}
			}

			baseRect = nextRect;
			nextRect = new RectI();
		}
	}

	private String getTileFileName(int zoom, int x, int y)
	{
		return zoom + "_" + x + "_" + y + "." + this.format;
	}

	private final String format = "png";

}

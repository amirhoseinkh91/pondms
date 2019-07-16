package ir.viratech.commons.tilegenerator;

import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class PointWebMercatorTilesTransformer
        extends PointTilesTransformer
{

	public PointWebMercatorTilesTransformer()
	{
		try
		{
			CoordinateReferenceSystem crs = CRS.decode("EPSG:3857");
			CoordinateReferenceSystem ref = CRS.decode("WGS84(DD)");

			this.toLatLonTransform = CRS.findMathTransform(crs, ref);
			this.fromLatLonTransform = CRS.findMathTransform(ref, crs);
		}
		catch (FactoryException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void fromLatLonNoTiling(PointF p)
	{
		this.t1[0] = p.x;
		this.t1[1] = p.y;

		try
		{
			this.fromLatLonTransform.transform(this.t1, 0, this.t2, 0, 1);
		}
		catch (TransformException e)
		{
			throw new RuntimeException(e);
		}

		p.x = this.t2[0] / 40075016.68557849 + 0.5;
		p.y = this.t2[1] / 40075016.68557849 + 0.5;
	}

	@Override
	protected void toLatLonNoTiling(PointF p)
	{
		this.t1[0] = (p.x - 0.5) * 40075016.68557849;
		this.t1[1] = (p.y - 0.5) * 40075016.68557849;

		try
		{
			this.toLatLonTransform.transform(this.t1, 0, this.t2, 0, 1);
		}
		catch (TransformException e)
		{
			throw new RuntimeException(e);
		}

		p.x = this.t2[0];
		p.y = this.t2[1];
	}

	private final MathTransform toLatLonTransform, fromLatLonTransform;
	private final double[] t1 = new double[2];
	private final double[] t2 = new double[2];

}

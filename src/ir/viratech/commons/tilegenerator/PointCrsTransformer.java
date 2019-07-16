package ir.viratech.commons.tilegenerator;

import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class PointCrsTransformer
        extends PointTransformer
{

	public PointCrsTransformer(CoordinateReferenceSystem crs,
	                           double originX, double originY,
	                           double scaleX, double scaleY)
	{
		this.originX = originX;
		this.originY = originY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;

		this.crs = crs;

		try
		{
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
	protected void fromLatLonOverride(PointF p)
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

		p.x = (this.t2[0] - this.originX) / this.scaleX;
		p.y = (this.t2[1] - this.originY) / this.scaleY;
	}

	@Override
	protected void toLatLonOverride(PointF p)
	{
		this.t1[0] = p.x * this.scaleX + this.originX;
		this.t1[1] = p.y * this.scaleY + this.originY;

		try
		{
			this.toLatLonTransform.transform(this.t1, 0, this.t2, 0, 1);
		}
		catch (TransformException e)
		{
			throw new RuntimeException(e);
		}

		p.set(this.t2[0], this.t2[1]);
	}

	public CoordinateReferenceSystem getCrs()
	{
		return this.crs;
	}

	private final CoordinateReferenceSystem crs;

	private final MathTransform fromLatLonTransform;
	private final MathTransform toLatLonTransform;

	private final double originX;
	private final double originY;
	private final double scaleX;
	private final double scaleY;

	private final double[] t1 = new double[2];
	private final double[] t2 = new double[2];

}

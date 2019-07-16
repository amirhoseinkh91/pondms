package ir.viratech.commons.tilegenerator;

import org.geotools.geometry.DirectPosition2D;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class DirectPositionCreator
{

	public DirectPositionCreator()
	{
		try
		{
			this.crs = CRS.decode("WGS84(DD)");
		}
		catch (FactoryException e)
		{
			throw new RuntimeException(e);
		}
	}

	public DirectPosition2D create(PointF p, DirectPosition2D res)
	{
		if (res == null)
		{
			res = new DirectPosition2D();
		}
		res.setCoordinateReferenceSystem(this.crs);
		res.setLocation(p.x, p.y);
		return res;
	}

	public CoordinateReferenceSystem getCrs()
	{
		return this.crs;
	}

	private final CoordinateReferenceSystem crs;

}

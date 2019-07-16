package ir.viratech.commons.tilegenerator;

import java.awt.geom.Point2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.geometry.DirectPosition2D;
import org.opengis.geometry.DirectPosition;

public class ToPointHelper
{

	private static final Method toPoint2D;

	static
	{
		try
		{
			toPoint2D = GridGeometry2D.class.getDeclaredMethod("toPoint2D", DirectPosition.class);
			toPoint2D.setAccessible(true);
		}
		catch (NoSuchMethodException | SecurityException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static Point2D toPoint2D(GridGeometry2D geometry, DirectPosition2D pd)
	{
		try
		{
			return (Point2D) toPoint2D.invoke(geometry, pd);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

}

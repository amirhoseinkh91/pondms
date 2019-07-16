package org.geotools.coverage.grid;

import java.awt.geom.Point2D;

import org.geotools.geometry.DirectPosition2D;

public class ToPointHelper
{

	public static Point2D toPoint2D(GridGeometry2D geometry, DirectPosition2D pd)
	{
		return geometry.toPoint2D(pd);
	}

}

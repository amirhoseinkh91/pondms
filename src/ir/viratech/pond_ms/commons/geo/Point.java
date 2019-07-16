package ir.viratech.pond_ms.commons.geo;


import java.util.ArrayList;
import java.util.Arrays;

import com.vividsolutions.jts.geom.Coordinate;

public class Point extends GeoObject {

	public Point(){}
	
	public Point(Double x , Double y){
		this.setType(GeoObject.TYPE__POINT);
		this.setCoordinates(new ArrayList<Object>(Arrays.asList(x,y)));
	}
	
	public Point(com.vividsolutions.jts.geom.Point point) {
		this.setType(GeoObject.TYPE__POINT);
		this.setCoordinates(new ArrayList<Object>(Arrays.asList(point.getX(), point.getY())));
	}

	@Override
	public com.vividsolutions.jts.geom.Point getJtsGeometry() {
		double x = (double) this.getCoordinates().get(0);
		double y = (double) this.getCoordinates().get(1);
		
		return this.getGeomFactory().createPoint(new Coordinate(x, y));
	}
	
}
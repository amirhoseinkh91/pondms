package ir.viratech.pond_ms.commons.geo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;

import com.vividsolutions.jts.geom.Coordinate;

public class Polygon extends GeoObject {

	@SuppressWarnings("unchecked")
	@Override
	public com.vividsolutions.jts.geom.Polygon getJtsGeometry() {
		
		int size = this.getCoordinates().size();
		int i=0;
		Coordinate[] coorArray = new Coordinate[size];
		for (Object obj : this.getCoordinates()) {
			List<Double> plist = (ArrayList<Double>) obj;
			coorArray[i] = (new Coordinate(plist.get(0), plist.get(1)));
			i++;
		}
		return this.getGeomFactory().createPolygon(this.getGeomFactory().createLinearRing(coorArray), null);
	}
	
	public Polygon(){
		this.setType(GeoObject.TYP__POLYGON);
		this.setCoordinates(new ArrayList<>());
	}
	
	public Polygon(com.vividsolutions.jts.geom.Polygon polygon) {
		this.setType(GeoObject.TYP__POLYGON);
		this.setCoordinates(new ArrayList<>());
		if (polygon != null)
			for (Coordinate cord : polygon.getCoordinates()) {
				List<Double> temp = new ArrayList<>();
				temp.add(cord.x);
				temp.add(cord.y);
				this.getCoordinates().add((Object)temp);
			}
			
	}
	
	@SuppressWarnings("unchecked")
	public GeoJsonPolygon getGeoJsonPolygon() {
		List<Point> pointList = new ArrayList<>();
		for (Object obj : this.getCoordinates()) {
			List<Double> plist = (List<Double>) obj;
			pointList.add(new Point(plist.get(0), plist.get(1)));
		}
		return new GeoJsonPolygon(pointList);
	}

}

package ir.viratech.pond_ms.commons.geo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;


public class LineString extends GeoObject {
	public LineString() {}
	
	public LineString(com.vividsolutions.jts.geom.LineString lineString) {
		this.setType(GeoObject.TYPE__LINE);
		

		Coordinate[] coordinates = lineString.getCoordinates();
		ArrayList<Object> list = new ArrayList<Object>(coordinates.length);
		
		for(Coordinate coord: coordinates) {
			list.add(Arrays.asList(coord.x, coord.y));
		}
		
		this.setCoordinates(list);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public com.vividsolutions.jts.geom.LineString getJtsGeometry() {
		
		List<Object> coordList = this.getCoordinates();
		int size = coordList.size();
		
		Coordinate[] coordinates = new Coordinate[size];
		
		for(int i=0; i<size; i++) {
			List<Double> arrayObj = (List<Double>) coordList.get(i);
			coordinates[i] = new Coordinate(arrayObj.get(0), arrayObj.get(1));
		}
		
		return this.getGeomFactory().createLineString(coordinates);
	}
}

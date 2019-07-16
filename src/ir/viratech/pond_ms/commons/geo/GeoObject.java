package ir.viratech.pond_ms.commons.geo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

public class GeoObject {

	private GeometryFactory geomFactory; 
	
	public static final String TYPE__POINT = "point";
	public static final String TYPE__LINE = "line";
	public static final String TYP__POLYGON = "polygon";

	public GeometryFactory getGeomFactory() {
		if(this.geomFactory == null)
			geomFactory = new GeometryFactory(new PrecisionModel(), 4326);
		return this.geomFactory;
	}

	public GeoObject() {

	}

	protected GeoObject(Geometry jtsGeometry) {
	}

	@JsonProperty("type")
	private String type;

	@JsonProperty("coordinates")
	private List<Object> coordinates;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Object> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Object> coordinates) {
		this.coordinates = coordinates;
	}

	public Geometry getJtsGeometry(){return null;}
	
}

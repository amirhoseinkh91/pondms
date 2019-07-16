package ir.viratech.pond_ms.model.map_object.vector;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.commons.geo.GeoObject;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePolygonObject;

/**
 * The entity class "PolygonObject".
 */

public class PolygonObject extends BasePolygonObject implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;


	@Override
	public String getType() {
		return GISVectorObject.TYPE__POLYGON;
	}


	@Override
	public GeoObject getGeoObject() {
		return new Polygon(this.getPolygon());
	}


	@Override
	public String getEntityTypeKey() {
		return "polygonObject";
	}



}
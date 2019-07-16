package ir.viratech.pond_ms.model.map_object.vector;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.commons.geo.GeoObject;
import ir.viratech.pond_ms.commons.geo.LineString;
import ir.viratech.pond_ms.model.map_object.vector.base.BaseLineObject;

/**
 * The entity class "LineObject".
 */

public class LineObject extends BaseLineObject implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;


	@Override
	public String getType() {
		return GISVectorObject.TYPE__LINE;
	}

	@Override
	public GeoObject getGeoObject() {
		return new LineString(this.getLine());
	}

	@Override
	public String getEntityTypeKey() {
		return "lingObject";
	}

}
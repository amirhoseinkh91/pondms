package ir.viratech.pond_ms.model.map_object.vector;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.commons.geo.GeoObject;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePointObject;

/**
 * The entity class "PointObject".
 */

public class PointObject extends BasePointObject implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getType() {
		return GISVectorObject.TYPE__POINT;
	}

	@Override
	public GeoObject getGeoObject() {
		return new Point(this.getPoint());
	}

	@Override
	public String getEntityTypeKey() {
		return "pointObject";
	}

}
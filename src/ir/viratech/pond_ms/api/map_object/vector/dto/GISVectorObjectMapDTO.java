package ir.viratech.pond_ms.api.map_object.vector.dto;

import ir.viratech.pond_ms.api.map_object.vector.base.BaseGISVectorObjectMapDTO;
import ir.viratech.pond_ms.commons.geo.LineString;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;


/**
 * A DTO for class GISVectorObject.
 *
 */
public class GISVectorObjectMapDTO extends BaseGISVectorObjectMapDTO {
	
	/**
	 * FieldInfoContext for GISVectorObjectMapDTO
	 */
	public static class FieldInfoContext extends BaseGISVectorObjectMapDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected String load_Type(GISVectorObject gISVectorObject) {
		return gISVectorObject.getType();
	}

	@Override
	protected Point load_Point(GISVectorObject gISVectorObject) {
		if (GISVectorObject.TYPE__POINT.equals(gISVectorObject.getType()))
			return new Point(((PointObject) gISVectorObject).getPoint());
		return null;
	}

	@Override
	protected LineString load_Line(GISVectorObject gISVectorObject) {
		if (GISVectorObject.TYPE__LINE.equals(gISVectorObject.getType()))
			return new LineString(((LineObject) gISVectorObject).getLine());
		return null;
	}

	@Override
	protected Polygon load_Polygon(GISVectorObject gISVectorObject) {
		if (GISVectorObject.TYPE__POLYGON.equals(gISVectorObject.getType()))
			return new Polygon(((PolygonObject) gISVectorObject).getPolygon());
		return null;
	}

	
}

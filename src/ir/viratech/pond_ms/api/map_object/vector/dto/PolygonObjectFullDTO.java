package ir.viratech.pond_ms.api.map_object.vector.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.pond_ms.api.map_object.vector.base.BasePolygonObjectFullDTO;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;


/**
 * A DTO for class PolygonObject.
 *
 */
public class PolygonObjectFullDTO extends BasePolygonObjectFullDTO {
	
	/**
	 * FieldInfoContext for PolygonObjectFullDTO
	 */
	public static class FieldInfoContext extends BasePolygonObjectFullDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected ArrayNode load_FormInstances(PolygonObject polygonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_FormInstances(PolygonObject polygonObject, ArrayNode formInstances)
			throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Polygon load_Polygon(PolygonObject polygonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_Polygon(PolygonObject polygonObject, Polygon polygon) throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}
	
}

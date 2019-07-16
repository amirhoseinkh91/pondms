package ir.viratech.pond_ms.api.map_object.vector.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.pond_ms.api.map_object.vector.base.BasePointObjectFullDTO;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;


/**
 * A DTO for class PointObject.
 *
 */
public class PointObjectFullDTO extends BasePointObjectFullDTO {
	
	/**
	 * FieldInfoContext for PointObjectFullDTO
	 */
	public static class FieldInfoContext extends BasePointObjectFullDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected ArrayNode load_FormInstances(PointObject pointObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_FormInstances(PointObject pointObject, ArrayNode formInstances)
			throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Point load_Point(PointObject pointObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_Point(PointObject pointObject, Point point) throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}
	
}

package ir.viratech.pond_ms.api.map_object.vector.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.pond_ms.api.map_object.vector.base.BaseLineObjectFullDTO;
import ir.viratech.pond_ms.commons.geo.LineString;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;


/**
 * A DTO for class LineObject.
 *
 */
public class LineObjectFullDTO extends BaseLineObjectFullDTO {
	
	/**
	 * FieldInfoContext for LineObjectFullDTO
	 */
	public static class FieldInfoContext extends BaseLineObjectFullDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected ArrayNode load_FormInstances(LineObject lineObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_FormInstances(LineObject lineObject, ArrayNode formInstances)
			throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected LineString load_Line(LineObject lineObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_Line(LineObject lineObject, LineString line) throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}
	
}

package ir.viratech.pond_ms.api.layer.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.layer.base.BaseLeafLayerFullDTO;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;


/**
 * A DTO for class LeafLayer.
 *
 */
public class LeafLayerFullDTO extends BaseLeafLayerFullDTO {
	
	/**
	 * FieldInfoContext for LeafLayerFullDTO
	 */
	public static class FieldInfoContext extends BaseLeafLayerFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<ParentLayer, ParentLayerLightDTO> createEntityByDtoFinder_ParentLayer() {
			return new EntityByDtoFinder_ByUid<ParentLayer, ParentLayerLightDTO>(ParentLayerMgr.getInstance());
		}
		
	}

	@Override
	protected ObjectNode load_FormInstance(LeafLayer leafLayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void save_FormInstance(LeafLayer leafLayer, ObjectNode formInstance)
			throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}
	
}

package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.layer.base.BaseParentLayerFullDTO;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;


/**
 * A DTO for class ParentLayer.
 *
 */
public class ParentLayerFullDTO extends BaseParentLayerFullDTO {
	
	/**
	 * FieldInfoContext for ParentLayerFullDTO
	 */
	public static class FieldInfoContext extends BaseParentLayerFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<ParentLayer, ParentLayerLightDTO> createEntityByDtoFinder_Parent() {
			return new EntityByDtoFinder_ByUid<ParentLayer, ParentLayerLightDTO>(ParentLayerMgr.getInstance());
		}
		
	}

	@Override
	protected PlainCollectionDTO<Layer, LayerLightDTO> load_SubLayers(ParentLayer parentLayer) {
		return PlainCollectionDTO.createAndLoad(parentLayer.getSubLayers(), LayerLightDTO.class);
	}

	@Override
	protected void save_SubLayers(ParentLayer parentLayer, PlainCollectionDTO<Layer, LayerLightDTO> subLayers)
			throws BadDtoEntityModificationException {
		// TODO Auto-generated method stub
		
	}
	
}

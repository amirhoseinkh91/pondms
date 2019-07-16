package ir.viratech.pond_ms.api.layer.dto;

import java.util.Set;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.layer.base.BasePondFullDTO;
import ir.viratech.pond_ms.api.time_series.dto.CategoryLightDTO;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.time_series.Category;


/**
 * A DTO for class Pond.
 *
 */
public class PondFullDTO extends BasePondFullDTO {
	
	/**
	 * FieldInfoContext for PondFullDTO
	 */
	public static class FieldInfoContext extends BasePondFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<ParentLayer, LayerLightDTO> createEntityByDtoFinder_Layer() {
			return new EntityByDtoFinder_ByUid<ParentLayer, LayerLightDTO>(ParentLayerMgr.getInstance());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected PlainCollectionDTO<Category, CategoryLightDTO> load_TimeSeries(Pond pond) {
		
		Set<Category> set = (Set<Category>)(Set<?>) pond.getTimeSeriesRootCategories();
		return PlainCollectionDTO.createAndLoad(set, CategoryLightDTO.class);
	}
	
}

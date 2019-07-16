package ir.viratech.pond_ms.api.time_series.dto;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.time_series.base.BaseCategoryFullDTO;
import ir.viratech.pond_ms.model.time_series.Category;
import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr;


/**
 * A DTO for class Category.
 *
 */
public class CategoryFullDTO extends BaseCategoryFullDTO {
	
	/**
	 * FieldInfoContext for CategoryFullDTO
	 */
	public static class FieldInfoContext extends BaseCategoryFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<TimeSeriesGroup, TimeSeriesGroupLightDTO> createEntityByDtoFinder_RelatedGroup() {
			return new EntityByDtoFinder_ByUid<TimeSeriesGroup, TimeSeriesGroupLightDTO>(TimeSeriesGroupMgr.getInstance());
		}
	
	}

	@Override
	protected Integer load_ChildCount(Category category) {
		if(category.getType().equals(LeafCategory.PROP_TYPE))
			return 0;
		else
			return ((ParentCategory)category).getSubCategories().size();
	}

	@Override
	protected Boolean load_IsLeaf(Category category) {
		if(category.getType().equals(LeafCategory.PROP_TYPE))
			return true;
		return false;
	}

	@Override
	protected String load_TimeSeriesValueType(Category category) {
		if(category.getType().equals(LeafCategory.PROP_TYPE))
			return ((LeafCategory)category).getTimeSeriesValueType();
		return null;
	}

	@Override
	protected PlainCollectionDTO<Category, CategoryLightDTO> load_Children(Category category) {
		
		
		if(category.getType().equals(LeafCategory.PROP_TYPE))
			return null;
		else
			return PlainCollectionDTO.createAndLoad(((ParentCategory)category).getSubCategories(), CategoryLightDTO.class);
		
	}

	@Override
	protected PlainCollectionDTO<TimeSeriesDateValuePair, TimeSeriesDateValuePairLightDTO> load_Values(
			Category category) {
		if(category.getType().equals(LeafCategory.PROP_TYPE))
		{
			LeafCategory leaf = (LeafCategory)category;
			return PlainCollectionDTO.createAndLoad(leaf.getTimeSeriesValues(), TimeSeriesDateValuePairLightDTO.class);
		}
		return null;
	}

	@Override
	protected Boolean load_IsRoot(Category category) {
		if(category.getType().equals(RootCategory.PROP_TYPE))
			return true;
		return false;
	}

	@Override
	protected TimeSeriesGroupLightDTO load_RelatedGroup(Category category) {
		
		
		if(!category.getType().equals(RootCategory.PROP_TYPE))
			return null;
		
		TimeSeriesGroup group  = ((RootCategory)category).getGroup();
		TimeSeriesGroupLightDTO result = new TimeSeriesGroupLightDTO();
		if(group != null)
			result.loadFrom(group);
		
		return result;
		
	}
	
}

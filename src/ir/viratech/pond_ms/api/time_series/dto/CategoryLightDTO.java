package ir.viratech.pond_ms.api.time_series.dto;

import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.file.dto.DataFileLightDTO;
import ir.viratech.pond_ms.api.time_series.base.BaseCategoryLightDTO;
import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.file.logic.DataFileMgr;
import ir.viratech.pond_ms.model.time_series.Category;
import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;


/**
 * A DTO for class Category.
 *
 */
public class CategoryLightDTO extends BaseCategoryLightDTO {
	
	/**
	 * FieldInfoContext for CategoryLightDTO
	 */
	public static class FieldInfoContext extends BaseCategoryLightDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<DataFile, DataFileLightDTO> createEntityByDtoFinder_DataFile() {
			return new EntityByDtoFinder_ByUid<DataFile, DataFileLightDTO>(DataFileMgr.getInstance());
		}

	}

	@Override
	protected Integer load_ChildCount(Category category) {
		if(category.getType().equals(ParentCategory.PROP_TYPE))
			return ((ParentCategory)category).getSubCategories().size();
		else
			return 0;
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
	protected Boolean load_IsRoot(Category category) {
		if(category.getType().equals(RootCategory.PROP_TYPE))
			return true;
		return false;
	}

	@Override
	protected DataFileLightDTO load_DataFile(Category category) {
		if (category.getType().equals(RootCategory.PROP_TYPE)) {
			DataFileLightDTO dto = new DataFileLightDTO();
			dto.loadFrom(((RootCategory)category).getDataFile());
			return dto;
		}
		return null;
	}
	
}

package ir.viratech.pond_ms.model.time_series;

import ir.viratech.pond_ms.model.time_series.base.BaseParentCategory;

/**
 * The entity class "ParentCategory".
 */

public class ParentCategory extends BaseParentCategory {
	private static final long serialVersionUID = 1L;

	public static final String PROP_TYPE = "parent";
	
	@Override
	public String getType() {
		return PROP_TYPE;
	}
	
	
	


}
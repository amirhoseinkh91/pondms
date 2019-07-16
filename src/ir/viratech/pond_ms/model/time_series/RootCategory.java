package ir.viratech.pond_ms.model.time_series;

import ir.viratech.pond_ms.model.time_series.base.BaseRootCategory;

/**
 * The entity class "RootCategory".
 */

public class RootCategory extends BaseRootCategory {
	private static final long serialVersionUID = 1L;
	
	public static final String PROP_TYPE = "root";
	
	@Override
	public String getType() {
		return PROP_TYPE;
	}
}
package ir.viratech.pond_ms.model.time_series;

import ir.viratech.pond_ms.model.time_series.base.BaseLeafCategory;

/**
 * The entity class "LeafCategory".
 */

public class LeafCategory extends BaseLeafCategory {
	private static final long serialVersionUID = 1L;

	public static final String PROP_TYPE = "leaf";
	
	@Override
	public String getType() {
		return PROP_TYPE;
	}

	
	


}
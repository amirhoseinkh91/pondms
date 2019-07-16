package ir.viratech.pond_ms.model.time_series;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.time_series.base.BaseCategory;

/**
 * The entity class "Category".
 */

public abstract class Category extends BaseCategory implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return this.getName();
	}
	public abstract String getType();
}
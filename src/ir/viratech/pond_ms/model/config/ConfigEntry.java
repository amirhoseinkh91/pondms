package ir.viratech.pond_ms.model.config;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.config.base.BaseConfigEntry;



public class ConfigEntry extends BaseConfigEntry implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return this.getTitle();
	}
}
package ir.viratech.pond_ms.model.gradient;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.gradient.base.BaseGradientStop;

/**
 * The entity class "GradientStop".
 */

public class GradientStop extends BaseGradientStop implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return String.format("(%d,%d,%d)", this.getRed(), this.getGreen(), this.getBlue());
	}

	
	


}
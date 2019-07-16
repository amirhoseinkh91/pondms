package ir.viratech.pond_ms.model.gradient;

import java.util.Map.Entry;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.tilegenerator.Color;
import ir.viratech.pond_ms.model.gradient.base.BaseGradient;

/**
 * The entity class "Gradient".
 */

public class Gradient extends BaseGradient implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ir.viratech.commons.tilegenerator.Gradient toTileGeneratorGradient(){
		ir.viratech.commons.tilegenerator.Gradient gradient = new ir.viratech.commons.tilegenerator.Gradient();
		for (Object e: getStops().entrySet()) {
			Entry<Double, GradientStop> entry = (Entry<Double, GradientStop>) e;
			GradientStop stop = entry.getValue();
			gradient.addPoint(entry.getKey(), Color.fromDoubles(stop.getRed(), stop.getGreen(), stop.getBlue()));
		}
		gradient.freeze();
		return gradient;
	}

	@Override
	public String getDisplayString() {
		return this.getTitle();
	}


}
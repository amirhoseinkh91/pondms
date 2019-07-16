package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.VectorLayer;

/**
 * A DTO for class LeafLayerMetadata.
 *
 */
public class LeafLayerMetadataDTO {

	private String icon;
	private String color;
	private String width;
	private String fill;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public void loadFrom(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			this.setColor(vl.getLineColor());
			this.setFill(vl.getPolygonFill());
			this.setIcon(vl.getPointIcon());
			this.setWidth(vl.getLineWidth());
		}
	}

	public void saveTo(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			vl.setPointIcon(this.getIcon());
			vl.setLineColor(this.getColor());
			vl.setLineWidth(this.getWidth());
			vl.setPolygonFill(this.getFill());
		}

	}

}

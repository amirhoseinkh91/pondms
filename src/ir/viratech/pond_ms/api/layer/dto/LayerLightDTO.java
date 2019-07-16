package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.pond_ms.api.layer.base.BaseLayerLightDTO;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;


/**
 * A DTO for class Layer.
 *
 */
public class LayerLightDTO extends BaseLayerLightDTO {
	
	/**
	 * FieldInfoContext for LayerLightDTO
	 */
	public static class FieldInfoContext extends BaseLayerLightDTO.BaseFieldInfoContext {
		
	}

	//TODO Duplicate code must, must, must be refactored later!
	
	@Override
	protected String load_Type(Layer layer) {
		return layer.getType();
	}

	@Override
	protected Integer load_ChildCount(Layer layer) {
		if (Layer.TYPE_PARENT.equals(layer.getType())) 
			return ((ParentLayer)layer).getSubLayers().size();
		else
			return 0;
	}

	@Override
	protected Boolean load_Secret(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()) 
				|| Layer.TYPE_RASTER.equals(layer.getType()))
				return ((LeafLayer) layer).isSecret();
			return null;
	}

	@Override
	protected Boolean load_IsLabeled(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer)layer).isLabled();
		return null;
	}

	@Override
	protected String load_FormSchemaKey(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer)layer).getFormSchemaKey();
		return null;
	}
	
}

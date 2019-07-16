package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.pond_ms.api.layer.base.BaseLeafLayerLightDTO;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;


/**
 * A DTO for class LeafLayer.
 *
 */
public class LeafLayerLightDTO extends BaseLeafLayerLightDTO {
	
	/**
	 * FieldInfoContext for LeafLayerLightDTO
	 */
	public static class FieldInfoContext extends BaseLeafLayerLightDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected String load_Type(LeafLayer leafLayer) {
		return leafLayer.getType();
	}

	@Override
	protected String load_VectorObjectType(LeafLayer leafLayer) {
		if (Layer.TYPE_VECTOR.equals(leafLayer.getType()))
			return ((VectorLayer)leafLayer).getVectorObjectsType();
		return null;
	}

	@Override
	protected Boolean load_Secret(LeafLayer leafLayer) {
		return leafLayer.isSecret();
	}
	
}

package ir.viratech.pond_ms.model.layer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ir.viratech.pond_ms.model.layer.base.BaseVectorLayer;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

/**
 * The entity class "VectorLayer".
 */

public class VectorLayer extends BaseVectorLayer {
	private static final long serialVersionUID = 1L;


	@Override
	public String getType() {
		return Layer.TYPE_VECTOR;
	}


	@Override
	public Set<String> getMainDataFileExtension() {
		return new HashSet<>(Arrays.asList("shp", "kml"));
	}

	@Override
	public void onDelete() {
		for (GISVectorObject vectorObject : this.getCreatedVectorObjects()) {
			vectorObject.onDelete();
		}
		super.onDelete();
	}


	@Override
	public String getEntityTypeKey() {
		return "vectorLayer";
	}

}
package ir.viratech.pond_ms.model.layer;

import java.util.ArrayList;

import ir.viratech.pond_ms.model.layer.base.BaseParentLayer;
import ir.viratech.pond_ms.model.layer.dao.PondDAO;

/**
 * The entity class "ParentLayer".
 */

public class ParentLayer extends BaseParentLayer {
	private static final long serialVersionUID = 1L;

	@Override
	public String getType() {
		return Layer.TYPE_PARENT;
	}

	@Override
	public void onDelete() {
		for (Layer subLayer : new ArrayList<>(this.getCreatedSubLayers())) {
			subLayer.onDelete();
		}
		if (this.isPondRelated()) {
			Pond pond = PondDAO.getInstance().getByLayer(this);
			if (pond != null) {
				pond.onDelete();
				PondDAO.getInstance().delete(pond);
			}
		}
		super.onDelete();
	}

	@Override
	public String getEntityTypeKey() {
		return "parentLayer";
	}


}
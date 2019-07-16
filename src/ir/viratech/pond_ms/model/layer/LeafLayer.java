package ir.viratech.pond_ms.model.layer;

import java.util.Set;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.layer.base.BaseLeafLayer;

/**
 * The entity class "LeafLayer".
 */

public abstract class LeafLayer extends BaseLeafLayer implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	public abstract Set<String> getMainDataFileExtension();
		

}
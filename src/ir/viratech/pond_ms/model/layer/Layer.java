package ir.viratech.pond_ms.model.layer;

import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.OnDeleteProvider;
import ir.viratech.pond_ms.model.layer.base.BaseLayer;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.OrganizationBasedProvider;

import java.util.ArrayList;

/**
 * The entity class "Layer".
 */

public abstract class Layer extends BaseLayer implements UIDAndDisplayStringProvider, OrganizationBasedProvider, OnDeleteProvider, BaseEntityInterface{
	private static final long serialVersionUID = 1L;

	public static final String TYPE_PARENT = "parent";
	public static final String TYPE_VECTOR = "vector";
	public static final String TYPE_RASTER = "raster";

	@Override
	public String getDisplayString() {
		return this.getName();
	}

	public abstract String getType();



	@Override
	public Organization getOrganization() {
		return getMap().getOrganization();
	}

	@Override
	public void setOrganization(Organization organization) {
		//Do nothing!
	}

	@Override
	public void onDelete() {
		if(this.getParentLayer() != null){
			this.getParentLayer().removeFromSubLayers(this);
		} else {
			this.getParentMap().removeFromLayers(this);
		}
	}
}
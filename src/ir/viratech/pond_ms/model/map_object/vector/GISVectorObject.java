package ir.viratech.pond_ms.model.map_object.vector;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.pond_ms.commons.geo.GeoObject;
import ir.viratech.pond_ms.model.OnDeleteProvider;
import ir.viratech.pond_ms.model.map_object.vector.base.BaseGISVectorObject;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.OrganizationBasedProvider;

/**
 * The entity class "GISVectorObject".
 */

public abstract class GISVectorObject extends BaseGISVectorObject implements UIDAndDisplayStringProvider, OrganizationBasedProvider, OnDeleteProvider, BaseEntityInterface {
	private static final long serialVersionUID = 1L;

	public static final String TYPE__POINT = "Point";
	public static final String TYPE__POLYGON = "Polygon";
	public static final String TYPE__LINE = "LineString";
	public static final String TYPE__TOUR = "Tour";

	@Override
	public String getDisplayString() {
		return this.getName();
	}

	public abstract String getType();

	@Override
	public Organization getOrganization() {
		return getLayer().getOrganization();
	}

	@Override
	public void setOrganization(Organization organization) {
		//Do nothing!
	}

	public abstract GeoObject getGeoObject();

	@Override
	public void onDelete() {
		// TODO check to delete all things to be deleted
		if(this.getFormUID() != null){
			EntityInstanceMgr entityInstanceMgr;
			try {
				entityInstanceMgr = EntityInstanceMgrProvider.getMgr(this.getLayer().getFormSchemaKey());
				entityInstanceMgr.delete(this.getFormUID(), false);
			} catch (EntityTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EntityObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public EntityInstance getFormInstance(String extent, boolean hasAccessToDeletedEntities) {
		try {
			return EntityInstanceMgrProvider.getMgr(getLayer().getFormSchemaKey()).getByUid(getFormUID(), extent, hasAccessToDeletedEntities);
		} catch (EntityObjectNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (EntityTypeNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCityFromLayer() {
		return getLayer().getParentLayer().getName().substring(4).trim();
	}

	public String getStateFromLayer() {
		return getLayer().getParentLayer().getParentLayer().getName().substring(6).trim();
	}

}
package ir.viratech.pond_ms.api.map_object.vector.dto;

import java.util.Collections;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;

public class GISVectorObjectExpandedDTO extends GISVectorObjectFullDTO {
	@Override
	protected void save_Layer(GISVectorObject gISVectorObject, LayerLightDTO layerDto)
			throws BadDtoEntityModificationException {
		//do nothing!
	}
	
	@Override
	protected void save_FormInstance(GISVectorObject gISVectorObject, EntityInstance formInstance)
			throws BadDtoEntityModificationException {
		VectorLayer layer = null;
		EntityInstanceMgr entityInstanceMgr = null;
		try {
			layer = gISVectorObject.getLayer();
			entityInstanceMgr = EntityInstanceMgrProvider.getMgr(layer.getFormSchemaKey());
			EntityType entityType = EntityTypeMgr.getInstance().getByKey(layer.getFormSchemaKey());
			formInstance.setEntityType(entityType);
			formInstance.set("gis_object_uid", gISVectorObject.getExtuid());
			formInstance.set("layer_uid", layer.getExtuid());
			formInstance.set("name", this.getName());
			String oldFormUID = gISVectorObject.getFormUID();
			if(oldFormUID != null){
				entityInstanceMgr.addOrUpdate(oldFormUID, formInstance, false);	
			}else{
				formInstance = entityInstanceMgr.add(formInstance, false);
				gISVectorObject.setFormUID(formInstance.getExtuid());
			}
		} catch (EntityTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InconsistenceEntityVersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void save_Point(GISVectorObject gISVectorObject, Point point) throws BadDtoEntityModificationException {
		if (GISVectorObject.TYPE__POINT.equals(getType())) {
			if (point == null)
				throw new BadDtoEntityModificationException("The given dto must not be null for type point.");

			Collections.reverse(point.getCoordinates());
			((PointObject) gISVectorObject).setPoint(point.getJtsGeometry());
		}
	}
}

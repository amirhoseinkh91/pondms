package ir.viratech.pond_ms.model.layer.logic;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.base.BaseVectorLayerMgr;
import ir.viratech.pond_ms.model.layer.dao.VectorLayerDAO;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.layer.VectorLayer".
 */
public class VectorLayerMgr extends BaseVectorLayerMgr {


	
	@WriteTransactional
	public void importVectorData (Map<GISVectorObject, EntityInstance> data, VectorLayer layer) {
		cleanLayerData(layer);
		EntityInstanceMgr entityInstanceMgr = null;
		try {
			entityInstanceMgr = EntityInstanceMgrProvider.getMgr(layer.getFormSchemaKey());
		} catch (EntityTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (GISVectorObject geoObject : data.keySet()) {
			geoObject.setLayer(layer);
			EntityInstance ei = null;
			try {
				ei = entityInstanceMgr.add(data.get(geoObject), false);
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EntityTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			geoObject.setFormUID(ei.getExtuid());
			GISVectorObjectDAO.getInstance().save(geoObject);
		}
		layer.setVectorObjects(data.keySet());
		VectorLayerMgr.getInstance().update(layer);
	}
	
	
	/*
	 * To use dao instead of mgr because this method has called by other method which must be transactional!
	 */
	public void cleanLayerData (VectorLayer layer) {
//		EntityInstanceMgr entityInstanceMgr = null;
//		try {
//			entityInstanceMgr = EntityInstanceMgrProvider.getMgr(layer.getFormSchemaKey());
//		} catch (EntityTypeNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List<GISVectorObject> temp = new ArrayList<>();
		for (GISVectorObject gisVectorObject: layer.getVectorObjects()) {
			if (gisVectorObject.getFormUID() != null) {
				try {
					//TODO It's not transactional!!!
//					entityInstanceMgr.delete(gisVectorObject.getFormUID(), false);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
//				GISVectorObjectMgr.getInstance().delete(gisVectorObject);
				temp.add(gisVectorObject);
			}
		}
		for (GISVectorObject obj: temp) {
			layer.getVectorObjects().remove(obj);
			GISVectorObjectDAO.getInstance().delete(obj);
		}
		layer.getVectorObjects().clear();
		VectorLayerDAO.getInstance().update(layer);
	}
}
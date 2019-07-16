package ir.viratech.pond_ms.ui.cli.example_data;

import java.util.Date;
import java.util.List;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.base.BaseGISMapMgr;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.base.BaseParentLayerMgr;
import ir.viratech.pond_ms.model.layer.base.BaseVectorLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

public class ExampleLayer {
	
	protected void addData(GISMap gisMap) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		
		BaseParentLayerMgr parentLayerMgrInstance = BaseParentLayerMgr.getInstance();
		
		ParentLayer parentLayer = ParentLayerMgr.getInstance().createNew();
		parentLayer.setMap(gisMap);
		parentLayer.setName("firstParentLayer");
		parentLayerMgrInstance.add(parentLayer);
		
		ParentLayer parentLayer2 = ParentLayerMgr.getInstance().createNew();
		parentLayer2.setMap(gisMap);
		parentLayer2.setName("secondParentLayer");
		parentLayer2.setParentLayer(parentLayer);
		parentLayerMgrInstance.add(parentLayer2);
		parentLayer.addToSubLayers(parentLayer2);
		
		BaseVectorLayerMgr vectorLayerMgrInstance = BaseVectorLayerMgr.getInstance();
		
		VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
		vectorLayer.setMap(gisMap);
		vectorLayer.setParentLayer(parentLayer);
		vectorLayer.setName("firstVectorLayer");
		vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__POINT);
		vectorLayerMgrInstance.add(vectorLayer);
		vectorLayer.setFormSchemaKey("station");
		parentLayer.addToSubLayers(vectorLayer);
		parentLayerMgrInstance.update(parentLayer);
	
		VectorLayer vectorLayer2 = VectorLayerMgr.getInstance().createNew();
		vectorLayer2.setMap(gisMap);
		vectorLayer2.setParentLayer(parentLayer2);
		vectorLayer2.setName("secondVectorLayer");
		vectorLayer2.setFormSchemaKey("river");
		vectorLayer2.setVectorObjectsType(GISVectorObject.TYPE__LINE);
		vectorLayerMgrInstance.add(vectorLayer2);
		parentLayer2.addToSubLayers(vectorLayer2);
		parentLayerMgrInstance.update(parentLayer2);
		
		gisMap = GISMapMgr.getInstance().reget(gisMap);
		gisMap.addToLayers(parentLayer);
		BaseGISMapMgr.getInstance().update(gisMap);
	}
	
	protected void addAnotherData(GISMap gisMap) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		
		BaseParentLayerMgr parentLayerMgrInstance = BaseParentLayerMgr.getInstance();
		
		ParentLayer parentLayer = ParentLayerMgr.getInstance().createNew();
		parentLayer.setMap(gisMap);
		parentLayer.setName("thirdParentLayer");
		parentLayerMgrInstance.add(parentLayer);
		
		ParentLayer parentLayer3 = ParentLayerMgr.getInstance().createNew();
		parentLayer3.setMap(gisMap);
		parentLayer3.setName("for time series test");
		parentLayer3.setCreationDate(new Date());
		parentLayer3.setPondRelated(true);
		parentLayerMgrInstance.add(parentLayer3);
		
		ParentLayer parentLayer2 = ParentLayerMgr.getInstance().createNew();
		parentLayer2.setMap(gisMap);
		parentLayer2.setName("fourthParentLayer");
		parentLayer2.setParentLayer(parentLayer);
		parentLayerMgrInstance.add(parentLayer2);
		parentLayer.addToSubLayers(parentLayer2);
		
		BaseVectorLayerMgr vectorLayerMgrInstance = BaseVectorLayerMgr.getInstance();
		
		VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
		vectorLayer.setMap(gisMap);
		vectorLayer.setParentLayer(parentLayer);
		vectorLayer.setFormSchemaKey("road");
		vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__LINE);
		vectorLayer.setName("thirdVectorLayer");
		vectorLayerMgrInstance.add(vectorLayer);
		parentLayer.addToSubLayers(vectorLayer);
		parentLayerMgrInstance.update(parentLayer);
	
		VectorLayer vectorLayer2 = VectorLayerMgr.getInstance().createNew();
		vectorLayer2.setMap(gisMap);
		vectorLayer2.setParentLayer(parentLayer2);
		vectorLayer2.setName("fourthVectorLayer");
		vectorLayer2.setFormSchemaKey("garden");
		vectorLayer2.setVectorObjectsType(GISVectorObject.TYPE__POLYGON);
		vectorLayerMgrInstance.add(vectorLayer2);
		parentLayer2.addToSubLayers(vectorLayer2);
		parentLayerMgrInstance.update(parentLayer2);
		
		gisMap = GISMapMgr.getInstance().reget(gisMap);
		gisMap.addToLayers(parentLayer);
		BaseGISMapMgr.getInstance().update(gisMap);
	}
	
	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<GISMap> gisMaps = GISMapMgr.getInstance().list();
		if(gisMaps.size() < 2){
			ExamplePortal.main(args);
			gisMaps = GISMapMgr.getInstance().list();
		}
		new ExampleLayer().addData(gisMaps.get(0));
		new ExampleLayer().addAnotherData(gisMaps.get(1));
	}
}

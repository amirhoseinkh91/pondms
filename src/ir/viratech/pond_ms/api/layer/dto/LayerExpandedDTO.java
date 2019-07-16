package ir.viratech.pond_ms.api.layer.dto;

import java.util.List;
import java.util.Set;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.layer.base.BaseLayerExpandedDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectExpandedDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.RasterLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr;


/**
 * A DTO for class Layer.
 *
 */
public class LayerExpandedDTO extends BaseLayerExpandedDTO {
	
	/**
	 * FieldInfoContext for LayerExpandedDTO
	 */
	public static class FieldInfoContext extends BaseLayerExpandedDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<ParentLayer, LayerLightDTO> createEntityByDtoFinder_ParentLayer() {
			return new EntityByDtoFinder_ByUid<>(ParentLayerMgr.getInstance());
		}
		
	}

	@Override
	protected String load_FormSchemaKey(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer) layer).getFormSchemaKey();
		return null;
	}

	@Override
	protected void save_FormSchemaKey(Layer layer, String formSchemaKey) throws BadDtoEntityModificationException {
		if(Layer.TYPE_VECTOR.equals(layer.getType())){
			((VectorLayer) layer).setFormSchemaKey(formSchemaKey);
		}
	}

	@Override
	protected String load_VectorObjectsType(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer) layer).getVectorObjectsType();
		return null;
	}

	@Override
	protected void save_VectorObjectsType(Layer layer, String vectorObjectsType)
			throws BadDtoEntityModificationException {
		if (Layer.TYPE_VECTOR.equals(layer.getType())){
			((VectorLayer) layer).setVectorObjectsType(vectorObjectsType);
		}
	}

	@Override
	protected PlainCollectionDTO<Layer, LayerExpandedDTO> load_SubLayers(Layer layer) {
		if (Layer.TYPE_PARENT.equals(layer.getType())) {
			ParentLayer parentLayer = (ParentLayer) layer;

			return PlainCollectionDTO.createAndLoad(parentLayer.getSubLayers(), LayerExpandedDTO.class);
		}
		return null;
	}

	@Override
	protected void save_SubLayers(Layer layer, PlainCollectionDTO<Layer, LayerExpandedDTO> subLayers)
			throws BadDtoEntityModificationException {
		if(Layer.TYPE_PARENT.equals(layer.getType())){
			ParentLayer parentLayer = (ParentLayer) layer;
			List<Layer> layerSubLayersSet = parentLayer.getCreatedSubLayers();
			if(subLayers != null){				
				for (LayerExpandedDTO layerDTO : subLayers.getItems()) {
					Layer newLayer = null;
					if(Layer.TYPE_PARENT.equals(layerDTO.getType())){
						newLayer = ParentLayerMgr.getInstance().createNew();
					} else if(Layer.TYPE_VECTOR.equals(layerDTO.getType())){
						newLayer = VectorLayerMgr.getInstance().createNew();
					} else if(Layer.TYPE_RASTER.equals(layerDTO.getType())){
						newLayer = RasterLayerMgr.getInstance().createNew();
					}
					newLayer.setParentLayer(parentLayer);
					layerDTO.saveTo(newLayer);
					layerSubLayersSet.add(newLayer);
				}
			}
		}
	}

	@Override
	protected PlainCollectionDTO<GISVectorObject, GISVectorObjectExpandedDTO> load_VectorObjects(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vectorLayer = (VectorLayer) layer;

			return PlainCollectionDTO.createAndLoad(vectorLayer.getVectorObjects(), GISVectorObjectExpandedDTO.class);
		}
		return null;
	}

	@Override
	protected void save_VectorObjects(Layer layer,
			PlainCollectionDTO<GISVectorObject, GISVectorObjectExpandedDTO> vectorObjects)
			throws BadDtoEntityModificationException {
		if(Layer.TYPE_VECTOR.equals(layer.getType())){
			VectorLayer vectorLayer = (VectorLayer) layer;
			Set<GISVectorObject> layerVectorObjectsSet = vectorLayer.getCreatedVectorObjects();
			if(vectorObjects != null){				
				for (GISVectorObjectExpandedDTO gisVectorObjectDTO : vectorObjects.getItems()) {
					LayerLightDTO layerLightDTO = new LayerLightDTO();
					layerLightDTO.loadFrom(vectorLayer);
					gisVectorObjectDTO.setLayer(layerLightDTO);
					if (GISVectorObject.TYPE__POINT.equals(this.getVectorObjectsType())){
						PointObject pointObject = PointObjectMgr.getInstance().createNew();
						pointObject.setLayer(vectorLayer);
						gisVectorObjectDTO.createSaverForPointObject().saveTo(pointObject);
						layerVectorObjectsSet.add(pointObject);
					} else if (GISVectorObject.TYPE__LINE.equals(this.getVectorObjectsType())){
						LineObject lineObject = LineObjectMgr.getInstance().createNew();
						lineObject.setLayer(vectorLayer);
						gisVectorObjectDTO.createSaverForLineObject().saveTo(lineObject);
						layerVectorObjectsSet.add(lineObject);
					} else if (GISVectorObject.TYPE__POLYGON.equals(this.getVectorObjectsType())){
						PolygonObject polygonObject = PolygonObjectMgr.getInstance().createNew();
						polygonObject.setLayer(vectorLayer);
						gisVectorObjectDTO.createSaverForPolygonObject().saveTo(polygonObject);
						layerVectorObjectsSet.add(polygonObject);
					}			
				}
			}
		}
	}
	
	@Override
	public void saveTo(Layer layer) throws BadDtoEntityModificationException {
		GISMap map = GISMapMgr.getInstance().findOne();
		layer.setMap(map);
		super.saveTo(layer);
		if(layer.getParentLayer()== null){
			map.addToLayers(layer);
		}
	}
	
}

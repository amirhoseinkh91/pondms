package ir.viratech.pond_ms.model.layer.logic;


import java.util.ArrayList;
import java.util.List;

import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.pond_ms.model.gismap.dao.GISMapDAO;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.base.BaseLayerMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.layer.Layer".
 */
public class LayerMgr extends BaseLayerMgr {


    @Override
    protected void checkAndDelete(Layer obj) throws EntityModificationException {
        obj.onDelete();
        if (obj.getParentLayer() != null) {
            getDAO().update(obj.getParentLayer());
        } else {
            GISMapDAO.getInstance().update(obj.getParentMap());
        }
    }

    public List<Layer> getAllSubLayers(Layer layer) {
        List<Layer> result = new ArrayList<>();
        result.add(layer);
        if (!(layer instanceof ParentLayer))
            return result;
        ParentLayer parentLayer = (ParentLayer) layer;
        for (Layer subLayer : parentLayer.getCreatedSubLayers())
            result.addAll(getAllSubLayers(subLayer));
        return result;
    }

}
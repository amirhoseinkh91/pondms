package ir.viratech.pond_ms.model.layer.logic;


import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.base.BaseParentLayerMgr;

import java.util.ArrayList;
import java.util.List;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.layer.ParentLayer".
 */
public class ParentLayerMgr extends BaseParentLayerMgr {


    public ArrayList<LeafLayer> getLeafSubLayers(ParentLayer layer) {
        return getLeafSubLayers_recursive(layer, new ArrayList<>());
    }

    private ArrayList<LeafLayer> getLeafSubLayers_recursive(Layer layer, ArrayList<LeafLayer> list) {
        if (!Layer.TYPE_PARENT.equals(layer.getType())) {
            list.add((LeafLayer) layer);
            return list;
        } else {
            for (Layer child : ((ParentLayer) layer).getSubLayers())
                list = getLeafSubLayers_recursive(child, list);
            return list;
        }
    }

    public ParentLayer getByCityName(String cityName) {
        return this.getDAO().getByCityName(cityName);
    }

    public ParentLayer getByCityNameLike(String cityName) {
        return this.getDAO().getByCityNameLike(cityName);
    }

    public ParentLayer getByName(String parentLayerName) {
        return this.getDAO().getByName(parentLayerName);
    }

    public List<ParentLayer> getProvinces() {
        return this.getDAO().getByProvince();
    }

    public List<ParentLayer> getByProvinceName(String provinceName) {
        return this.getDAO().getByProvinceName(provinceName);
    }
}
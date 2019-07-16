package ir.viratech.pond_ms.api.filter;

import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class FilterConfig {
    public static Map<String, String> getCity(String cityName) {
        Map<String, String> configs = new HashMap();
        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByCityName(cityName);
        if (parentLayer != null)
            for (Layer sublayer : parentLayer.getSubLayers()) {
                String name = sublayer.getName();
                String extuid = sublayer.getExtuid();
                configs.put(name, extuid);
            }
        return configs;
    }

}

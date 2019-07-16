package ir.viratech.pond_ms.model.main_city_config;

import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class ChildCityConfig {
    public static Map<String, String> getCity(String cityName, String cityUid) {
        Map<String, String> configs = new HashMap();
        ParentLayer parentLayer = makeParentLayerByCityNameOrUid(cityName , cityUid);
        if (parentLayer != null) {
            for (Layer sublayer : parentLayer.getSubLayers()) {
                String name = sublayer.getName();
                String extuid = sublayer.getExtuid();
                configs.put(name, extuid);
            }
        }
        return configs;
    }

    private static ParentLayer makeParentLayerByCityNameOrUid(String cityName , String cityUid){
        ParentLayer parentLayer = null;

        if (cityName != null && !cityName.equals("")){
            parentLayer = ParentLayerMgr.getInstance().getByCityName(cityName);
        }else if (cityUid != null && !cityUid.equals("")){
            parentLayer = ParentLayerMgr.getInstance().getByExtuid(cityUid);
        }

        return parentLayer;
    }

}

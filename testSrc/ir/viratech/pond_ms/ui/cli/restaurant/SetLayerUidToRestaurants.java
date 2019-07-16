package ir.viratech.pond_ms.ui.cli.restaurant;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;

import java.util.List;

public class SetLayerUidToRestaurants {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();
        setLayerUidToRestaurants();
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private static void setLayerUidToRestaurants() {
        List<PointObject> allRestaurants = new RestaurantCRUD().getAllRestaurants();
        for (PointObject p : allRestaurants) {
            EntityInstance formInstance = p.getFormInstance("full", true);
            formInstance.set("layer_uid" , p.getLayer().getExtuid());
        }
    }

}

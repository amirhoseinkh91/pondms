package ir.viratech.pond_ms.ui.cli.restaurant;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class RestaurantCRUD {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();
        deleteAllRestaurants();
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private static void deleteAllRestaurants() {
        List<PointObject> pointObjectList = PointObjectMgr.getInstance().list();
        int i = 0;
        for (PointObject pointObject : pointObjectList) {
            try{
                EntityType restaurantEntityType = null;
                try {
                    restaurantEntityType = EntityTypeMgr.getInstance().getByKey("Restaurant");
                } catch (Exception e){
                    continue;
                }
                boolean equals = pointObject.getFormInstance("full", false).getEntityType().equals(restaurantEntityType);
                if (equals){
                    PointObjectMgr.getInstance().delete(pointObject);
                    print("item #" + (++i) + " from " + pointObjectList.size() + " deleted.");
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
    }

    public List<PointObject> getAllRestaurants(){
        List<PointObject> results = new ArrayList<>();
        List<PointObject> pointObjectList = PointObjectMgr.getInstance().list();
        int i = 0;
        for (PointObject pointObject : pointObjectList) {
            try{
                EntityType restaurantEntityType = null;
                try {
                    restaurantEntityType = EntityTypeMgr.getInstance().getByKey("Restaurant");
                } catch (Exception e){
                    continue;
                }
                boolean equals = pointObject.getFormInstance("full", false).getEntityType().equals(restaurantEntityType);
                if (equals){
                    results.add(pointObject);
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
        return results;
    }

    private static void print(Object o){
        System.out.println(o);
    }

}

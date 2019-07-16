package ir.viratech.pond_ms.core.db.cli;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.util.List;

/**
 * @Author amir
 * @CreatedAt 6/30/19
 */
public class FixWestAzarbayjanDeletedData {

    private MongoDBManager mongoDBManager;

    public static void main(String[] args) {

        ApplicationContextUtil.initializeCliApplicationContext();

        new FixWestAzarbayjanDeletedData().start();

    }

    private void start() {

        mongoDBManager = (MongoDBManager) ApplicationContextProvider.getInitializedApplicationContext().getBean("mongoDBManager");

        List<ParentLayer> azarbayjanLayer = ParentLayerMgr.getInstance().getByProvinceName("آذربایجان غربی");
        for (ParentLayer p : azarbayjanLayer) {
            for (Layer cityLayer : p.getSubLayers()) {
                ParentLayer parentCityLayer = (ParentLayer) cityLayer;
                System.out.println("============= " + parentCityLayer.getName() + " ================");
                for (Layer var : parentCityLayer.getSubLayers()) {
                    VectorLayer vectorLayer = (VectorLayer) var;
                    System.out.println(vectorLayer.getName());
                    unDeleteByUid(vectorLayer.getExtuid(), vectorLayer.getFormSchemaKey());
                }

            }

        }

    }

    private void unDeleteByUid(String extuid, String formSchemaKey) {

        String collectionName = getCollectionName(formSchemaKey);

        if (collectionName != null) {
            DBObject query = new BasicDBObject("layer_uid", extuid);

            BasicDBObject setData = new BasicDBObject();
            setData.append("_isDeleted", false);
            BasicDBObject update = new BasicDBObject();
            update.append("$set", setData);
            mongoDBManager.getCollection(collectionName).updateMulti(query, update);
        }

    }

    private String getCollectionName(String formSchemaKey) {
        switch (formSchemaKey) {
            case "Restaurant":
                return "restaurant_col";
            case "city":
                return "city_col";
            case "Things_To_Do":
                return "things_to_do_col";
            case "Hotel":
                return "hotel_col";
            default:
                return null;
        }
    }


}

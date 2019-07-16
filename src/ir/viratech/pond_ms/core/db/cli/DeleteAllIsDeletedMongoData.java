package ir.viratech.pond_ms.core.db.cli;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class DeleteAllIsDeletedMongoData {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            List<String> keys = Arrays.asList("Things_To_Do", "Restaurant", "Hotel");
            for (String key : keys) {
                DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey(key));
                BasicDBObject query = new BasicDBObject();
                query.put("_isDeleted", true);
                collection.remove(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

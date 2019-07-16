package ir.viratech.pond_ms.core.db.flyway.migrations;

import com.mongodb.*;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.sql.Connection;

public class V64__changeCMCollectionsToSupportTags extends BaseJdbcMigration {
    final String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/update_gis_forms.json";

    @Override
    public void migrate(Connection connection) throws Exception {
        updateCollections("Hotel");
        updateCollections("Restaurant");
        updateCollections("Things_To_Do");
        importForms(VECTOR_FORMS_FILE);
    }

    private void updateCollections(String type) {
        EntityType typeKey = EntityTypeMgr.getInstance().getByKey(type);
        DBCollection collection = EntityInstanceDAO.getInstance().getCollection(typeKey);
        DBCursor dbObjects = collection.find();
        for (DBObject node : dbObjects) {
            removeFourSquareContents(type, collection, node);
            convertCollectionStringToArrayAndUpdate(collection, node, "Tags");
            convertCollectionStringToArrayAndUpdate(collection, node, "Features");
            convertCollectionStringToArrayAndUpdate(collection, node, "FoursquareTags");
        }
    }

    private void removeFourSquareContents(String type, DBCollection collection, DBObject node) {
        if (type.equals("Restaurant")) {
            node.removeField("FoursquarePhotos");
            node.removeField("FoursquareTags");
            updateMongo(collection, node);
        }
    }

    private void convertCollectionStringToArrayAndUpdate(DBCollection collection, DBObject node, String field) {
        if (MongoDBManager.getInstance().convertToObjectNode(node).has(field)) {
            String lists = MongoDBManager.getInstance().convertToObjectNode(node).get(field).asText().trim();
            if (!StringUtils.isEmpty(lists)) {
                String[] split = splitter(collection, field, lists);
                node.removeField(field);
                BasicDBList arrayNode = new BasicDBList();
                for (String s : split) {
                    if (notValidString(s)) continue;
                    arrayNode.add(s.trim());
                }
                node.put(field, arrayNode);
                updateMongo(collection, node);
            }
        }
    }

    private boolean notValidString(String s) {
        boolean flag = false;
        if (s.contains("سفر")) {
            flag = true;
        }
        if (s.contains("null")) {
            flag = true;
        }
        if (s.contains("ظبیعی جنگل")) {
            flag = true;
        }
        if (s.contains("ایران یزد خرید و مد")) {
            flag = true;
        }
        if (s.contains("تفریحاتهوایی")) {
            flag = true;
        }
        if (s.contains("»لیلطبلرطا")) {
            flag = true;
        }
        if (s.contains("گردش و سفر")) {
            flag = true;
        }
        return flag;
    }

    private String[] splitter(DBCollection collection, String field, String lists) {
        String[] split;
        if (field.equals("Tags") && collection.getName().equals("things_to_do_col")) {
            split = lists.split(",");
        } else {
            split = lists.split("،");
        }
        return split;
    }

    private void updateMongo(DBCollection collection, DBObject node) {
        Object id = node.get("_id");
        BasicDBObject oldNode = new BasicDBObject().append("_id", id);
        collection.update(oldNode, node);
    }

    private void importForms(String fileAddress) throws DuplicateEnumTypeException, InvalidEntitySchemaException, IOException {
        ir.viratech.commons.cm.util.EntityTypeImporter
                .importFromUrl(EntityTypeImporter.class.getResource(fileAddress));
    }
}

package ir.viratech.pond_ms.core.db.flyway.migrations;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.entity_type.dao.EntityTypeDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class V62__AddTourAndEventToCM extends BaseJdbcMigration {

    private final static String TOUR_FORM_FILE = "../../db/flyway/migrations/data/vector_object_forms/tour/tourEntityTypeInfo.json";
    private final static String EVENT_FORM_FILE = "../../db/flyway/migrations/data/vector_object_forms/event/eventEntityTypeInfo.json";

    @Override
    public void migrate(Connection connection) throws Exception {
        removeAgencyFromCM();
        removeAgencyFromSubLayers();
        importForms(EVENT_FORM_FILE);
        importForms(TOUR_FORM_FILE);
        addTourAndEventToSubLayers();
    }


    private void removeAgencyFromCM() throws UnknownHostException {
        EntityType entityType = EntityTypeMgr.getInstance().getByKey("Agency");
        EntityTypeDAO.getInstance().startWriteTransaction();
        EntityTypeMgr.getInstance().delete(entityType);
        DBCollection dbCollection = EntityInstanceDAO.getInstance().getCollection(entityType);
        String collectionName = dbCollection.getName();
        String historyCollection = collectionName + "_History";
        String oldTourCollection = "tour_col";
        MongoClient client = new MongoClient();
        DB pondMS = client.getDB("PondMS");
        pondMS.getCollection(historyCollection).drop();
        pondMS.getCollection(oldTourCollection).drop();
        dbCollection.drop();
        EntityTypeDAO.getInstance().finishWriteTransaction();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++                                                           +++");
        System.out.println("          The entityType '" + entityType.getKey() + "' deleted successfully                 ");
        System.out.println("          The entityInstance '" + collectionName + "' deleted successfully                 ");
        System.out.println("          The entityInstanceHistory '" + historyCollection + "' deleted successfully                 ");
        System.out.println("          The entityInstance 'tour_col' deleted successfully                 ");
        System.out.println("+++                                                           +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


    private void removeAgencyFromSubLayers() {
        List<ParentLayer> cityParentLayers = new ArrayList<>();
        List<ParentLayer> parentLayers = ParentLayerMgr.getInstance().list();
        findCitiesInParentLayers(parentLayers, cityParentLayers);
        for (ParentLayer layer : cityParentLayers) {
            List<Layer> subLayers = layer.getSubLayers();
            Iterator<Layer> subLayersIteration = subLayers.iterator();
            while (subLayersIteration.hasNext()) {
                Layer sublayer = subLayersIteration.next();
                String name = sublayer.getName();
                if (name.startsWith(MessageService.getMessage("agency.space"))) {
                    subLayersIteration.remove();
                }
            }
            LayerMgr.getInstance().update(layer);
        }
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++                                                           +++");
        System.out.println("          Agency Removed From Sub Layers                ");
        System.out.println("+++                                                           +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void importForms(String fileAddress) throws DuplicateEnumTypeException, InvalidEntitySchemaException, IOException {
        ir.viratech.commons.cm.util.EntityTypeImporter
                .importFromUrl(EntityTypeImporter.class.getResource(fileAddress));
    }

    private void addTourAndEventToSubLayers() {
        List<ParentLayer> cityParentLayers = new ArrayList<>();
        List<ParentLayer> parentLayers = ParentLayerMgr.getInstance().list();
        findCitiesInParentLayers(parentLayers, cityParentLayers);
        for (ParentLayer layer : cityParentLayers) {
            VectorLayer tourToSubLayers = addEntityTypeToCM(layer, "تور", "tour");
            VectorLayer agencyToSubLayers = addEntityTypeToCM(layer, "آژانس", "agency");
            VectorLayer tourLeaderToSubLayers = addEntityTypeToCM(layer, "تور لیدر", "tourLeader");
            VectorLayer eventToSubLayers = addEntityTypeToCM(layer, "رویداد", "event");
            layer.addToSubLayers_AndReverse(tourToSubLayers);
            layer.addToSubLayers_AndReverse(agencyToSubLayers);
            layer.addToSubLayers_AndReverse(tourLeaderToSubLayers);
            layer.addToSubLayers_AndReverse(eventToSubLayers);
            ParentLayerMgr.getInstance().update(layer);
        }
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++                                                           +++");
        System.out.println("          TOUR, EVENT, AGENCY, TOUR LEADER ADDED TO SUB LAYERS                ");
        System.out.println("          EVERY THINGS DONE!!!                ");
        System.out.println("+++                                                           +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private VectorLayer addEntityTypeToCM(ParentLayer layer, String layerName, String keyName) {
        VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
        vectorLayer.setName(layerName);
        vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__POINT);
        vectorLayer.setSecret(false);
        vectorLayer.setLabled(true);
        vectorLayer.setFormSchemaKey(keyName);
        vectorLayer.setMap(layer.getMap());
        return vectorLayer;
    }

    private void findCitiesInParentLayers(List<ParentLayer> parentLayers, List<ParentLayer> cityParentLayers) {
        for (ParentLayer parentLayer : parentLayers) {
            String name = parentLayer.getName();
            if (name.startsWith(MessageService.getMessage("city.space"))) {
                cityParentLayers.add(parentLayer);
            }
        }
    }

}

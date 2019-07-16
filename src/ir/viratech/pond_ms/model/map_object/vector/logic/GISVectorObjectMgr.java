package ir.viratech.pond_ms.model.map_object.vector.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.map_object.vector.base.BaseGISVectorObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO;

import java.io.IOException;

/**
 * Mgr class for entity
 * "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject".
 */
public class GISVectorObjectMgr extends BaseGISVectorObjectMgr {

    @Override
    public Long add(GISVectorObject obj) {
        if (GISVectorObject.TYPE__POINT.equals(obj.getType()))
            return PointObjectMgr.getInstance().add((PointObject) obj);
        else if (GISVectorObject.TYPE__LINE.equals(obj.getType()))
            return LineObjectMgr.getInstance().add((LineObject) obj);
        else if (GISVectorObject.TYPE__POLYGON.equals(obj.getType()))
            return PolygonObjectMgr.getInstance().add((PolygonObject) obj);
        else
            return null;
    }

    public SimpleListAndTotalCount<GISVectorObject> getLayerObjects(long start, int len, VectorLayer vectorLayer) {
        return GISVectorObjectDAO.getInstance().getLayerObjects(start, len, vectorLayer);
    }

    @Override
    protected void checkAndDelete(GISVectorObject obj) throws EntityModificationException {
        // TODO verify these steps for delete object
        obj.onDelete();
        this.getDAO().delete(obj);
    }

    @WriteTransactional
    public void incFavoriteCountToObject(String extuid) {
        GISVectorObject gisVectorObject = this.getDAO().getByExtuid(extuid);
        Integer favoriteCount = gisVectorObject.getFavoriteCount();
        gisVectorObject.setFavoriteCount(favoriteCount + 1);
        this.getDAO().update(gisVectorObject);
    }

    @WriteTransactional
    public void incReviewCountToObject(String extuid) {
        GISVectorObject gisVectorObject = this.getDAO().getByExtuid(extuid);
        Integer reviewCount = gisVectorObject.getReviewCount();
        gisVectorObject.setReviewCount(reviewCount + 1);
        this.getDAO().update(gisVectorObject);
    }

    @WriteTransactional
    public void decFavoriteCountToObject(String extuid) {
        GISVectorObject gisVectorObject = this.getDAO().getByExtuid(extuid);
        Integer favoriteCount = gisVectorObject.getFavoriteCount();
        if (favoriteCount > 0) {
            gisVectorObject.setFavoriteCount(favoriteCount - 1);
            this.getDAO().update(gisVectorObject);
        }
    }

    @WriteTransactional
    public void decReviewCountToObject(String extuid) {
        GISVectorObject gisVectorObject = this.getDAO().getByExtuid(extuid);
        Integer reviewCount = gisVectorObject.getReviewCount();
        if (reviewCount > 0) {
            gisVectorObject.setReviewCount(reviewCount - 1);
            this.getDAO().update(gisVectorObject);
        }
    }


    @ReadTransactional
    public JsonNode getByUsername(String collection, String username)
            throws InstantiationException, IllegalAccessException, JsonProcessingException, IOException {
        MongoDBManager manager = MongoDBManager.getInstance();
        BaseMongoQueries mongoQueries = BaseMongoQueries.class.newInstance();
        String find = mongoQueries.find(mongoQueries.and(mongoQueries.isDeleted(false), mongoQueries.equals("user_name", username)));
        String query = mongoQueries.baseQueryMaker((find), collection, true);
        return manager.executeQuery(query);
    }

}
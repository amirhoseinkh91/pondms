package ir.viratech.pond_ms.api.map_object.vector.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.SaverDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.commons.api.search.InvalidDtoException;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;
import ir.viratech.pond_ms.api.map_object.vector.base.BaseGISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.api.time_series.dto.CategoryLightDTO;
import ir.viratech.pond_ms.commons.geo.LineString;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;
import ir.viratech.pond_ms.model.time_series.Category;

import java.util.Set;

/**
 * A DTO for class GISVectorObject.
 */
public class GISVectorObjectFullDTO extends BaseGISVectorObjectFullDTO {

    /**
     * FieldInfoContext for GISVectorObjectFullDTO
     */
    public static class FieldInfoContext extends BaseGISVectorObjectFullDTO.BaseFieldInfoContext {

        @Override
        protected EntityByDtoFinder<VectorLayer, LayerLightDTO> createEntityByDtoFinder_Layer() {
            return new EntityByDtoFinder_ByUid<VectorLayer, LayerLightDTO>(VectorLayerMgr.getInstance());
        }

        @Override
        protected EntityByDtoFinder<Organization, OrganizationFullDTO> createEntityByDtoFinder_Organization() {
            return new EntityByDtoFinder_ByUid<Organization, OrganizationFullDTO>(OrganizationMgr.getInstance());
        }

    }

    @Override
    protected String load_Type(GISVectorObject gISVectorObject) {
        return gISVectorObject.getType();
    }

    public SaverDTO<PointObject> createSaverForPointObject() {
        return new SaverDTO<PointObject>() {
            @Override
            public void saveTo(PointObject pointObject) throws BadDtoEntityModificationException {
                GISVectorObjectFullDTO dto = GISVectorObjectFullDTO.this;
                dto.saveTo(pointObject);
            }
        };
    }

    public SaverDTO<LineObject> createSaverForLineObject() {
        return new SaverDTO<LineObject>() {
            @Override
            public void saveTo(LineObject lineObject) throws BadDtoEntityModificationException {
                GISVectorObjectFullDTO dto = GISVectorObjectFullDTO.this;
                dto.saveTo(lineObject);
            }
        };
    }

    public SaverDTO<PolygonObject> createSaverForPolygonObject() {
        return new SaverDTO<PolygonObject>() {
            @Override
            public void saveTo(PolygonObject polygonObject) throws BadDtoEntityModificationException {
                GISVectorObjectFullDTO dto = GISVectorObjectFullDTO.this;
                dto.saveTo(polygonObject);
            }
        };
    }

    @Override
    protected Point load_Point(GISVectorObject gISVectorObject) {
        if (GISVectorObject.TYPE__POINT.equals(gISVectorObject.getType()))
            return new Point(((PointObject) gISVectorObject).getPoint());
        return null;
    }

    @Override
    protected void save_Point(GISVectorObject gISVectorObject, Point point) throws BadDtoEntityModificationException {
        if (GISVectorObject.TYPE__POINT.equals(getType())) {
            if (point == null)
                throw new BadDtoEntityModificationException("The given dto must not be null for type point.");

            ((PointObject) gISVectorObject).setPoint(point.getJtsGeometry());
        }
    }

    @Override
    protected LineString load_Line(GISVectorObject gISVectorObject) {
        if (GISVectorObject.TYPE__LINE.equals(gISVectorObject.getType()))
            return new LineString(((LineObject) gISVectorObject).getLine());
        return null;
    }

    @Override
    protected void save_Line(GISVectorObject gISVectorObject, LineString line)
            throws BadDtoEntityModificationException {
        if (GISVectorObject.TYPE__LINE.equals(getType())) {
            if (line == null)
                throw new BadDtoEntityModificationException("The given dto must not be null for type line.");

            ((LineObject) gISVectorObject).setLine(line.getJtsGeometry());
        }

    }

    @Override
    protected Polygon load_Polygon(GISVectorObject gISVectorObject) {
        if (GISVectorObject.TYPE__POLYGON.equals(gISVectorObject.getType()))
            return new Polygon(((PolygonObject) gISVectorObject).getPolygon());
        return null;
    }

    @Override
    protected void save_Polygon(GISVectorObject gISVectorObject, Polygon polygon)
            throws BadDtoEntityModificationException {
        if (GISVectorObject.TYPE__POLYGON.equals(getType())) {
            if (polygon == null)
                throw new BadDtoEntityModificationException("The given dto must not be null for type polygon.");

            ((PolygonObject) gISVectorObject).setPolygon(polygon.getJtsGeometry());
        }
    }

    @Override
    protected void save_FormInstance(GISVectorObject gISVectorObject, EntityInstance formInstance)
            throws BadDtoEntityModificationException {
        VectorLayer layer = null;
        EntityInstanceMgr entityInstanceMgr = null;
        try {
            if (formInstance.getUid() == null) {
                layer = getFieldInfoContext().findByDto_Layer(getLayer());
                entityInstanceMgr = EntityInstanceMgrProvider.getMgr(layer.getFormSchemaKey());
                EntityType entityType = EntityTypeMgr.getInstance().getByKey(layer.getFormSchemaKey());
                formInstance.setEntityType(entityType);
                formInstance.set("gis_object_uid", gISVectorObject.getExtuid());
                formInstance.set("layer_uid", layer.getExtuid());
                if (formInstance.get("name") instanceof NullNode || formInstance.get("name") == null)
                    formInstance.set("name", this.getName());
                else
                    gISVectorObject.setName(formInstance.get("name").asText());
                // add default Rate value to MongoDB
                if (formInstance.get("Rate") instanceof NullNode || formInstance.get("Rate") == null)
                    formInstance.set("Rate", 0);
                // add IntrinsicValue to mongoDB
                if (formInstance.get("IntrinsicValue") instanceof NullNode || formInstance.get("IntrinsicValue") == null) {
                    formInstance.set("IntrinsicValue", formInstance.get("Rate"));
                }

                // add TemporalValue to mongoDB
                if (formInstance.get("TemporalValue") instanceof NullNode || formInstance.get("TemporalValue") == null)
                    formInstance.set("TemporalValue", 0);

                // add FinalScore to mongoDB
                int intrinsicValue = Integer.parseInt(formInstance.get("IntrinsicValue").toString());
                int rate = Integer.parseInt(formInstance.get("Rate").toString());
                int temporalValue = Integer.parseInt(formInstance.get("TemporalValue").toString());
                int totalScore = rate + intrinsicValue + temporalValue;
                formInstance.set("TotalScore", totalScore);

                // add points to mongoDB
                double x = getPoint().getJtsGeometry().getX();
                double y = getPoint().getJtsGeometry().getY();
                if (x != 0.0 && y != 0.0) {
                    ObjectNode geoJsonPoint = JacksonUtils.createEmptyObjectNode();
                    geoJsonPoint.put("type", "Point");
                    ArrayNode pointCoordinateArray = JacksonUtils.createEmptyArrayNode();
                    pointCoordinateArray.add(x);
                    pointCoordinateArray.add(y);
                    geoJsonPoint.put("coordinates", pointCoordinateArray);
                    formInstance.set("point", geoJsonPoint);
                }
                // end add points to mongoDB
                String oldFormUID = gISVectorObject.getFormUID();
                if (oldFormUID != null) {
                    entityInstanceMgr.addOrUpdate(oldFormUID, formInstance, false);
                } else {
                    formInstance = entityInstanceMgr.add(formInstance, false);
                    gISVectorObject.setFormUID(formInstance.getExtuid());
                }
            } else {
                gISVectorObject.setFormUID(formInstance.getUid());
            }
        } catch (InvalidDtoException e) {
            // TODO
            e.printStackTrace();
            throw new BadDtoEntityModificationException("The given dto for layer is invalid: " + getLayer(), e);
        } catch (EntityTypeNotFoundException e) {
            // TODO
            e.printStackTrace();
            throw new BadDtoEntityModificationException("The layer formSchemaKey entityType not found", e);
        } catch (ValidationException | EntityObjectNotFoundException | InconsistenceEntityVersionException e) {
            // TODO
            e.printStackTrace();
            throw new BadDtoEntityModificationException(e);
        }
    }

    @Override
    protected EntityInstance load_FormInstance(GISVectorObject gISVectorObject) {
        // TODO Auto-generated method stub
        if (gISVectorObject.getFormUID() == null)
            return null;
        try {
            EntityType entityType = EntityTypeMgr.getInstance().getByKey(gISVectorObject.getLayer().getFormSchemaKey());
            return EntityInstanceDAO.getInstance().getByUid(entityType, gISVectorObject.getFormUID(), false);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected PlainCollectionDTO<Category, CategoryLightDTO> load_TimeSeries(GISVectorObject GISVectorObject) {
        @SuppressWarnings("unchecked")
        Set<Category> set = (Set<Category>) (Set<?>) GISVectorObject.getTimeSeriesRootCategories();
        return PlainCollectionDTO.createAndLoad(set, CategoryLightDTO.class);
    }

}

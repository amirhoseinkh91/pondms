package ir.viratech.pond_ms.ui.cli.editMongo;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

public class AddGeoPointsToMongo {

	public static void main(String[] args) throws IOException {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<PointObject> pointsList = PointObjectDAO.getInstance().findAll();

		int counter = 0;
		for (PointObject pointObject : pointsList) {
			try {
				EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr(pointObject.getLayer().getFormSchemaKey());
				String formKey = pointObject.getLayer().getFormSchemaKey();
				System.out.println("formSchemaKey: " + pointObject.getLayer().getFormSchemaKey());
				if (formKey.equals("city")) {
					System.out.println("object number " + (++counter) + "\t" + pointObject.getName());
					EntityInstance formInstance = mgr.getByUid(pointObject.getFormUID(), true);
					ObjectNode geoJsonPoint = JacksonUtils.createEmptyObjectNode();
					geoJsonPoint.put("type", "Point");
					ArrayNode pointCoordinateArray = JacksonUtils.createEmptyArrayNode();
					pointCoordinateArray.add(pointObject.getPoint().getX());
					pointCoordinateArray.add(pointObject.getPoint().getY());
					geoJsonPoint.put("coordinates", pointCoordinateArray);
					formInstance.set("point", geoJsonPoint);
					formInstance.set("description", "");
					mgr.edit(formInstance.getUid(), formInstance, true);
				}
			} catch (EntityTypeNotFoundException e) {
				System.err.println("error in point object form schema " + pointObject.getExtuid());
				e.printStackTrace();
			} catch (EntityObjectNotFoundException e) {
				System.err.println("object has formUid, but related form instance does not exist or has been deleted"
						+ pointObject.getExtuid());
				e.printStackTrace();
			} catch (AccessDeniedException e) {
				System.err.println("access denied :(((((");
				e.printStackTrace();
			} catch (InconsistenceEntityVersionException e) {
				e.printStackTrace();
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		}
	}

}

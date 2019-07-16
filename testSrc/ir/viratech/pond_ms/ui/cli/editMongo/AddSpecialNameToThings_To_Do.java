package ir.viratech.pond_ms.ui.cli.editMongo;

import java.util.List;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

public class AddSpecialNameToThings_To_Do {

	private static final String THINGS_TO_DO_SCHEMA = "Things_To_Do";

	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();

		List<PointObject> allPointObjs = PointObjectDAO.getInstance().findAll();
		int counter = 0;
		for (PointObject pointObject : allPointObjs) {
			if (pointObject.getLayer().getFormSchemaKey().equals(THINGS_TO_DO_SCHEMA)) {
				EntityInstance formInstance = null;
				try {
					EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr(pointObject.getLayer().getFormSchemaKey());

					formInstance = pointObject.getFormInstance("full", false);
					formInstance.set("SpecialName", formInstance.get("name"));
					mgr.edit(formInstance.getUid(), formInstance, false);
					System.out.println((counter++) + "\tobjects updated.");
				} catch (NullPointerException e) {
					formInstance.set("SpecialName", null);
				} catch (EntityTypeNotFoundException e) {
					e.printStackTrace();
				} catch (InconsistenceEntityVersionException e) {
					e.printStackTrace();
				} catch (ValidationException e) {
					e.printStackTrace();
				} catch (EntityObjectNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

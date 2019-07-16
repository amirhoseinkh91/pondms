package ir.viratech.pond_ms.ui.cli.editMongo;

import java.util.List;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

// AddExtraFormsFieldsToMongo
public class AddExtraFormsFieldsToMongo {

	private static final String HOTEL_SCHEMA = "Hotel";
	private static final String THINGS_TO_DO_SCHEMA = "Things_To_Do";

	public static void main(String[] args) {

		ApplicationContextUtil.initializeCliApplicationContext();
		int hotelCounter = 0;
		int thingsToDoCounter = 0;
		try {
			List<PointObject> pointObjects = PointObjectDAO.getInstance().findAll();
			for (PointObject pointObject : pointObjects) {
				try {
					String formSchemaKey = pointObject.getLayer().getFormSchemaKey();

					if (formSchemaKey.equals(HOTEL_SCHEMA)) {
						editHotelForm(pointObject);
						hotelCounter++;
						print(pointObject);
					} else if (formSchemaKey.equals(THINGS_TO_DO_SCHEMA)) {
						editThings_to_do_form(pointObject);
						thingsToDoCounter++;
						print(pointObject);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
		
		System.out.println("number of updated hotelForms: " + hotelCounter);
		System.out.println("number of updated thingsToDoForms: " + thingsToDoCounter);

	}

	private static void editHotelForm(PointObject pointObject)
			throws EntityTypeNotFoundException, EntityObjectNotFoundException, AccessDeniedException,
			InconsistenceEntityVersionException, ValidationException {
		EntityInstanceMgr mgr = getManager(pointObject);
		EntityInstance hotelFormInstance = getFormInstance(pointObject, mgr);

		try {
			hotelFormInstance.set("Rate", hotelFormInstance.get("Score"));
		} catch (NullPointerException e) {
			hotelFormInstance.set("Rate", 0);
		}

		hotelFormInstance.set("IntrinsicValue", hotelFormInstance.get("Rate"));
		// add TemporalValue to mongoDB
		hotelFormInstance.set("TemporalValue", 0);

		// add FinalScore to mongoDB
		hotelFormInstance.set("TotalScore", calculateTotalScore(hotelFormInstance));
		// removes Score field from Hotel Form
		try {
			hotelFormInstance.remove("Score");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		mgr.edit(hotelFormInstance.getUid(), hotelFormInstance, false);

	}

	private static void editThings_to_do_form(PointObject pointObject)
			throws EntityTypeNotFoundException, EntityObjectNotFoundException, AccessDeniedException,
			InconsistenceEntityVersionException, ValidationException {
		EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr(pointObject.getLayer().getFormSchemaKey());
		EntityInstance things_to_do_formInstance = getFormInstance(pointObject, mgr);

		if (!things_to_do_formInstance.has("Rate")) {
			things_to_do_formInstance.set("Rate", 0);
		}

		things_to_do_formInstance.set("IntrinsicValue", things_to_do_formInstance.get("Rate"));
		// add TemporalValue to mongoDB
		things_to_do_formInstance.set("TemporalValue", 0);

		// add FinalScore to mongoDB
		things_to_do_formInstance.set("TotalScore", calculateTotalScore(things_to_do_formInstance));
		// removes Score field from Hotel Form
		mgr.edit(things_to_do_formInstance.getUid(), things_to_do_formInstance, false);
	}

	private static EntityInstanceMgr getManager(PointObject pointObject) throws EntityTypeNotFoundException {
		return EntityInstanceMgrProvider.getMgr(pointObject.getLayer().getFormSchemaKey());
	}

	private static EntityInstance getFormInstance(PointObject pointObject, EntityInstanceMgr manager)
			throws EntityTypeNotFoundException, EntityObjectNotFoundException, AccessDeniedException {
		return manager.getByUid(pointObject.getFormUID(), false);
	}

	private static int calculateTotalScore(EntityInstance formInstance) {
		int intrinsicValue = 0;
		int rate = 0;
		int temporalValue = 0;
		try {
			intrinsicValue = Integer.parseInt(formInstance.get("IntrinsicValue").toString());
		} catch (NullPointerException e) {
			intrinsicValue = 0;
		}
		try {
			rate = Integer.parseInt(formInstance.get("Rate").toString());
		} catch (NullPointerException e) {
			rate = 0;
		}

		try {
			temporalValue = Integer.parseInt(formInstance.get("TemporalValue").toString());
		} catch (NullPointerException e) {
			temporalValue = 0;
		}
		return rate + intrinsicValue + temporalValue;
	}

	
	private static void print(PointObject pointObject) {
		System.out.println(pointObject.getExtuid() + " has been updated.");
	}
}

package ir.viratech.pond_ms.model.layer;

import java.util.ArrayList;
import java.util.List;

import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.api.layer.dto.PondFormSchemaDTO;
import ir.viratech.pond_ms.model.OnDeleteProvider;
import ir.viratech.pond_ms.model.layer.base.BasePond;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.OrganizationBasedProvider;

/**
 * The entity class "Pond".
 */

public class Pond extends BasePond implements UIDAndDisplayStringProvider, OrganizationBasedProvider, OnDeleteProvider, BaseEntityInterface {
	private static final long serialVersionUID = 1L;

	public static final String GENERAL_FORM_SCHEMA_KEY__PUBLIC = "GENERAL_FORM_SCHEMA_KEY__PUBLIC";
	public static final String DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC = "DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC";
	public static final String TABULAR_FORM_SCHEMA_KEY__PUBLIC = "TABULAR_FORM_SCHEMA_KEY__PUBLIC";
	public static final String LIBRARY_FORM_SCHEMA_KEY__PUBLIC = "LIBRARY_FORM_SCHEMA_KEY__PUBLIC";
	public static final String GALLERY_FORM_SCHEMA_KEY__PUBLIC = "GALLERY_FORM_SCHEMA_KEY__PUBLIC";
	public static final String UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC = "UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC";

	public static final String DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET = "DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET";
	public static final String TABULAR_FORM_SCHEMA_KEY__SECRET = "TABULAR_FORM_SCHEMA_KEY__SECRET";
	public static final String LIBRARY_FORM_SCHEMA_KEY__SECRET = "LIBRARY_FORM_SCHEMA_KEY__SECRET";
	public static final String GALLERY_FORM_SCHEMA_KEY__SECRET = "GALLERY_FORM_SCHEMA_KEY__SECRET";
	public static final String UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET = "UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET";

	public static final String[] FORM_SCHEMA_KEYS = new String[]{GENERAL_FORM_SCHEMA_KEY__PUBLIC,
											DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC, DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET,
											TABULAR_FORM_SCHEMA_KEY__PUBLIC, TABULAR_FORM_SCHEMA_KEY__SECRET,
											LIBRARY_FORM_SCHEMA_KEY__PUBLIC, LIBRARY_FORM_SCHEMA_KEY__SECRET,
											GALLERY_FORM_SCHEMA_KEY__PUBLIC, GALLERY_FORM_SCHEMA_KEY__SECRET,
											UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC, UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET};

	public static final List<PondFormSchemaDTO> getFormSchemaKeys() {
		List<PondFormSchemaDTO> list = new ArrayList<>();

		try {
			list.add(new PondFormSchemaDTO(DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance()
							.getByKey(DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC)
							.getRawJsonSchema()));

			list.add(new PondFormSchemaDTO(GENERAL_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance().getByKey(GENERAL_FORM_SCHEMA_KEY__PUBLIC).getRawJsonSchema()));

			list.add(new PondFormSchemaDTO(DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET, true,
					EntityTypeMgr.getInstance().getByKey(DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(TABULAR_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance().getByKey(TABULAR_FORM_SCHEMA_KEY__PUBLIC).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(TABULAR_FORM_SCHEMA_KEY__SECRET, true,
					EntityTypeMgr.getInstance().getByKey(TABULAR_FORM_SCHEMA_KEY__SECRET).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(LIBRARY_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance().getByKey(LIBRARY_FORM_SCHEMA_KEY__PUBLIC).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(LIBRARY_FORM_SCHEMA_KEY__SECRET, true,
					EntityTypeMgr.getInstance().getByKey(LIBRARY_FORM_SCHEMA_KEY__SECRET).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(GALLERY_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance().getByKey(GALLERY_FORM_SCHEMA_KEY__PUBLIC).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(GALLERY_FORM_SCHEMA_KEY__SECRET, true,
					EntityTypeMgr.getInstance().getByKey(GALLERY_FORM_SCHEMA_KEY__SECRET).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC, false,
					EntityTypeMgr.getInstance().getByKey(UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC).getProcessedJsonSchema()));
			list.add(new PondFormSchemaDTO(UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET, true,
					EntityTypeMgr.getInstance().getByKey(UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET).getProcessedJsonSchema()));

			for (String key : FORM_SCHEMA_KEYS) {
				if (key.endsWith("PUBLIC"))
					list.add(new PondFormSchemaDTO(key, false, EntityTypeMgr.getInstance().getByKey(key).getRawJsonSchema()));
				else if (key.endsWith("SECRET"))
					list.add(new PondFormSchemaDTO(key, true, EntityTypeMgr.getInstance().getByKey(key).getRawJsonSchema()));
			}
		} catch (NullPointerException e){

		}
		return list;
	}

	public boolean setFormInstance(String formUid, String key) {
		switch (key) {
		case GENERAL_FORM_SCHEMA_KEY__PUBLIC:
			this.setGeneralFormUID_public(formUid);
			return true;
		case DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC:
			this.setDescriptiveFormUID_public(formUid);
			return true;
		case DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET:
			this.setDescriptiveFormUID_secret(formUid);
			return true;
		case TABULAR_FORM_SCHEMA_KEY__PUBLIC:
			this.setTabularFormUID_public(formUid);
			return true;
		case TABULAR_FORM_SCHEMA_KEY__SECRET:
			this.setTabularFormUID_secret(formUid);
			return true;
		case LIBRARY_FORM_SCHEMA_KEY__PUBLIC:
			this.setLibraryFormUID_public(formUid);
			return true;
		case LIBRARY_FORM_SCHEMA_KEY__SECRET:
			this.setLibraryFormUID_secret(formUid);
			return true;
		case GALLERY_FORM_SCHEMA_KEY__PUBLIC:
			this.setGalleryFormUID_public(formUid);
			return true;
		case GALLERY_FORM_SCHEMA_KEY__SECRET:
			this.setGalleryFormUID_secret(formUid);
			return true;
		case UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC:
			this.setUniversalMapFormUID_public(formUid);
			return true;
		case UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET:
			this.setUniversalMapFormUID_secret(formUid);
			return true;
		}
		return false;
	}

	public String getFormInstanceUid(String key) {
		switch (key) {
		case GENERAL_FORM_SCHEMA_KEY__PUBLIC:
			return this.getGeneralFormUID_public();
		case DESCRIPTIVE_FORM_SCHEMA_KEY__PUBLIC:
			return this.getDescriptiveFormUID_public();
		case DESCRIPTIVE_FORM_SCHEMA_KEY__SECRET:
			return this.getDescriptiveFormUID_secret();
		case TABULAR_FORM_SCHEMA_KEY__PUBLIC:
			return this.getTabularFormUID_public();
		case TABULAR_FORM_SCHEMA_KEY__SECRET:
			return this.getTabularFormUID_secret();
		case LIBRARY_FORM_SCHEMA_KEY__PUBLIC:
			return this.getLibraryFormUID_public();
		case LIBRARY_FORM_SCHEMA_KEY__SECRET:
			return this.getLibraryFormUID_secret();
		case GALLERY_FORM_SCHEMA_KEY__PUBLIC:
			return this.getGalleryFormUID_public();
		case GALLERY_FORM_SCHEMA_KEY__SECRET:
			return this.getGalleryFormUID_secret();
		case UNIVERSAL_MAP_FORM_SCHEMA_KEY__PUBLIC:
			return this.getUniversalMapFormUID_public();
		case UNIVERSAL_MAP_FORM_SCHEMA_KEY__SECRET:
			return this.getUniversalMapFormUID_secret();
		}
		return null;
	}

	@Override
	public String getDisplayString() {
		return getTitle();
	}

	@Override
	public Organization getOrganization() {
		return this.getLayer().getOrganization();
	}

	@Override
	public void setOrganization(Organization organization) {
		// DO nothing!
	}

	@Override
	public void onDelete() {
		for (String key: FORM_SCHEMA_KEYS) {
			if(this.getFormInstanceUid(key) != null){
				EntityInstanceMgr entityInstanceMgr;
				try {
					entityInstanceMgr = EntityInstanceMgrProvider.getMgr(key);
					entityInstanceMgr.delete(this.getFormInstanceUid(key), false);
				} catch (EntityTypeNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EntityObjectNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String getEntityTypeKey() {
		return "pond";
	}

}
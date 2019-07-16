package ir.viratech.pond_ms.core.features;

import ir.viratech.pond_ms.model.user.Feature.EntityAccessKey;

public class FeatureNames {

	public static final String ACCESS_API = "ACCESS_API";
	public static final String SEE_HOME = "SEE_HOME";
	public static final String API_CHANGE_PASSWORD = "API_CHANGE_PASSWORD";
	public static final String SEE_UNSPECIFIED = "SEE_UNSPECIFIED";
	public static final String API_UNSPECIFIED = "API_UNSPECIFIED";
	public static final String API_SYS_ADMIN = "API_SYS_ADMIN";

	public static final String GET_REPORT_LAYERS = "GET_REPORT_LAYERS";
	public static final String SEE_SECRET_LAYERS = "SEE_SECRECT_LAYERS";
	public static final String EDIT_SECRET_LAYERS = "EDIT_SECRECT_LAYERS";
	public static final String GET_REPORT_SECRET_LAYERS = "GET_REPORT_SECRET_LAYERS";

	public static final String GET_LAYER_FILES = "GET_LAYER_FILES";
	public static final String ADD_LAYER_FILES = "ADD_LAYER_FILES";
	public static final String DELETE_LAYER_FILES = "DELETE_LAYER_FILES";
	public static final String DOWNLOAD_LAYER_FILES = "DOWNLOAD_LAYER_FILES";


	public static final String SEE_PUBLIC_POND_FORMS = "SEE_PUBLIC_POND_FORMS";
	public static final String EDIT_PUBLIC_POND_FORMS = "EDIT_PUBLIC_POND_FORMS";
	public static final String DOWNLOAD_PUBLIC_POND_FORMS = "DOWNLOAD_PUBLIC_POND_FORMS";

	public static final String SEE_SECRET_POND_FORMS = "SEE_SECRET_POND_FORMS";
	public static final String EDIT_SECRET_POND_FORMS = "EDIT_SECRET_POND_FORMS";
	public static final String DOWNLOAD_SECRET_POND_FORMS = "DOWNLOAD_SECRET_POND_FORMS";

	public static final String MANAGEMENT_PORTAL = EntityAccessKey.getAccessKeyForManagement("PORTAL");
	public static final String ADD_PORTAL = EntityAccessKey.getAccessKeyForAdd("PORTAL");
	public static final String VIEW_PORTAL = EntityAccessKey.getAccessKeyForView("PORTAL");
	public static final String EDIT_PORTAL = EntityAccessKey.getAccessKeyForEdit("PORTAL");
	public static final String DELETE_PORTAL = EntityAccessKey.getAccessKeyForDelete("PORTAL");
	public static final String LIST_PORTAL = EntityAccessKey.getAccessKeyForList("PORTAL");

	public static final String ACCESS_CM = "ACCESS_CM";

	public static final String CLIENT_SEE_META_ORGANIZATION_MENU = "CLIENT_SEE_META_ORGANIZATION_MENU";
	public static final String SEE_EVENT_LOGS = "SEE_EVENT_LOG";

	public static final String MANAGE_FEED_BACKS = "MANAGE_FEED_BACKS";
}


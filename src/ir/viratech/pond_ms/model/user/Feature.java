package ir.viratech.pond_ms.model.user;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.user.base.BaseFeature;

/**
 * The entity class "Feature".
 */

public class Feature extends BaseFeature implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String toStringData() {
		return super.toStringData()
			+ ", " +
			"extuid: " + this.getExtuid()
			+ ", " +
			"name: " + this.getName();
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.model.DisplayStringProvider#getDisplayString()
	 */
	@Override
	public String getDisplayString() {
		if (StringUtils.isBlank(this.getDescription())) {
			return this.getName();
		}
		return this.getDescription();
	}

	/**
	 * The Class EntityAccessKey.
	 */
	public static final class EntityAccessKey {

		/** Name prefix for feature of managing the entities. */
		public static final String MANAGEMENT = "MANAGEMENT";

		/** Name prefix for feature of adding the entity. */
		public static final String ADD = "API_ADD";

		/** Name prefix for feature of viewing the entity. */
		public static final String VIEW = "API_VIEW";

		/** Name prefix for feature of editing the entity. */
		public static final String EDIT = "API_EDIT";

		/** Name prefix for feature of deleting the entity. */
		public static final String DELETE = "API_DELETE";

		/** Name prefix for feature of listing the entities. */
		public static final String LIST = "API_LIST";


		private EntityAccessKey() {
			// private constructor added to hide implicit public one
		}

		public static String getAccessKeyForManagement(String featureEntityName) {
			return MANAGEMENT+"_"+featureEntityName;
		}
		public static String getAccessKeyForAdd(String featureEntityName) {
			return ADD+"_"+featureEntityName;
		}
		public static String getAccessKeyForView(String featureEntityName) {
			return VIEW+"_"+featureEntityName;
		}
		public static String getAccessKeyForEdit(String featureEntityName) {
			return EDIT+"_"+featureEntityName;
		}
		public static String getAccessKeyForDelete(String featureEntityName) {
			return DELETE+"_"+featureEntityName;
		}
		public static String getAccessKeyForList(String featureEntityName) {
			return LIST+"_"+featureEntityName;
		}

		public static List<String> getAllAccessKeys(String featureEntityName) {
			return Arrays.asList(
					getAccessKeyForManagement(featureEntityName),
					getAccessKeyForAdd(featureEntityName),
					getAccessKeyForView(featureEntityName),
					getAccessKeyForEdit(featureEntityName),
					getAccessKeyForDelete(featureEntityName),
					getAccessKeyForList(featureEntityName)
					);
		}
	}



}
package ir.viratech.pond_ms.model.user.role;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.util.relation_map.RelationMap;
import ir.viratech.commons.util.synchronized_lazy.AbstractNotNullSynchronizedLazy;
import ir.viratech.commons.util.synchronized_lazy.SynchronizedLazy;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.dao.FeatureDAO;
import ir.viratech.pond_ms.model.user.role.base.BaseRole;

/**
 * The entity class "Role".
 */

public class Role extends BaseRole implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	public static final String PRO_USER_ROLE = "PRO_USER_ROLE";
	public static final String NORM_USER_ROLE = "NORM_USER_ROLE";
	public static final String MOBILE_ADMIN_ROLE = "MOBILE_ADMIN";
	public static final String AGENCY_ROLE = "AGENCY_ROLE";
	public static final String ANONYMOUS_ROLE = "anonymous";
	public static final String ADMIN_ROLE = "admin";
	public static final String SYSADMIN_ROLE = "sysadmin";

	/* (non-Javadoc)
	 * @see ir.viratech.commons.model.DisplayStringProvider#getDisplayString()
	 */
	@Override
	public String getDisplayString() {
		return this.getName();
	}
	private final transient SynchronizedLazy<RelationMap<Feature>> syn_featuresRelationMap = new AbstractNotNullSynchronizedLazy<RelationMap<Feature>>() {
		@Override
		public RelationMap<Feature> create() {
			return new RelationMap<>(FeatureDAO.getInstance().getPublicFeatures(), Role.this.getCreatedAvailableFeatures());
		}
	};
	/**
	 * Gets the features relation map.
	 *
	 * @return the features relation map
	 */
	public RelationMap<Feature> getFeaturesRelationMap() {
		return this.syn_featuresRelationMap.get();
	}

	public void setFeatureAvailability(Feature feature, boolean available) {
		this.getFeaturesRelationMap().put(feature, available);
	}
	public void setFeatureAvailability(String featureName, boolean available) {
		this.setFeatureAvailability(FeatureDAO.getInstance().getExistingByName(featureName), available);
	}
	@Override
	protected String toStringData() {
		return super.toStringData()
			+ ", " +
			"name: " + this.getName();
	}
}
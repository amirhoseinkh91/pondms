package ir.viratech.pond_ms.model.organization;

import ir.viratech.base.UIDAndDisplayStringAndTreeProvider;
import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.pond_ms.model.organization.base.BaseOrganization;

/**
 * The entity class "Organization".
 */

public class Organization extends BaseOrganization implements UIDAndDisplayStringAndTreeProvider<Organization>, BaseEntityInterface{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return this.getName();
	}

	@Override
	public int getChildCount() {
		return this.getChildren().size();
	}

	@Override
	public String getEntityTypeKey() {
		return "positon";
	}





}
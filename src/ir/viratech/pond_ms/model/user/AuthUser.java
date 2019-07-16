package ir.viratech.pond_ms.model.user;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.user.base.BaseAuthUser;

/**
 * The entity class "AuthUser".
 */

public class AuthUser extends BaseAuthUser implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return getFirstName();
	}





}
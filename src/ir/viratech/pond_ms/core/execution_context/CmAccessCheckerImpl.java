package ir.viratech.pond_ms.core.execution_context;

import ir.viratech.commons.cm.core.CmAccessCheckerInterface;
import ir.viratech.commons.model.auth.AccessDeniedException;

public class CmAccessCheckerImpl implements CmAccessCheckerInterface{

	@Override
	public boolean hasAccessToAny(String featureNames) {
		return true;
	}

	@Override
	public void checkAccess(String featureNames) throws AccessDeniedException {
		
	}

}

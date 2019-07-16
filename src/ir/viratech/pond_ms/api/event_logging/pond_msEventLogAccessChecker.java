package ir.viratech.pond_ms.api.event_logging;

import org.springframework.beans.factory.annotation.Autowired;

import ir.viratech.commons.cm.core.CmAccessCheckerInterface;
import ir.viratech.commons.event_logging.model.EventLogAccessChecker;
import ir.viratech.commons.model.auth.AccessDeniedException;

public class pond_msEventLogAccessChecker implements EventLogAccessChecker {

	@Autowired
	private CmAccessCheckerInterface cmAccessChecker;
	
	@Override
	public void checkAccess(String featureNames) throws AccessDeniedException {
		cmAccessChecker.checkAccess(featureNames);
	}

}

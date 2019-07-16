package ir.viratech.pond_ms.model.user.authorization;


import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * The Class AccessCheckerMap.
 */
public class AccessCheckerMap extends AbstractMap<String, Boolean> implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final transient Logger logger = Logger.getLogger(AccessCheckerMap.class);

	/// Singleton
	private static AccessCheckerMap instance = null;
	private static synchronized void createInstance() {
		if (null == instance) {
			instance = new AccessCheckerMap();
		}
	}
	
	/**
	 * Gets the single instance of AccessCheckerMap.
	 *
	 * @return single instance of AccessCheckerMap
	 */
	public static AccessCheckerMap getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<String, Boolean>> entrySet() {
		return Collections.emptySet();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#get(java.lang.Object)
	 */
	@Override
	public Boolean get(Object key) {
		if (!(key instanceof String)) {
			logger.error("given key is not an instance of String");
			return false;
		}
		return AccessChecker.hasAccessToAny((String) key);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractMap#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getName()+".instance";
	}

}

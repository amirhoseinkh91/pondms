package ir.viratech.pond_ms.model.gismap;

import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.gismap.base.BaseGISMap;
import ir.viratech.pond_ms.model.organization.OrganizationBasedProvider;

/**
 * The entity class "GISMap".
 */

public class GISMap extends BaseGISMap implements UIDAndDisplayStringProvider, OrganizationBasedProvider, BaseEntityInterface {
	private static final long serialVersionUID = 1L;


	public static final int MIN_ZOOM_AVAILABLE = 1;
	public static final int MAX_ZOOM_AVAILABLE = 20;

	@Override
	public String getDisplayString() {
		return this.getTitle();
	}

	@Override
	public String getEntityTypeKey() {
		return "gisMap";
	}



}
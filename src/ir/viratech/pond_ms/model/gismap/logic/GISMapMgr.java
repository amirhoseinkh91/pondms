package ir.viratech.pond_ms.model.gismap.logic;


import java.util.List;

import ir.viratech.pond_ms.model.gismap.base.BaseGISMapMgr;
import ir.viratech.pond_ms.model.layer.Layer;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.gismap.GISMap".
 */
public class GISMapMgr extends BaseGISMapMgr {

	public List<Layer> getRootLayersByMapExtuid(String gismapUid) {
		return this.getDAO().getByExtuid(gismapUid).getCreatedLayers();
	}




}
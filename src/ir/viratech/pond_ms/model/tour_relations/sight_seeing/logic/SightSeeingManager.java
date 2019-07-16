package ir.viratech.pond_ms.model.tour_relations.sight_seeing.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.sight_seeing.SightSeeing;

public class SightSeeingManager extends BaseManager {

	public static SightSeeing getInstance() throws InstantiationException, IllegalAccessException {
		return SightSeeing.class.newInstance();
	}
	
}

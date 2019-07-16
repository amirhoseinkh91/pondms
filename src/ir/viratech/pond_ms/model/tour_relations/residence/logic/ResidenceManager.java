package ir.viratech.pond_ms.model.tour_relations.residence.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.residence.Residence;

public class ResidenceManager extends BaseManager {

	public static Residence getInstance() throws InstantiationException, IllegalAccessException {
		return Residence.class.newInstance();
	}
	
}

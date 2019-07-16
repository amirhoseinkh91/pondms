package ir.viratech.pond_ms.model.tour_relations.depart_arrival.logic;

import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.depart_arrival.DepartArrival;

public class DepartArrivalManager extends BaseManager {

	public static DepartArrival getInstance() throws InstantiationException, IllegalAccessException {
		return DepartArrival.class.newInstance();
	}
	
	public static DepartArrivalManager newInstance() throws InstantiationException, IllegalAccessException {
		return DepartArrivalManager.class.newInstance();
	}
	
	public DepartArrival parse(JSONObject jsonObject) {
		DepartArrival departArrival = null;
		try {
			departArrival = getInstance();
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return departArrival;
	}
}

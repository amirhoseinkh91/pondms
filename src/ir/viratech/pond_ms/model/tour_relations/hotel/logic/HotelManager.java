package ir.viratech.pond_ms.model.tour_relations.hotel.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.hotel.Hotel;

public class HotelManager extends BaseManager{
	
	public static Hotel getInstance() throws InstantiationException, IllegalAccessException {
		return Hotel.class.newInstance();
	}
	
}

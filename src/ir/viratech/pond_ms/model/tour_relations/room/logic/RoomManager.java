package ir.viratech.pond_ms.model.tour_relations.room.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.room.Room;

public class RoomManager extends BaseManager{

	public static Room getInstance() throws InstantiationException, IllegalAccessException {
		return Room.class.newInstance();
	}
	
}

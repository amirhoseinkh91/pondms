package ir.viratech.pond_ms.model.tour_relations.base.logic;

import com.google.gson.Gson;

import ir.viratech.commons.model.uid.UidGenerator;
import ir.viratech.commons.model.uid.UidGenerator_Random;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseManager<T> {

	@Autowired
	private UidGenerator uidGenerator;

	private Gson gson;

	public BaseManager() {
		gson = new Gson();
	}
	
	public String getUid() throws InstantiationException, IllegalAccessException {
		return new UidGenerator_Random().generateUid();
	}
	
}

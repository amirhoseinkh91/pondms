package ir.viratech.pond_ms.model.tour_relations.transfer.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.transfer.Transfer;

public class TransferManager extends BaseManager {

	public static Transfer getInstance() throws InstantiationException, IllegalAccessException {
		return Transfer.class.newInstance();
	}
	
}

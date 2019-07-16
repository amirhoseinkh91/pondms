package ir.viratech.pond_ms.ui.cli.update_schemas;

import java.util.List;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityEnrichmentManager;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class GetFormSchema {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, EntityTypeNotFoundException {
		ApplicationContextUtil.initializeCliApplicationContext();
		EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr(/**/"Things_To_Do");

		System.out.println(EntityTypeMgr.getInstance().getByKey("Restaurant").getRawEntitySchema().toJsonString());

		/*List<EntityInstance> list = mgr.getAllEntities(false);
		System.out.println(list.get(0).get("Things_To_DoName"));*/
	}
	
}

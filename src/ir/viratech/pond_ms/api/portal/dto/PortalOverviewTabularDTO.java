package ir.viratech.pond_ms.api.portal.dto;

import ir.viratech.pond_ms.api.BaseCustomTabularDTO;

public class PortalOverviewTabularDTO extends BaseCustomTabularDTO<PortalOverviewDTO> {

	@Override
	public void putAllFieldInfo() {
		setBundlePrefix("portal.overview");
		putFieldInfo(createFieldInfo_String("title", "title", "title", null, "title", false, false));
		putFieldInfo(createFieldInfo_String("sub_domain", "sub_domain", "sub_domain", null, "sub_domain", false, false));
	}

}

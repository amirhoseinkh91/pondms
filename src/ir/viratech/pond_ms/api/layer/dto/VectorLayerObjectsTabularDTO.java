package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.pond_ms.api.BaseCustomTabularDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO;

public class VectorLayerObjectsTabularDTO extends BaseCustomTabularDTO<GISVectorObjectMapDTO>{

	@Override
	public void putAllFieldInfo() {
		setBundlePrefix("gisvectorobject.");
		putFieldInfo(createFieldInfo_String("uid", "uid", "uid", null, "uid", false, false));
		putFieldInfo(createFieldInfo_String("name", "name", "name", null, "name", false, false));
	}

}

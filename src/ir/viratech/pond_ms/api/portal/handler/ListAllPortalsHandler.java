package ir.viratech.pond_ms.api.portal.handler;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.portal.dto.PortalOverviewDTO;
import ir.viratech.pond_ms.api.portal.dto.PortalOverviewTabularDTO;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

public class ListAllPortalsHandler extends BaseServiceHandler {

	private int len;
	private long start;

	public ListAllPortalsHandler(long start, int len) {
		this.start = start;
		this.len = len;
	}

	@Override
	public Response handle() throws RequestHandlingException {
		List<PortalOverviewDTO> dtos = new ArrayList<PortalOverviewDTO>();
		PagedList<Organization> pagedOrgans = null;
		try {
			pagedOrgans = OrganizationMgr.getInstance().search(null);
			List<Organization> organs = pagedOrgans.getItems(this.start, this.len);
			for (Organization org: organs) {
				PortalOverviewDTO dto = new PortalOverviewDTO();
				dto.load(org);
				dtos.add(dto);
			}
			long totalCount = organs.size();
			PortalOverviewTabularDTO tabularDTO = new PortalOverviewTabularDTO();
			tabularDTO.setTotalCount(totalCount);
			tabularDTO.setList(dtos);
			return Response.ok().entity(tabularDTO).build();
		} catch (InvalidSearchQueryException e) {
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("invalid_request", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

	}
}

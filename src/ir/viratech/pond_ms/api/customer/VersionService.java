package ir.viratech.pond_ms.api.customer;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.api.customer.dto.AppConfigDTO;

@Path("version")
public class VersionService extends AbstractJsonService{
	@GET
	@Path("last")
  	public AppConfigDTO getAppConfigDto() throws IOException{
  		return new AppConfigDTO();
  	}
}

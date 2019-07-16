package ir.viratech.pond_ms.api.menu;

import ir.viratech.pond_ms.api.menu.base.BaseConfigEntryResource;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "ConfigEntry".
 *
 */
@Component
@Path(BaseConfigEntryResource.RESOURCE_PATH)
public class ConfigEntryResource extends BaseConfigEntryResource {


}

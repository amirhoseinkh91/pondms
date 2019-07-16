package ir.viratech.pond_ms.api.app_message;

import ir.viratech.pond_ms.api.app_message.base.BaseAppMessageResource;

import javax.ws.rs.Path;

import ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO;
import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "AppMessage".
 *
 */
@Component
@Path(BaseAppMessageResource.RESOURCE_PATH)
public class AppMessageResource extends BaseAppMessageResource {

    public AppMessageResource() {
        this.addFieldInfoContext("full", AppMessageFullDTO.FieldInfoContext.class);
    }
}

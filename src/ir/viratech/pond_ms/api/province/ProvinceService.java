package ir.viratech.pond_ms.api.province;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/province")
public class ProvinceService extends AbstractJsonService {

    @GET
    @Path("/get-name")
    public Response getProvinceFromUser(@QueryParam("name") String name) {
        List<ParentLayer> provinces = null;
        ArrayNode provincesNode = JacksonUtils.createEmptyArrayNode();
        if (!StringUtils.isEmpty(name)) {
            provinces = ParentLayerMgr.getInstance().getByProvinceName(name);
        } else {
            provinces = ParentLayerMgr.getInstance().getProvinces();
        }
        for (ParentLayer province : provinces) {
            JsonNode provinceNode = convertParentLayerToJsonNode(province);
            provincesNode.add(provinceNode);
        }
        return Response.ok(provincesNode).build();
    }


    private JsonNode convertParentLayerToJsonNode(ParentLayer layer) {
        ObjectNode jsonNode = JacksonUtils.createEmptyObjectNode();
        jsonNode.put("uid", layer.getExtuid());
        jsonNode.put("name", layer.getName());
        return jsonNode;
    }
}

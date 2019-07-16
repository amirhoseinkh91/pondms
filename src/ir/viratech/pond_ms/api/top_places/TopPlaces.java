package ir.viratech.pond_ms.api.top_places;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import org.json.JSONException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Path("/top-places")
public class TopPlaces {

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Object> getTopPlaces() throws JsonProcessingException, InstantiationException, IllegalAccessException, IOException, JSONException {
        ArrayNode nodes = PointObjectMgr.getInstance().getTopPlaces();
        List<Object> objects = JacksonUtils.convertToList(nodes, Object.class);
        Collections.shuffle(objects);
        return objects;
    }

}

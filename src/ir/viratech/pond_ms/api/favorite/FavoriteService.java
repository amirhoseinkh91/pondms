package ir.viratech.pond_ms.api.favorite;

import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("favorite")
public class FavoriteService {
    @GET
    @Path("/gis-vector-object/favored")
    public Response Favorite(@QueryParam("uid") String uid) {
        GISVectorObjectMgr.getInstance().incFavoriteCountToObject(uid);
        return Response.ok().entity("confirmed").build();
    }

    @GET
    @Path("/gis-vector-object/unfavored")
    public Response unFavorite(@QueryParam("uid") String uid) {
        GISVectorObjectMgr.getInstance().decFavoriteCountToObject(uid);
        return Response.ok().entity("unconfirmed").build();
    }
}

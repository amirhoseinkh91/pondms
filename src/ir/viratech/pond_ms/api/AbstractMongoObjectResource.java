package ir.viratech.pond_ms.api;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by amir on 9/11/17.
 */
public abstract class AbstractMongoObjectResource<T> {

    public abstract T save(T t);

    public abstract T update(T t);

    public abstract List<T> list(Integer start, Integer len);

    public abstract T getByUid(String uid);

    public abstract void remove(String uid);

    protected Response redirectTo403Page(){
        return Response.temporaryRedirect(URI.create("/static/error403.html")).build();
    }

}

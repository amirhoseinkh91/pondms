package ir.viratech.pond_ms.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PaginationParam {

    @QueryParam("start")
    @DefaultValue("0")
    private int start;

    @QueryParam("len")
    @DefaultValue("50")
    private int len;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

}

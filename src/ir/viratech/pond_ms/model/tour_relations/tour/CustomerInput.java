package ir.viratech.pond_ms.model.tour_relations.tour;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 9/6/17.
 */
public class CustomerInput {

    @QueryParam("extent")
    private String extent;

    @QueryParam("dstCity")
    private String dstCity;

    @QueryParam("srcCity")
    private String srcCity;

    @QueryParam("dstCountry")
    private String dstCountry;

    @QueryParam("start")
    private Integer start;

    @QueryParam("len")
    private Integer len;

    public List<String> getNotNullFields() {
        List<String> fields = new ArrayList<>();
        if (srcCity != null)
            fields.add("srcCity");
        if (dstCity != null)
            fields.add("dstCity");
        if (dstCountry  != null)
            fields.add("dstCountry");
        return fields;
    }

    public String getSrcCity() {
        return srcCity;
    }

    public void setSrcCity(String srcCity) {
        this.srcCity = srcCity;
    }

    public String getDstCity() {
        return dstCity;
    }

    public void setDstCity(String dstCity) {
        this.dstCity = dstCity;
    }

    public String getDstCountry() {
        return dstCountry;
    }

    public void setDstCountry(String dstCountry) {
        this.dstCountry = dstCountry;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public String get(String s) {
        if (s.equals("srcCity"))
            return srcCity;
        if (s.equals("dstCity"))
            return dstCity;
        if (s.equals("dstCountry"))
            return dstCountry;
        return null;
    }

}

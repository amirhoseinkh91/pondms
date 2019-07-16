package ir.viratech.pond_ms.api.filter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class RestaurantSearchQuery {

    @QueryParam("tag")
    private String tag;

    @QueryParam("rate")
    private Integer rate;

    @QueryParam("x")
    private Double x;

    @QueryParam("y")
    private Double y;

    @QueryParam("dist")
    private Integer dist;

    @QueryParam("layerUid")
    private String layerUid;

    @QueryParam("start")
    @DefaultValue("0")
    private Integer start;

    @QueryParam("len")
    @DefaultValue("50")
    private Integer len;

    @QueryParam("sortBy")
    private String sortBy;

    @QueryParam("order")
    private String order;

    @QueryParam("name")
    private String name;

    @QueryParam("price_rate")
    private String priceRate;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public String getLayerUid() {
        return layerUid;
    }

    public void setLayerUid(String layerUid) {
        this.layerUid = layerUid;
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

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }
}

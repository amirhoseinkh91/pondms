package ir.viratech.pond_ms.api.main_city_config;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class MakePointParam {
    @QueryParam("x")
    private Double x;
    @QueryParam("y")
    private Double y;
    @QueryParam("radius")
    @DefaultValue("3000")
    private Long radius;

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

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }


}

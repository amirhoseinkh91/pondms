package ir.viratech.pond_ms.model.main_city_config;

@SuppressWarnings("unused")
public class ConfigPoint {

    public ConfigPoint(Double x, Double y, Long radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    private Double x;
    private Double y;
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

package ir.viratech.pond_ms.api.tour.tour.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseTourLightDTO extends BaseTourDTO {

    public static final String PROP_NAME = "name";

    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTourLightDTO that = (BaseTourLightDTO) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BaseTourLightDTO{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}

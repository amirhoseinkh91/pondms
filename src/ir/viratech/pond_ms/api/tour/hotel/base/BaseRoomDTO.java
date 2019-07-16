package ir.viratech.pond_ms.api.tour.hotel.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BaseRoomDTO implements Serializable {

    @JsonProperty
    private String type;
    @JsonProperty
    private Long price;
    @JsonProperty
    private Long discountedPrice;
    @JsonProperty
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Long discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseRoomDTO that = (BaseRoomDTO) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return discountedPrice != null ? discountedPrice.equals(that.discountedPrice) : that.discountedPrice == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discountedPrice != null ? discountedPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseRoomDTO{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}

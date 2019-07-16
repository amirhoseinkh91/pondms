package ir.viratech.pond_ms.model.tour_relations.room;

public class Room {

	public static final String PROP_TYPE = "type";
	public static final String PROP_PRICE = "price";
	public static final String PROP_DISCOUNTED_PRICE = "discountedPrice";
	public static final String PROP_CAPACITY = "capacity";

	private Integer capacity;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	private String type;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private long price;

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	private long discountedPrice;

	public long getDiscountedPrice() {
		return this.discountedPrice;
	}

	public void setDiscountedPrice(long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.discountedPrice ^ (this.discountedPrice >>> 32));
		result = prime * result + (int) (this.price ^ (this.price >>> 32));
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Room other = (Room) obj;
		if (this.discountedPrice != other.discountedPrice) {
			return false;
		}
		if (this.price != other.price) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Room [type=" + type + ", price=" + price + ", discountedPrice=" + discountedPrice + "]";
	}

}

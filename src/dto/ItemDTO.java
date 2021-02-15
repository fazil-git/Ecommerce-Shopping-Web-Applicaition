package dto;

import java.io.Serializable;

public class ItemDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemId;
	private String itemDescription;
	private String unit;
	private float price;
	private String imageUrl;
	private String shopId;
	
	public ItemDTO() {
	}
	
	public ItemDTO(String itemId, String itemDescription, String unit, float price, String imageUrl, String shopId) {
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.unit = unit;
		this.price = price;
		this.imageUrl = imageUrl;
		this.shopId = shopId;
	}

	public final String getItemId() {
		return itemId;
	}
	public final void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public final String getItemDescription() {
		return itemDescription;
	}
	public final void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public final String getUnit() {
		return unit;
	}
	public final void setUnit(String unit) {
		this.unit = unit;
	}
	public final float getPrice() {
		return price;
	}
	public final void setPrice(float price) {
		this.price = price;
	}
	public final String getImageUrl() {
		return imageUrl;
	}
	public final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public final String getShopId() {
		return shopId;
	}
	public final void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((shopId == null) ? 0 : shopId.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (shopId == null) {
			if (other.shopId != null)
				return false;
		} else if (!shopId.equals(other.shopId))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemId=" + itemId + ", itemDescription=" + itemDescription + ", unit=" + unit + ", price="
				+ price + ", imageUrl=" + imageUrl + ", shopId=" + shopId + "]";
	}
	
}

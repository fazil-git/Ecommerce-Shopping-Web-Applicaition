package dto;

public class InvoiceDTO {
	private String itemdescription;
	private String unit;
	private int qty;
	private int price;
	private int cost;
	
	public InvoiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvoiceDTO(String itemdescription, String unit, int qty, int price, int cost) {
		super();
		this.itemdescription = itemdescription;
		this.unit = unit;
		this.qty = qty;
		this.price = price;
		this.cost = cost;
	}
	
	public final String getItemdescription() {
		return itemdescription;
	}
	public final void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public final String getUnit() {
		return unit;
	}
	public final void setUnit(String unit) {
		this.unit = unit;
	}
	public final int getQty() {
		return qty;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
	public final int getPrice() {
		return price;
	}
	public final void setPrice(int price) {
		this.price = price;
	}
	public final int getCost() {
		return cost;
	}
	public final void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((itemdescription == null) ? 0 : itemdescription.hashCode());
		result = prime * result + price;
		result = prime * result + qty;
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
		InvoiceDTO other = (InvoiceDTO) obj;
		if (cost != other.cost)
			return false;
		if (itemdescription == null) {
			if (other.itemdescription != null)
				return false;
		} else if (!itemdescription.equals(other.itemdescription))
			return false;
		if (price != other.price)
			return false;
		if (qty != other.qty)
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
		return "InvoiceDTO [itemdescription=" + itemdescription + ", unit=" + unit + ", qty=" + qty + ", price=" + price
				+ ", cost=" + cost + "]";
	}
	
}

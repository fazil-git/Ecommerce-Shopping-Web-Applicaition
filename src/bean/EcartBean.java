package bean;

public class EcartBean {
	private int uid;
	private String itemid;
	private int numberOfUnit;
	private String itemdescription;
	private int price;
	private String shopname;
	private int cost;
	
	public EcartBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EcartBean(int uid, String itemid, int numberOfUnit, String itemdescription, int price, String shopname,
			int cost) {
		super();
		this.uid = uid;
		this.itemid = itemid;
		this.numberOfUnit = numberOfUnit;
		this.itemdescription = itemdescription;
		this.price = price;
		this.shopname = shopname;
		this.cost = cost;
	}
	
	public final int getUid() {
		return uid;
	}
	public final void setUid(int uid) {
		this.uid = uid;
	}
	public final String getItemid() {
		return itemid;
	}
	public final void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public final int getNumberOfUnit() {
		return numberOfUnit;
	}
	public final void setNumberOfUnit(int numberOfUnit) {
		this.numberOfUnit = numberOfUnit;
	}
	public final String getItemdescription() {
		return itemdescription;
	}
	public final void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public final int getPrice() {
		return price;
	}
	public final void setPrice(int price) {
		this.price = price;
	}
	public final String getShopname() {
		return shopname;
	}
	public final void setShopname(String shopname) {
		this.shopname = shopname;
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
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + numberOfUnit;
		result = prime * result + price;
		result = prime * result + ((shopname == null) ? 0 : shopname.hashCode());
		result = prime * result + uid;
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
		EcartBean other = (EcartBean) obj;
		if (cost != other.cost)
			return false;
		if (itemdescription == null) {
			if (other.itemdescription != null)
				return false;
		} else if (!itemdescription.equals(other.itemdescription))
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (numberOfUnit != other.numberOfUnit)
			return false;
		if (price != other.price)
			return false;
		if (shopname == null) {
			if (other.shopname != null)
				return false;
		} else if (!shopname.equals(other.shopname))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EcartDTO [uid=" + uid + ", itemid=" + itemid + ", numberOfUnit=" + numberOfUnit + ", itemdescription="
				+ itemdescription + ", price=" + price + ", shopname=" + shopname + ", cost=" + cost + "]";
	}
	
}

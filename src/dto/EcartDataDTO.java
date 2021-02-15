package dto;

public class EcartDataDTO {
	private int uid;
	private String itemid;
	private int qty;
	
	public EcartDataDTO() {
		super();
	}
	
	public EcartDataDTO(int uid, String itemid, int qty) {
		super();
		this.uid = uid;
		this.itemid = itemid;
		this.qty = qty;
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
	public final int getQty() {
		return qty;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + qty;
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
		EcartDataDTO other = (EcartDataDTO) obj;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (qty != other.qty)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EcartOnlyDTO [uid=" + uid + ", itemid=" + itemid + ", qty=" + qty + "]";
	}
	
}
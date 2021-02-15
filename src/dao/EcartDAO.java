package dao;

import java.util.List;

import bean.EcartBean;
import dto.EcartDataDTO;

public abstract class EcartDAO {
	public abstract void addToCart(int uid, String itemid, int numberOfUnit);
	public abstract List<EcartBean> getCart(int uid);
	public abstract List<EcartDataDTO> getCartData(int uid);
}

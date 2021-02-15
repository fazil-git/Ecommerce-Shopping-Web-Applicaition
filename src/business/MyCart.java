package business;

import java.util.List;

import bean.EcartBean;

public abstract class MyCart {

	public abstract List<EcartBean> showCart(int uid);
}

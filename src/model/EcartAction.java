package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EcartBean;
import business.MyCart;
import business.MyCartImpl;

public class EcartAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("uid");
		MyCart myCart=MyCartImpl.createMyCart();
		List<EcartBean> ecartDTOs=myCart.showCart(uid);
		request.setAttribute("MyItems", ecartDTOs);
		
		return "visit.cart";
	}
}
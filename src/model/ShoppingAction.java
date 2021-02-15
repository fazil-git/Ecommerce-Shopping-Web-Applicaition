package model;


import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EcartBean;
import business.MyCart;
import business.MyCartImpl;
import dao.EcartDAO;
import dao.EcartDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import dto.ItemDTO;

public class ShoppingAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();	//lang, uid, uname
		int uid=(int) session.getAttribute("uid");
		
		String shopid=request.getParameter("shopid");
		Enumeration<String> en=request.getParameterNames();
		
		while(en.hasMoreElements()) {
			String name=en.nextElement();
			if(!(name.equals("formid")||name.equals("shopid"))) {
				String value=request.getParameter(name);
				System.out.println("printing from shoppingAction.java "+name+":"+value);//just for verification
				EcartDAO ecartDAO=EcartDAOImpl.createEcartDAO();
				ecartDAO.addToCart(uid, name, 1);
			}
		}

		Properties prop=(Properties) request.getServletContext().getAttribute("prop");
		String nextShopId=(String) prop.getProperty(shopid);
		if(!nextShopId.equals("empty")) {
			ItemDAO itemDAO=ItemDAOImpl.createItemDAO();
			List<ItemDTO> itemsInShop=itemDAO.displayItems(nextShopId);
			request.setAttribute("itemsInShop", itemsInShop);
			itemsInShop.stream().forEach(System.out::println); //just for verification
		}else {
			MyCart myCart=MyCartImpl.createMyCart();
			List<EcartBean> ecartbeans=myCart.showCart(uid);
			request.setAttribute("MyItems", ecartbeans);
			return "visit.cart";
		}
		return shopid+".success";
	}
}
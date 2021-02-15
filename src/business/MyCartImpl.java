package business;

import java.util.List;

import bean.EcartBean;
import dao.EcartDAOImpl;

public class MyCartImpl extends MyCart {
	private static MyCartImpl obj;
	private EcartDAOImpl ecartDAO;

	private MyCartImpl() {
		this.ecartDAO = EcartDAOImpl.createEcartDAO();
	}
	
	public static MyCartImpl createMyCart() {
		if(obj==null) obj=new MyCartImpl();
		return obj;
	}

	@Override
	public List<EcartBean> showCart(int uid) {
		ecartDAO=EcartDAOImpl.createEcartDAO();
		List<EcartBean> allEcartEntities=ecartDAO.getCart(uid);
		//business logic.. provide a complete invoice
		//need to modify mycart.jsp to show many details..
		
		return allEcartEntities;
	}
}
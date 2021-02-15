package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EcartBean;
import dto.EcartDataDTO;
import utility.ConnectionUtility;

public class EcartDAOImpl extends EcartDAO{
	private static EcartDAOImpl obj;
	private static final String ADD_TO_CART="insert into e_cart values(?, ?, ?);";
	private static final String GET_CART="select ec.uid, ec.itemid, ec.qty, im.itemdescription, im.price, sm.shopname, (qty*price) as Cost\r\n"
											+ "from e_cart ec\r\n"
											+ "left join item_master im\r\n"
											+ "	on ec.itemid=im.itemid\r\n"
											+ "left join shop_master sm\r\n"
											+ "	on im.shopid=sm.shopid\r\n"
											+ "where uid=?;";
	private static final String GET_CART_DATA="select uid, itemid, qty from e_cart where uid=?;";
	private EcartDAOImpl() {
	}
	
	public static EcartDAOImpl createEcartDAO() {
		if(obj==null) obj=new EcartDAOImpl();
		return obj;
	}
	
	@Override
	public void addToCart(int uid, String uname, int qty) {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(ADD_TO_CART);
			pst.setInt(1, uid);
			pst.setString(2, uname);
			pst.setInt(3, qty);
			pst.executeUpdate();
			
			ConnectionUtility.closeConnection(null);
		}catch(Exception e) {
			e.printStackTrace();
			ConnectionUtility.closeConnection(e);
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<EcartBean> getCart(int uid) {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<EcartBean> allItemsEcart=new ArrayList<EcartBean>();
		try {
			pst=con.prepareStatement(GET_CART);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			while(rs.next()) {
				EcartBean ecartBean=new EcartBean();
				
				ecartBean.setUid(rs.getInt(1));
				ecartBean.setItemid(rs.getString(2));
				ecartBean.setNumberOfUnit(rs.getInt(3));
				ecartBean.setItemdescription(rs.getString(4));
				ecartBean.setPrice(rs.getInt(5));
				ecartBean.setShopname(rs.getString(6));
				ecartBean.setCost(rs.getInt(7));
				
				allItemsEcart.add(ecartBean);
			}
			ConnectionUtility.closeConnection(null);
		}catch(Exception e) {
			e.printStackTrace();
			ConnectionUtility.closeConnection(e);
		}finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allItemsEcart;
	}
	
	@Override
	public List<EcartDataDTO> getCartData(int uid){
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<EcartDataDTO> ecartDataDTOs=new ArrayList<EcartDataDTO>();
		try {
			pst=con.prepareStatement(GET_CART_DATA);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				EcartDataDTO ecartDataDTO=new EcartDataDTO();
				ecartDataDTO.setUid(rs.getInt(1));
				ecartDataDTO.setItemid(rs.getString(2));
				ecartDataDTO.setQty(rs.getInt(3));
				
				ecartDataDTOs.add(ecartDataDTO);
			}
			//Note: connection is closed after setting values to invoice_master table
		}catch(Exception e) {
			e.printStackTrace(); 
			ConnectionUtility.closeConnection(e);
		}finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ecartDataDTOs;
	}
}
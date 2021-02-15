package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemDTO;
import utility.ConnectionUtility;

public class ItemDAOImpl extends ItemDAO {
	private static ItemDAOImpl obj;
	private static final String GET_SHOP_ITEMS="select * from item_master where shopid=?;";
	
	private ItemDAOImpl(){
	}
	public static ItemDAOImpl createItemDAO() {
		if(obj==null) obj=new ItemDAOImpl();
		return obj;
	}
	
	@Override
	public List<ItemDTO> displayItems(String shopid) {
		Connection con=ConnectionUtility.createConnection();
		List<ItemDTO> itemsInShop=new ArrayList<ItemDTO>();
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=con.prepareStatement(GET_SHOP_ITEMS);
			pst.setString(1, shopid);
			rs=pst.executeQuery();
			while(rs.next()) {
				ItemDTO itemDTO=new ItemDTO();
				itemDTO.setItemId(rs.getString(1));
				itemDTO.setItemDescription(rs.getString(2));
				itemDTO.setUnit(rs.getString(3));
				itemDTO.setPrice(rs.getFloat(4));
				itemDTO.setImageUrl(rs.getString(5));
				itemDTO.setShopId(rs.getString(6));
				itemsInShop.add(itemDTO);
			}
			ConnectionUtility.closeConnection(null);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionUtility.closeConnection(e);
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return itemsInShop;
	}
}
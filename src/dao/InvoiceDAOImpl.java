package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.EcartDataDTO;
import dto.InvoiceDTO;
import utility.ConnectionUtility;

public class InvoiceDAOImpl extends InvoiceDAO{
	private static final String INSERT_TRANSACTION="insert into invoice_transaction (billno, itemid, qty) values (?,?,?);"; 
	private static final String INSERT_INVOICE="insert into invoice_master (billno, billdate, customerid) values (?,?,?);";
	private static final String GET_INVOICE="select im.itemdescription, im.unit, it.qty, im.price, (qty*price) as cost\r\n"
												+ "from invoice_transaction it\r\n"
												+ "left join item_master im\r\n"
												+ "	on it.itemid=im.itemid\r\n"
												+ "where billno=?;";
	private static InvoiceDAOImpl obj;

	private InvoiceDAOImpl() {
		super();
	}
	
	public static InvoiceDAOImpl createInvoiceDAO() {
		if(obj==null) obj=new InvoiceDAOImpl();
		return obj;
	}

	@Override
	public void setTransaction(String billno, List<EcartDataDTO> ecartDataDTOs) {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		try {
			for(EcartDataDTO obj:ecartDataDTOs) {
				pst=con.prepareStatement(INSERT_TRANSACTION);
				pst.setString(1, billno);
				pst.setString(2, obj.getItemid());
				pst.setInt(3, obj.getQty());
				pst.executeUpdate();
			}
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
	public void setInvoiceMaster(String billno, Date date, int uid) {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(INSERT_INVOICE);
			pst.setString(1, billno);
			pst.setDate(2, new java.sql.Date(date.getTime()));
			pst.setInt(3, uid);
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
	public List<InvoiceDTO> getInvoice(String billno) {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<InvoiceDTO> invoiceDTOs=new ArrayList<InvoiceDTO>();
		try {
			pst=con.prepareStatement(GET_INVOICE);
			pst.setString(1, billno);
			rs=pst.executeQuery();
			while(rs.next()) {
				InvoiceDTO invoiceDTO=new InvoiceDTO();
				invoiceDTO.setItemdescription(rs.getString(1));
				invoiceDTO.setUnit(rs.getString(2));
				invoiceDTO.setQty(rs.getInt(3));
				invoiceDTO.setPrice(rs.getInt(4));
				invoiceDTO.setCost(rs.getInt(5));
				invoiceDTOs.add(invoiceDTO);
			}
			ConnectionUtility.closeConnection(null);
		}catch(Exception exp) {
			exp.printStackTrace();
			ConnectionUtility.closeConnection(exp);
		}finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return invoiceDTOs;
	}
}

package business;

import java.util.Date;
import java.util.List;

import dao.EcartDAO;
import dao.EcartDAOImpl;
import dao.InvoiceDAO;
import dao.InvoiceDAOImpl;
import dto.EcartDataDTO;
import dto.InvoiceDTO;

public class GenInvoiceImpl implements GenInvoice{
	private static GenInvoiceImpl obj;
	private int uid;
	private static int i;
	
	private GenInvoiceImpl(int uid) {
		this.uid = uid;
	}
	
	public static GenInvoiceImpl createGenInvoice(int uid) {
		if(obj==null) obj=new GenInvoiceImpl(uid);
		return obj;
	}
	
	@Override
	public String setInvoiceTable() {
		EcartDAO ecartDAO=EcartDAOImpl.createEcartDAO();
		List<EcartDataDTO> ecartDataDTOs=ecartDAO.getCartData(uid);	//get cart from DB
		
		String billno=getBillno();
		Date date=new Date();
		
		InvoiceDAO invoiceDAO=InvoiceDAOImpl.createInvoiceDAO();
		invoiceDAO.setTransaction(billno, ecartDataDTOs);
		invoiceDAO.setInvoiceMaster(billno, date, uid);	//set invoice in DB
		return billno;
	}
	
	@Override
	public List<InvoiceDTO> getInvoice(String billno){
		InvoiceDAO invoiceDAO=InvoiceDAOImpl.createInvoiceDAO();
		List<InvoiceDTO> invoiceDTOs=invoiceDAO.getInvoice(billno);
		return invoiceDTOs;
	}
	
	private static String getBillno() {
		return "a"+i++;
	}
	
	@Override
	public Date getDate(String billno) {
		return null;
	}
}
//--left side
//uid
//customer name
//customer address

//--right side
//bill no.
//bill date

//==bill/invoice
//sl.no
//itemdescription
//item unit
//item qty
//price
//Total cost

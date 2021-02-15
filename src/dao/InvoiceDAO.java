package dao;

import java.util.Date;
import java.util.List;

import dto.EcartDataDTO;
import dto.InvoiceDTO;

public abstract class InvoiceDAO {
	public abstract void setTransaction(String billno, List<EcartDataDTO> ecartDataDTOs);
	public abstract void setInvoiceMaster(String billno, Date date, int uid);
	public abstract List<InvoiceDTO> getInvoice(String billno);
}

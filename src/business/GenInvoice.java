package business;

import java.util.Date;
import java.util.List;

import dto.InvoiceDTO;

public interface GenInvoice {
	public String setInvoiceTable();
	public List<InvoiceDTO> getInvoice(String billno);
	public Date getDate(String billno);
}

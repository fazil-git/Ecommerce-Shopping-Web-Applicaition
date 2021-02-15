package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.GenInvoice;
import business.GenInvoiceImpl;
import dto.InvoiceDTO;

public class InvoiceAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("uid");
		GenInvoice genInvoice=GenInvoiceImpl.createGenInvoice(uid);
		String billno=genInvoice.setInvoiceTable();
		
		session.setAttribute("billno", billno);
		List<InvoiceDTO> invoiceDTOs=genInvoice.getInvoice(billno);
		request.setAttribute("invoice", invoiceDTOs);
		
		return "invoice.success";
	}
}

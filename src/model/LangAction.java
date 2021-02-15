package model;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String lang=request.getParameter("lang");
		
		Locale locale=new Locale(lang);
		
		ResourceBundle rb=ResourceBundle.getBundle("utility.Dictionary", locale);
		session.setAttribute("rb", rb);
		
		return "lang.success";
		
	}
}
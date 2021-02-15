package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;

public class RequestProcessor implements Cloneable {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext ctx=request.getServletContext();
			
			Properties prop=(Properties) ctx.getAttribute("prop");
			String key=request.getParameter("formid");
			String value= prop.getProperty(key);
			
			Action action=(Action) Class.forName(value).getDeclaredConstructor().newInstance();
			String result=action.execute(request, response);
			
			String nextaction=prop.getProperty(result);
			RequestDispatcher rd=request.getRequestDispatcher(nextaction);
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public RequestProcessor getClone() {
		try {
			return (RequestProcessor) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

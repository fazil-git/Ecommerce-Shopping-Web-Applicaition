package control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MySessionFilter implements Filter {
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		HttpSession session=httpRequest.getSession();
		if(session.isNew()) {
			String formid=httpRequest.getParameter("formid");
			if(formid.equals("language")) {
				chain.doFilter(httpRequest, httpResponse);
			}else {
				session.invalidate();
				httpResponse.sendRedirect("index.html");
			}
		}else {
			chain.doFilter(httpRequest, httpResponse);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
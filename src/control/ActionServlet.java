package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DbUtility;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestProcessor rp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			rp=new RequestProcessor();
			ServletContext ctx=config.getServletContext();
			String location=config.getInitParameter("configLocation");
			String path=ctx.getRealPath(location);
			System.out.println(path);
			
			Properties prop=new Properties();
			prop.load(new FileInputStream(path));
			ctx.setAttribute("prop", prop);
			
			String location2=config.getInitParameter("dbconfigLocation");
			path=ctx.getRealPath(location2);
			Properties dbprop=new Properties();
			dbprop.load(new FileInputStream(path));
			ctx.setAttribute("dbprop", dbprop);
			
			DbUtility.setDriver(dbprop.getProperty("driver"));
			DbUtility.setUrl(dbprop.getProperty("url"));
			DbUtility.setUsername(dbprop.getProperty("username"));
			DbUtility.setPassword(dbprop.getProperty("password"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp=rp.getClone();
		rp.process(request, response);
	}

	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;

public class LogoutAction extends Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String uname=(String) session.getAttribute("uname");
			UserDAO userDAO=UserDAOImpl.createUserDAO();
			userDAO.setFlag(0, uname);
			session.invalidate();
			
		}
		return "logout.success";
	}
}

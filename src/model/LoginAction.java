package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.LoginBusiness;
import business.LoginBusinessImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		UserDAO userDAO=UserDAOImpl.createUserDAO();
		LoginBusiness loginBusiness=new LoginBusinessImpl(userDAO);
		
		if(loginBusiness.checkUser(uname, upass)) {
			int uid=loginBusiness.getUid();
			session.setAttribute("uid", uid);
			session.setAttribute("uname", uname);
			return "login.success";
		}
		return "login.fail";
	}
}
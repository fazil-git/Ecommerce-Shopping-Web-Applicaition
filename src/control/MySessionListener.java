package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public MySessionListener() {
        
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session=se.getSession();
    	System.out.println("-------------------------");
    	System.out.println("session created="+session.getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session=se.getSession();
    	System.out.println("session destoyed="+session.getId());
    	System.out.println("-------------------------");
    }
}
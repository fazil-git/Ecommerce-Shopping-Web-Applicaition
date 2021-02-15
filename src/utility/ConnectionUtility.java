package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	static Connection con;
	private ConnectionUtility() {
		
	}
	static {
		try {
			Class.forName(DbUtility.getDriver());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	public static Connection createConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection(DbUtility.getUrl(), DbUtility.getUsername(), DbUtility.getPassword());
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection(Exception exp) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(exp==null) con.commit();
				else con.rollback();
				
				con.close();
				tlocal.remove();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
package business;

public interface LoginBusiness {
	public boolean checkUser(String uname, String upass);
	public int getUid();
}
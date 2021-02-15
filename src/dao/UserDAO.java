package dao;

import dto.UserDTO;

public abstract class UserDAO {
	public abstract UserDTO getUser(String uname, String upass);
	public abstract void setFlag(int flag, String uname);
	public abstract int getUid();
}

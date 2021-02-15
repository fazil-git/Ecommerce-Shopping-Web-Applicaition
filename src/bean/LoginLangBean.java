package bean;

import java.util.ResourceBundle;

public class LoginLangBean {
	ResourceBundle resource;
	String username;
	String password;
	String submit;

	public final ResourceBundle getResource() {
		return resource;
	}

	public final void setResource(ResourceBundle resource) {
		this.resource = resource;
		username=resource.getString("username");
		password=resource.getString("password");
		submit=resource.getString("submit");
	}
	
	public final String getUsername() {
		return resource.getString("username");
	}

	public final String getPassword() {
		return password;
	}

	public final String getSubmit() {
		return submit;
	}
}

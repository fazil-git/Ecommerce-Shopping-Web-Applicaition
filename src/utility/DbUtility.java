package utility;

public class DbUtility {
	private static String driver, url, username, password;

	public static final String getDriver() {
		return driver;
	}

	public static final void setDriver(String driver) {
		DbUtility.driver = driver;
	}

	public static final String getUrl() {
		return url;
	}

	public static final void setUrl(String url) {
		DbUtility.url = url;
	}

	public static final String getUsername() {
		return username;
	}

	public static final void setUsername(String username) {
		DbUtility.username = username;
	}

	public static final String getPassword() {
		return password;
	}

	public static final void setPassword(String password) {
		DbUtility.password = password;
	}
	
}

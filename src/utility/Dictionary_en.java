package utility;

import java.util.ListResourceBundle;

public class Dictionary_en extends ListResourceBundle{
	private Object[][] contents= {
			{"username", "username"},
			{"password", "password"},
			{"submit", "submit"}
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}
}

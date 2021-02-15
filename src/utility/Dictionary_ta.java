package utility;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle {
	private Object[][] contents= {
			{"username", "பயனர்பெயர்"},
			{"password", "கடவுச்சொல்"},
			{"submit", "சமர்ப்பிக்கவும்"}
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}
}

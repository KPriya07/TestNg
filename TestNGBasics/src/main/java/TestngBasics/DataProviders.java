package TestngBasics;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "amazontestdata")
	public Object[][] showtestitem() {
		return new Object[][] { { "shoe" }, { "watch" }, { "phone" } };

	}

	@DataProvider(name = "facebooktestdata")
	public Object[][] showcredentials() {
		return new Object[][] { { "userName1", "password1" }, { "userName2", "password2" },
				{ "userName3", "password3" } };

	}

}

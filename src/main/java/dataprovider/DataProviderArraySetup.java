package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderArraySetup {

	//data driven testing using the testNG annotation. dataProvider aray setup
	@DataProvider(name = "userCredentialsFromInternalArray")
	public Object[][] createData1() {
		return new Object[][] {
			{ "admin", "useradmin1"},
			{ "admin1", "useradmin"},
			{ "admin", "useradmin"}  
		};
	}

}
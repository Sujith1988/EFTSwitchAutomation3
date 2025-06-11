package dataprovider;

import org.testng.annotations.DataProvider;

public class ArrayDataProvider {


		//data driven testing using the testNG annotation. dataProvider aray setup
		@DataProvider(name = "RCData1")
		public Object[][] createData1() {
			return new Object[][] {
				{ "ATMRC", "spare"},
				{ "EvertecCred", "spare"},
				{ "MdsRC", "spare"},  
				{ "NaiguataRC", "spare"}  
			};
		}
}

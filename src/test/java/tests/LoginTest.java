package tests;
import java.io.IOException;

import org.testng.annotations.Test;
import base.TestBase;
import utils.popupWindwHandlr;
import dataprovider.ExcelDataProvider;
import pages.Home;
import pages.Login;
public class LoginTest extends TestBase {	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public static void LoginFunc(String usrN, String passW) throws NumberFormatException, InterruptedException, IOException {
		
		// POM -- Login page (class object-instance created and constructor invoked)
		Login log = new Login();	
				
		// The actual login fuction testing
		log.userNameFill(usrN);
		log.userPassFill(passW);
			Thread.sleep(log.slp_2);
		log.loginbtnClick();
			Thread.sleep(log.slp_1);
			
		
		//handling the alert window popup 💡	
		int alert_active = popupWindwHandlr.alertHandler();				
		
		
		// POM -- home page (class object-instance created and constructor invoked)
		Home hom = new Home();
		
		//Logout and printing the test status
		if(alert_active==0) {
			String LogoutText = hom.getButtonText();
			System.out.println(LogoutText);
			hom.clickButton();	    //Thread.sleep(slp_1);
			String actual = hom.actualText;
			
			
			if(LogoutText.equals(actual)) {
			System.out.println("*******Login test-positive success and clicked on button :"+LogoutText +"*****");
			}
		}else if(alert_active==1) {
			System.out.println("******Login test-negative success(Login failed!!)*******");
			
		}

	}
	
};
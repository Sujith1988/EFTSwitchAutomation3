package tests;
import java.io.IOException;
import org.testng.annotations.Test;
import base.TestBase;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.G_AlphaNode;

public class A_LoginTest extends TestBase {	
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;    
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();    	
    	A_Login login = new A_Login();
    	
    	A_LoginTest.home = home;    	
    	A_LoginTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/  
    
    
  
    
    
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(groups = {"reggrsn1","conf"}, priority = 1, enabled = true)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    
          
							
	
	/*---------Login Test scenario, +ve and -ve test cases*/
	@Test(groups = "login", priority = 2, dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void LoginFunc(String usrN, String passW) throws NumberFormatException, InterruptedException, IOException  {		
		// POM -- Login page (class object-instance created and constructor invoked)		
		pomCall();	
		
		// login fuction test case
		login.userNameFill(usrN);
		login.userPassFill(passW);
		Thread.sleep(login.slp_2);	
		login.loginbtnClick();
		Thread.sleep(login.slp_2);												
		//handling the alert window popup 💡	
		int alert_active = popupWindwHandlr.alertHandler();			
		
		
		
			
		// After enter into Home page, Logout button clicking 
		String LogoutText = home.getButtonText();
		System.out.println(LogoutText);
		home.clickButton(); // Thread.sleep(slp_1);
		String actual = home.actualText();
			
		// printing the test status
		if (LogoutText.equals(actual)) 
		System.out.println("*******Login test-positive success and clicked on button :" + LogoutText + "*****");					 
	}

};
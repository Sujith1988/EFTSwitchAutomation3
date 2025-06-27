package tests;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;

public class A_LoginTest extends TestBase {	
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;    
    public static A_Login login;
    public static WebDriverWait wait;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();    	
    	A_Login login = new A_Login();    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	
    	A_LoginTest.home = home;    	
    	A_LoginTest.login = login;
    	A_LoginTest.wait = wait;
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
		login.loginbtnClick();
												
		 // ✅ Wait for alert to be present before calling handler
	    try {
	        wait.until(ExpectedConditions.alertIsPresent()); // wait up to 2 seconds
	        popupWindwHandlr.alertHandler();
	        
	        System.out.println("Login test-negative success : Alert within 2s, Accepted.");
	    
	    } catch (TimeoutException e) {
	        System.out.println("Login test-positive success : No alert, Timeout of 2s elapsed.");
	        
	     // After enter into Home page, Logout button clicking 
			String LogoutText = home.getButtonText();
			System.out.println(LogoutText);
			
			home.clickLogoutButton(); 
			
			String actual = home.actualText();			
			// printing the test status
			if (LogoutText.equals(actual)) 
			System.out.println("Clicked :" + LogoutText + " button");
	    }														 
	}

	
	
	
	@Test(groups = "login", priority = 3)
	static void failit() {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("one", "two", "LoginTest Failing Forcefully using soft-assertEquals");
		soft.assertAll();
	}
	
	
};
package tests;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;


public class A_LoginTest extends TestBase {	
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(A_LoginTest.class.getName());
	
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
    @Test(groups = {"reggrsn1","conf"}, priority = 1, enabled = false)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    	
    	loger.info("Login success using admin credentials, (reggrsn1 test)");
    	Reporter.log("Login success using admin credentials, (reggrsn1 test)");
    }
    
    
          
    						
	
	/*---------Login Test scenario, +ve and -ve test cases*/
	@Test(groups = "login", priority = 2, dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void LoginFunc(String usrN, String passW) throws NumberFormatException, InterruptedException, IOException  {		
		// POM -- Login page (class object-instance created and constructor invoked)		
		pomCall();	
				
		// login fuction test case
		login.userNameFill(usrN);
		loger.info("Enter username, success");
		
		login.userPassFill(passW);	
		loger.info("Enter password, success");
		
		login.loginbtnClick();
		loger.info("Login button click, success");			
		loger.info("Login using credentials: " +usrN +" & " +passW +", (Login test)");			
		
		 
	    try {
	    	// ✅ Wait for alert to be present before calling handler
	        wait.until(ExpectedConditions.alertIsPresent()); // wait up to 2 seconds
	      
	        popupWindwHandlr.alertHandler();	        
	        loger.info("Login fail : Alert appeared within 2s, Accepted.");
	        Reporter.log("Login fail : Alert appeared within 2s, Accepted.");	
	        
	        try {
	        	Assert.assertEquals(false, true);
			} catch (AssertionError ae) {
				// TODO: handle exception
				loger.error("Assertion failed: Expected message 'false' but got 'true'",  ae);
				throw ae;
			}
	        
//	        SoftAssert soft = new SoftAssert();
//			soft.assertEquals("one", "two", "softassert testing");			
//			soft.assertAll();
	        
	    } catch (TimeoutException e) {
	    	loger.info("Timeout of 2s elapsed : No alert found");	        
	        	     
	        String actual = home.actualText();
	        loger.info("actual button text, " +actual);
	        
	        String LogoutText = home.getButtonText();
			loger.info("logout buttun text captured, " +LogoutText);
			
			if (LogoutText.equals(actual)) {
				loger.info("Login success using credentials: " +usrN +" & " +passW +", (Login test)");	
			    Reporter.log("Login success using credentials: " +usrN +" & " +passW +", (Login test)");
			    
			    // After enter into Home page, Logout button clicking 
			    home.clickLogoutButton();
			    loger.info("logout button click, success");
			}																		
								
	    }
	    
	    
	}

	
	
	
	@Test(groups = "login", priority = 3, enabled = true)
	static void failit() {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals("one", "two", "softassert testing");
			loger.info("LoginTest Failed Forcefully using soft-assertEquals");
			soft.assertAll();
		} catch (AssertionError ae) {
			// TODO: handle exception
			loger.error("assertion failure:", ae);
			throw ae;
		}				
	}
	
	
};
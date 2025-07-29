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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
    
 
    
    
  /*---------------Extent Report----------------*/    
//    public static ExtentSparkReporter spark;
//    public static ExtentReports extent;
//    
//     @Test (priority=1) 
//    public static void extrep() {
//    	
//    spark = new ExtentSparkReporter("./reports/extent-report.html");  
//	 extent = new ExtentReports();   
//	 spark.config().setTheme(Theme.DARK);
//	 spark.config().setDocumentTitle("Automation Report");
//	 spark.config().setReportName("Extent Report 1");
//	 extent.attachReporter(spark);	
//    	 
//    }
 /*---------------Extent Report----------------*/   
    
    
    
	
	/*------Login as Admin user(credential from locator.props)--------*/
	@Test(groups = "login", priority = 1, enabled = true)
	public static void adminlogin() throws IOException, InterruptedException {

		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Login Test Report");
		spark.config().setReportName("All Tests in Login class");

		ExtentTest test = extent.createTest("adminlogin");
		pomCall();
		adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test);

		loger.info("Login success using admin credentials, (Login test)");
		Reporter.log("Login success using admin credentials, (Login test)");
		test.pass("Login success using admin credentials, (Login test)");

		String actual = home.actualText();
		String LogoutText = home.getButtonText();
		if (LogoutText.equals(actual)) {
			// After enter into Home page, Logout button clicking

			home.clickLogoutButton();
			loger.info("logout button click, success");
			test.pass("logout button click, success");
		}

		extent.flush();
	}
    
    
          
    						
	
	/*---------Login Test scenario, +ve and -ve test cases*/
	@Test(groups = { "reggrsn1","conf" }, priority = 2, dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void LoginFunc(String usrN, String passW) throws NumberFormatException, InterruptedException, IOException {

		pomCall();

		extent.attachReporter(regression);
		regression.config().setTheme(Theme.DARK);
		regression.config().setDocumentTitle("Regression-Suite Report");
		regression.config().setReportName("All tests in regression suite");

		ExtentTest test1 = extent.createTest("LoginFunc");
		// login fuction test case
		login.userNameFill(usrN);
		loger.info("Enter username, success");
		test1.pass("Enter username, success : " + usrN);

		login.userPassFill(passW);
		loger.info("Enter password, success");
		test1.pass("Enter password, success : " + passW);

		login.loginbtnClick();
		loger.info("Login button click, success " + ", (Regression test)");
		test1.pass("Login button click, success " + ", (Regression test)");

		try {
			// Wait for alert to be present before calling handler
			wait.until(ExpectedConditions.alertIsPresent()); // wait up to 2 seconds

			popupWindwHandlr.alertHandler();
			loger.info("Login fail : Alert appeared within 2s, Accepted.");
			Reporter.log("Login fail : Alert appeared within 2s, Accepted.");
			test1.fail("Login failed : Alert appeared within 2s, Accepted.");

			try {
				test1.fail("Assertion fail: Executed to mark the test as fail");
				Assert.assertEquals(false, true);
				// SoftAssert soft = new SoftAssert();
				// soft.assertEquals("one", "two", "softassert testing");
				// soft.assertAll();

			} catch (AssertionError ae) {
				loger.error("Assertion exception captured : ", ae);
				test1.fail("Assertion exception captured : " + ae);
				throw ae;
			}

		} catch (TimeoutException e) {
			loger.info("Timeout of 2s elapsed : No alert found");
			test1.pass("Timeout of 2s elapsed : No alert found");

			String actual = home.actualText();
			loger.info("actual button text, " + actual);

			String LogoutText = home.getButtonText();
			loger.info("logout buttun text captured, " + LogoutText);

			if (LogoutText.equals(actual)) {
				loger.info("Login success, (Regression test)");
				Reporter.log("Login success, (Regression test)");
				test1.pass("Login success, (Regression test)");

				// After enter into Home page, Logout button clicking
				home.clickLogoutButton();
				loger.info("logout button click, success");
				test1.pass("logout button click, success");
			}

			// Login again using admin credential
			adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test1);
		}
		extent.flush();
	}

	
	
	
	@Test(groups = "login", priority = 3, enabled = true)
	static void failit() {
		
	ExtentTest test2 = extent.createTest("failit");

		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals("one", "two", "softassert testing");
			loger.info("LoginTest Failed Forcefully using soft-assertEquals");
			test2.fail("LoginTest Failed Forcefully using soft-assertEquals");

			soft.assertAll();
			
		} catch (AssertionError ae) {
			
			loger.error("assertion exception captured : ", ae);
			test2.fail("assertion exception captured : " + ae);
			throw ae;
		}
		extent.flush();
	}
	
	
};
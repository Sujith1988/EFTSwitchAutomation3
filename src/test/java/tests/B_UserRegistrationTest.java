package tests;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.B_UserRegistration;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;
public class B_UserRegistrationTest extends TestBase {	
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(B_UserRegistrationTest.class.getName());
	
	
        
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static B_UserRegistration userReg;
    public static A_Login login;
    
    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	B_UserRegistration userReg = new B_UserRegistration();
    	A_Login login = new A_Login();
    	
    	B_UserRegistrationTest.home = home;
    	B_UserRegistrationTest.userReg = userReg;
    	B_UserRegistrationTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/
	
    
    
    
    
	/*------Login as Admin user(credential from locator.props)--------*/
	@Test(priority = 1)
	public static void adminlogin() throws IOException, InterruptedException {

		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("adminlogin");

		pomCall();
		adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test);

		loger.info("Login success using admin credentials for local-test(class-level-test)");
		Reporter.log("Login success using admin credentials for local-test(class-level-test)");
		test.pass("Login success using admin credentials, (Login test)");
		extent.flush();
	}
	
    
    
    
    
	/*--------New users adding as per the data from xcelSheet--------*/
	@Test(groups = "reggrsn1", priority = 2, dataProvider = "usersData", dataProviderClass = ExcelDataProvider.class, retryAnalyzer = utils.Retry.class) // dependsOnMethods
																																							// =
																																							// "adminlogin",
	public static void adduser(String fName, String lName, String eMail, String phNum, String usrName, String paswd,
			String cnfrmpaswd, String loginUser, String loginPass) throws IOException, InterruptedException {
		
		ExtentTest test1 = extent.createTest("adduser");

		pomCall();

		// add user fuction testing
		home.clickHome();
		loger.info("Home Button click, success");
		test1.pass("Home Button click, success");

		home.clickUserLink();
		loger.info("User link click, success");
		test1.pass("User link click, success");

		home.clickAddUserLink();
		loger.info("Add user link click, success");
		test1.pass("Add user link click, success");

		String pagHeadr = userReg.pageHeader_addUser();
		String actualPageHeader = userReg.actPagHeader_addUser();
		if (pagHeadr.equals(actualPageHeader)) {
			loger.info("Page Verification success and Entered the Page : " + pagHeadr);
			test1.pass("Page Verification, success : " + pagHeadr);

			try {
				userReg.firstName(fName);
				userReg.lastName(lName);
				userReg.emailID(eMail);
				userReg.phonNum(phNum);
				userReg.userRole();
				userReg.roleOption();
				userReg.userName(usrName);
				userReg.pass(paswd);
				userReg.confirmPass(cnfrmpaswd);
				userReg.saveUserConf();

				loger.info("User registration foarm submitting, success for user:" + fName + " " + lName);
				test1.pass("User registration foarm submitting, success for user:" + fName + " " + lName);

			} catch (Exception e) {
				loger.info("User registration foarm submitting, failed for user:" + fName + " " + lName);
				loger.info(e);
				test1.fail("User registration foarm submitting, failed for user :" + fName + " " + lName);
			}

			
			
			String msg = popupWindwHandlr.popupHandler(fName, "Users added as per the exel data : ",
					"Error in loading add user page : ");
			
			try {
				Assert.assertEquals(msg, "Added Successfully");
				test1.pass("assert success, User added successfully");
				
			} catch (AssertionError ae) {	
				test1.fail("assert failed to meet the expected : 'Added Successfully' , with the actual : " +msg);
				loger.error("Assertion failed: Expected message 'Added Successfully' but got '{}'", msg, ae);
				throw ae;
			}

		}
		
		extent.flush();
	}	
		
		
	  
	
	
	
	
	
	@Test(priority = 3, enabled = false)
	static void failit() {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("haia", "hai", "Soft assert failed");
		soft.assertAll();
	}
	
	
	
	
	
	/*--------Users deleting as per the data from the xcelSheet--------*/
	@Test(groups = "reggrsn1", priority = 4, dataProvider = "usersData", dataProviderClass = ExcelDataProvider.class)
	static void verifyUser(String fName, String lName, String eMail, String phNum, String usrName, String paswd,
			String cnfrmpaswd, String loginUser, String loginPass) throws IOException, InterruptedException {
		
		ExtentTest test2 = extent.createTest("verify and delete User");

		// verify user fuction testing
		home.clickHome();
		loger.info("Home Button click, success");
		test2.pass("Home button click, success");

		home.clickUserLink();
		loger.info("User link click, success");
		test2.pass("User link click, success");

		home.clickViewUserLink();
		loger.info("View user link click, success");
		test2.pass("View user link click, success");

		String pagHeadr = userReg.pageHeader_viewUser();
		String actualPageHeader = userReg.actPagHeader_viewUser();
		if (pagHeadr.equals(actualPageHeader)) {
			loger.info("Page Verification success and Entered the Page : " + pagHeadr);
			test2.pass("Page Verification, success : " + pagHeadr);

			userReg.deletUser(usrName);
			loger.info("User(" + fName + " " + lName + ") deleting..");
			test2.pass("User(" + fName + " " + lName + ") deleting..");

			String msg = popupWindwHandlr.popupHandler(usrName, "Users deleted as per the exel data : ",
					"Error in loading view user page : ");
			try {
				Assert.assertEquals(msg, "Deleted!!");
				test2.pass("assert success, Deleted!!");

			} catch (AssertionError ae) {
				test2.fail("assert failed to meet the expected : ' Deleted!!' , with the actual : " + msg);
				loger.error("popupWindwHandlr.popupHandler did not executed");
				throw ae;
			}

		}
		
		extent.flush();
	}
		
	
	
	 //manually failing the test to check onfailure listener
	 @Test(priority = 5, enabled = false)
	 static void failTest() {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("mla", "hik", "Soft assert failed");
		soft.assertAll();			
	  }
		
	   
}
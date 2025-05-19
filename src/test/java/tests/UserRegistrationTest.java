package tests;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.Home;
import pages.Login;
import pages.UserRegistration;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;
public class UserRegistrationTest extends TestBase {
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(groups = "reggrsn1")
    public static void adminlogin() throws IOException, InterruptedException {
    	Login log = new Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
	
    
    
    /*--------New users adding as per the data from xcelSheet--------*/
	@Test(dataProvider = "usersData", dataProviderClass = ExcelDataProvider.class, dependsOnMethods = "adminlogin", retryAnalyzer = utils.Retry.class,priority = 1)
	public static void adduser(String fName, String lName, String eMail, String phNum, String usrName, String paswd, String cnfrmpaswd, String loginUser, String loginPass) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				Home h = new Home();
		// POM -- UserRegistration page (class object-instance created and constructor invoked)
		        UserRegistration u = new UserRegistration();
	    // POM -- UserRegistration page (class object-instance created and constructor invoked)
		        Login log = new Login();
		       
		// add user fuction testing
		h.clickHome();
		h.clickUserLink();	   Thread.sleep(log.slp_2);		
		h.clickAddUserLink();
		String pagHeadr = u.pageHeader_addUser();
		String actualPageHeader = u.actPagHeader_addUser();
		if (pagHeadr.equals(actualPageHeader)) {
			u.firstName(fName);
			u.lastName(lName);
			u.emailID(eMail);
			u.phonNum(phNum);
			u.userRole();
			u.roleOption();
			u.userName(usrName);
			u.pass(paswd);
			u.confirmPass(cnfrmpaswd);	   Thread.sleep(log.slp_2);				
			u.saveUserConf();              Thread.sleep(log.slp_2);
			
		//handling the alert window popup 💡	
		int alert_active = popupWindwHandlr.alertHandler();	
		System.out.println("users added as per the exel data :"+alert_active);
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("haia", "hai", "Soft assert failed");
		soft.assertAll();
		}
		else {
			System.out.println("error in loading add user page");
		}					
	}  
	
	
	
	  /*--------Users deleting as per the data from the xcelSheet--------*/
	   @Test(dataProvider = "usersData", dataProviderClass = ExcelDataProvider.class, priority = 2, groups = "reggrsn1") 
	   static void verifyUser(String fName, String lName, String eMail, String phNum, String usrName, String paswd, String cnfrmpaswd, String loginUser, String loginPass) throws IOException, InterruptedException {
			Home h = new Home();
	        UserRegistration u = new UserRegistration();  
	        Login log = new Login();
	// verify user fuction testing
	h.clickHome();  	
	h.clickUserLink();    Thread.sleep(log.slp_2);
	h.clickViewUserLink();
	String pagHeadr = u.pageHeader_viewUser();
	String actualPageHeader = u.actPagHeader_viewUser();
	if (pagHeadr.equals(actualPageHeader)) {	
			u.deletUser(usrName);	     Thread.sleep(log.slp_2);		
			String alert_active = popupWindwHandlr.alertHandler1();	
			System.out.println("users treated as per the exel data :"+alert_active);
			
			//manually failing the test to check onfailure listener
			SoftAssert soft = new SoftAssert();
			soft.assertEquals("haia", "hai", "Soft assert failed");
			soft.assertAll();
										
	}
  }	
}
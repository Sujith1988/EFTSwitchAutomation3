package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.B_UserRegistration;
import pages.C_SystemConfig;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class C_SystemConfigTest extends TestBase{
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static C_SystemConfig sysConf;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	C_SystemConfig sysConf = new C_SystemConfig();
    	A_Login login = new A_Login();
    	
    	C_SystemConfigTest.home = home;
    	C_SystemConfigTest.sysConf = sysConf;
    	C_SystemConfigTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/

    
    
    
    
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }


    
    
    
//, retryAnalyzer = utils.Retry.class
/*--------Deleting the fields from the Sys.Conf. from View-Conf. Page and adding new Conf. using Add-Conf page--------*/
	@Test(groups = {"reggrsn1", "conf"}, priority = 2, dataProvider = "sysConfData", dataProviderClass = ExcelDataProvider.class)
	public static void editSysConf(String paramName, String tr, String td, String tdEditbtn, String tdDelbtn, String paramKey, String paramValue, String paramStatus) throws IOException, InterruptedException {					
		pomCall();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		home.clickHome();
		home.clickonBasicConf();	    Thread.sleep(login.slp_2);		
		home.clickonSysConf();         Thread.sleep(login.slp_2);	
		home.clickonViewSysConf();     Thread.sleep(login.slp_2);	
		String pagHeadr = sysConf.pageHeader_viewsysConf();
		String actualPageHeader = sysConf.actPagHeader_viewsysConf();
		if (pagHeadr.equals(actualPageHeader)) {
			System.out.println("Entered the Page : " +pagHeadr);
			
			//Edit
			sysConf.clickonViewSysConfEditbtn(paramName,tr,td,tdEditbtn);
			sysConf.clickonUpdatebtn();              Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(login.slp_2);	
										
			//Delete
			sysConf.clickonViewSysConfEditbtn(paramName,tr,td,tdDelbtn);      Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();                            Thread.sleep(login.slp_2);			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
			
		
		
		
		// Add Sys. Conf:-  Add configurations testing
		home.clickonAddSysConf();                   Thread.sleep(login.slp_2);	
		String pagHeadr1 = sysConf.pageHeader_addsysConf();
		String actualPageHeader1 = sysConf.actPagHeader_addsysConf();
		if (pagHeadr1.equals(actualPageHeader1)) {
			System.out.println("Entered the Page : " +pagHeadr1);
			
			//Add
			sysConf.clickonSelectParam();        Thread.sleep(login.slp_2);
			sysConf.selectParam(paramKey);       Thread.sleep(login.slp_2);
			sysConf.selectparamValue(paramValue);      Thread.sleep(login.slp_2);	
			sysConf.clickonparamStatus();        Thread.sleep(login.slp_2);	
			sysConf.selectParamStatus(paramStatus);
			sysConf.saveSysConf();               Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();
		}
		else  System.out.println("error in loading add Add Sys Conf page");   
					
	}  
	

	
	
//	@Test(priority = 3)
//	static void failit() {
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals("haia", "hai", "Soft assert failed");
//		soft.assertAll();
//	}

}
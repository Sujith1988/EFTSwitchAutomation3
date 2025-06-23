package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.C_SystemConfig;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class C_SystemConfigTest extends TestBase{

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }


//, retryAnalyzer = utils.Retry.class

/*--------Deleting the fields from the Sys.Conf. from View-Conf. Page and adding new Conf. using Add-Conf page--------*/
	@Test(groups = {"reggrsn1", "conf"}, dataProvider = "sysConfData", dataProviderClass = ExcelDataProvider.class, priority = 2)
	public static void editSysConf(String paramName, String tr, String td, String tdEditbtn, String tdDelbtn, String paramKey, String paramValue, String paramStatus) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				A_Home h = new A_Home();
		// POM -- System Conf page (class object-instance created and constructor invoked)
				C_SystemConfig sys = new C_SystemConfig();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		h.clickHome();
		h.clickonBasicConf();	    Thread.sleep(log.slp_2);		
		h.clickonSysConf();         Thread.sleep(log.slp_2);	
		h.clickonViewSysConf();     Thread.sleep(log.slp_2);	
		String pagHeadr = sys.pageHeader_viewsysConf();
		String actualPageHeader = sys.actPagHeader_viewsysConf();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit
			sys.clickonViewSysConfEditbtn(paramName,tr,td,tdEditbtn);
			sys.clickonUpdatebtn();              Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);	
										
			//Delete
			sys.clickonViewSysConfEditbtn(paramName,tr,td,tdDelbtn);      Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();                            Thread.sleep(log.slp_2);			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
			
		
		
		
		// Add Sys. Conf:-  Add configurations testing
		h.clickonAddSysConf();                   Thread.sleep(log.slp_2);	
		String pagHeadr1 = sys.pageHeader_addsysConf();
		String actualPageHeader1 = sys.actPagHeader_addsysConf();
		if (pagHeadr1.equals(actualPageHeader1)) {
			
			//Add
			sys.clickonSelectParam();        Thread.sleep(log.slp_2);
			sys.selectParam(paramKey);       Thread.sleep(log.slp_2);
			sys.selectparamValue(paramValue);      Thread.sleep(log.slp_2);	
			sys.clickonparamStatus();        Thread.sleep(log.slp_2);	
			sys.selectParamStatus(paramStatus);
			sys.saveSysConf();               Thread.sleep(log.slp_2);			
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
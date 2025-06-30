package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
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
/*--------Updating and Deleting the fields from the Sys.Conf. from View-Conf. Page --------*/
	@Test(groups = {"reggrsn1"}, priority = 2, dataProvider = "sysConfData", dataProviderClass = ExcelDataProvider.class)
	public static void editSysConf(String paramName, String tr, String td, String tdEditbtn, String tdDelbtn, String paramKey, String paramValue, String paramStatus) throws IOException, InterruptedException {					
		pomCall();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		home.clickHome();
		home.clickonBasicConf();	    		
		home.clickonSysConf();         
		home.clickonViewSysConf();     
		String pagHeadr = sysConf.pageHeader_viewsysConf();
		String actualPageHeader = sysConf.actPagHeader_viewsysConf();
		if (pagHeadr.equals(actualPageHeader)) {
			System.out.println("Entered the Page : " +pagHeadr);
			
			//Edit
			sysConf.clickonViewSysConfEditbtn(paramName,tr,td,tdEditbtn);
			
			//update
			sysConf.clickonUpdatebtn();              						
			popupWindwHandlr.popupHandler(paramName, "System Configuration updated : ", "error in updating System Conf. : ");
			    						
			//Delete
			sysConf.clickonViewSysConfEditbtn(paramName,tr,td,tdDelbtn);      	
			popupWindwHandlr.popupHandler(paramName, "System Configuration deleted : ", "error in deleting System Conf. : ");
			
		}
		else {  System.out.println("error in loading 'View Sys Conf' page");   }
			
		
	}
	
	
		
	
	
	/*--------Adding new Conf. using Add-Conf page--------*/
	@Test(groups = {"reggrsn1", "conf"}, priority = 3, dataProvider = "sysConfData", dataProviderClass = ExcelDataProvider.class)
	public static void addSysConf(String paramName, String tr, String td, String tdEditbtn, String tdDelbtn, String paramKey, String paramValue, String paramStatus) throws IOException, InterruptedException {					
		pomCall();
		       
		// Add Sys. Conf:-
		home.clickHome();
		home.clickonBasicConf();	    		
		home.clickonSysConf(); 						
		home.clickonAddSysConf();                   
		String pagHeadr1 = sysConf.pageHeader_addsysConf();
		String actualPageHeader1 = sysConf.actPagHeader_addsysConf();
		if (pagHeadr1.equals(actualPageHeader1)) {
			System.out.println("Entered the Page : " +pagHeadr1);
			
			//Add
			sysConf.clickonSelectParam();        
			sysConf.selectParam(paramKey);       
			sysConf.selectparamValue(paramValue);      
			sysConf.clickonparamStatus();        
			sysConf.selectParamStatus(paramStatus);
			sysConf.saveSysConf();               			
			popupWindwHandlr.popupHandler(paramKey, "System Configuration added : ", "error in deleting System Conf. : ");
		
		}
		else  System.out.println("error in loading add Add Sys Conf page");   
											
	}  
	

	
	
//	@Test(priority = 4)
//	static void failit() {
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals("haia", "hai", "Soft assert failed");
//		soft.assertAll();
//	}
	
		
}
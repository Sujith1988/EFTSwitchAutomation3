package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.C_SystemConfig;
import pages.D_RoutingCatagory;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class D_RCTest extends TestBase{
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static D_RoutingCatagory rc;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	D_RoutingCatagory rc = new D_RoutingCatagory();
    	A_Login login = new A_Login();
    	
    	D_RCTest.home = home;
    	D_RCTest.rc = rc;
    	D_RCTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/
    
    
    
    
    
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    
    
    /*--------Deleting the fields from the RC. from View-RC. Page and adding new fields using Add-RC page--------*/
	@Test(groups = "reggrsn1", priority = 2, dataProvider = "RCData", dataProviderClass = ExcelDataProvider.class)
	public static void editRC(String paramName, String tr, String td, String tdEditbtn) throws IOException, InterruptedException {					
		pomCall();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		home.clickHome();
		Thread.sleep(login.slp_2);
		home.clickonRoutingCatagory();
		Thread.sleep(login.slp_2);			
		home.clickonViewRoutingCatagory();     
		Thread.sleep(login.slp_2);	
		String pagHeadr = rc.pageHeader_viewRC();
		String actualPageHeader = rc.actPagHeader_viewRC();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit button click and update
			rc.clickonViewRCEditbtn(paramName,tr,td,tdEditbtn);
			Thread.sleep(login.slp_2);
			rc.clickonRCUpdatebtn();
			Thread.sleep(login.slp_2);
			popupWindwHandlr.alertHandler();     
			Thread.sleep(login.slp_2);
			
			//Delete
			rc.clickonViewRCEditbtn(paramName,tr,td,tdEditbtn);Thread.sleep(login.slp_2);	
			rc.clickonRCDeletebtn();              Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(login.slp_2);
			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
				
	}
	
	
	
	
	
	
	
	// ----------------Adding Routing Catagory--------------
	@Test(groups = {"reggrsn1", "conf"}, priority = 3, dataProvider = "RCData1", dataProviderClass = ArrayDataProvider.class)
	public static void addRC(String rcName, String spare) throws IOException, InterruptedException {
		pomCall();
		
		home.clickHome();
		Thread.sleep(login.slp_2);
		home.clickonRoutingCatagory();	   
		Thread.sleep(login.slp_2);			
		home.clickonAddRoutingCatagory();     
		Thread.sleep(login.slp_2);
		rc.routingCatagory(rcName);
		Thread.sleep(login.slp_2);
		rc.clickonroutingCatagorySavebtn();
		popupWindwHandlr.alertHandler();     
		Thread.sleep(login.slp_2);
	}

}

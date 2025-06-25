package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.D_RoutingCatagory;
import pages.F_DestinationGroup;
import pages.G_AlphaNode;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class F_DGTest extends TestBase{
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static F_DestinationGroup dg;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	F_DestinationGroup dg = new F_DestinationGroup();
    	A_Login login = new A_Login();
    	
    	F_DGTest.home = home;
    	F_DGTest.dg = dg;
    	F_DGTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/ 
    
    
    
    
    
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    
    
    
    /*--------Deleting the fields from the DG. from View-DG. Page and adding new fields using Add-DG page--------*/
	@Test(groups = {"reggrsn1", "conf"}, dataProvider = "DGData", dataProviderClass = ExcelDataProvider.class, priority = 2)
	public static void editDG(String paramName, String tr, String td, String tdEditbtn, String DGName) throws IOException, InterruptedException {					
		pomCall();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		home.clickHome();
		home.clickonDestinationGrp();	    Thread.sleep(login.slp_2);			
		home.clickonViewDestinationGrp();     Thread.sleep(login.slp_2);	
		String pagHeadr = dg.pageHeader_viewDG();
		String actualPageHeader = dg.actPagHeader_viewDG();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn);   
			dg.clickonDGUpdatebtn();              
			Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();     
			Thread.sleep(login.slp_2);
			
			//Delete
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn); 
			dg.clickonDGDeletebtn();              
			Thread.sleep(login.slp_2);			
			popupWindwHandlr.alertHandler();     
			Thread.sleep(login.slp_2);
			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
		
		
		
		// Add DG:-  Add DG Configurations testing
				home.clickonAddDestinationGrp();                   Thread.sleep(login.slp_2);	
				String pagHeadr1 = dg.pageHeader_addDG();
				String actualPageHeader1 = dg.actPagHeader_addDG();
				if (pagHeadr1.equals(actualPageHeader1)) {
					
					//Add
					dg.destnatinGruop(DGName);        
					Thread.sleep(login.slp_2);
					dg.clickonDestinationGroupSavebtn();      
					Thread.sleep(login.slp_2);					             		
					popupWindwHandlr.alertHandler();
				}
				else  System.out.println("error in loading add Add Sys Conf page");   
							
	}  
		
		
}										
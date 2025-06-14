package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.B_Home;
import pages.A_Login;
import pages.D_RoutingCatagory;
import pages.F_DestinationGroup;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class F_DGTest extends TestBase{
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    
    /*--------Deleting the fields from the DG. from View-DG. Page and adding new fields using Add-DG page--------*/
	@Test(dataProvider = "DGData", dataProviderClass = ExcelDataProvider.class, priority = 2, groups = "reggrsn1")
	public static void editDG(String paramName, String tr, String td, String tdEditbtn, String DGName) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Routing Catagory page (class object-instance created and constructor invoked)
				F_DestinationGroup dg = new F_DestinationGroup();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		h.clickHome();
		h.clickonDestinationGrp();	    Thread.sleep(log.slp_2);			
		h.clickonViewDestinationGrp();     Thread.sleep(log.slp_2);	
		String pagHeadr = dg.pageHeader_viewDG();
		String actualPageHeader = dg.actPagHeader_viewDG();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn);   
			dg.clickonDGUpdatebtn();              Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
			
			//Delete
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn); 
			dg.clickonDGDeletebtn();              Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
		
		
		
		// Add DG:-  Add DG Configurations testing
				h.clickonAddDestinationGrp();                   Thread.sleep(log.slp_2);	
				String pagHeadr1 = dg.pageHeader_addDG();
				String actualPageHeader1 = dg.actPagHeader_addDG();
				if (pagHeadr1.equals(actualPageHeader1)) {
					
					//Add
					dg.destnatinGruop(DGName);        Thread.sleep(log.slp_2);
					dg.clickonDestinationGroupSavebtn();       Thread.sleep(log.slp_2);					             		
					popupWindwHandlr.alertHandler();
				}
				else  System.out.println("error in loading add Add Sys Conf page");   
							
	}  
		
		
}										
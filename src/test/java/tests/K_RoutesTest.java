package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.K_Routes;
import pages.B_Home;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class K_RoutesTest extends TestBase {

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    @Test(priority = 2, dataProvider = "RouteData", dataProviderClass = ExcelDataProvider.class, groups = "reggrsn1")
    public static void editRoutes(String paramName, String tr, String td, String tdbtn) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Card Group page (class object-instance created and constructor invoked)
				K_Routes rt = new K_Routes();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	
		        
		        
		        
		     // Add Route:-  add new Route for testing
				h.clickHome();
				rt.scrollToRoutConf(); 
				h.clickRouting();	    Thread.sleep(log.slp_2);			
				h.clickAddRoute();     Thread.sleep(log.slp_2);	
				String pagHeadr = rt.pageHeader_addRoutes();
				String actualPageHeader = rt.actPagHeader_addRoutes();
				if (pagHeadr.equals(actualPageHeader)) {	
					
					rt.selectparamsAddRoute("dropdown_route_dg", "option_routes_dg3");
					rt.selectparamsAddRoute("dropdown_route_cg", "option_routes_cg2");
					rt.selectparamsAddRoute("dropdown_route_omega", "option_routes_omega1");
					rt.selectparamsAddRoute("dropdown_route_rc", "option_routes_rc3");
					
					rt.routeConfSavBtn();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
				}
		        
		        
		        
		
		     // View Route:-  view//edit Route for testing
				h.clickHome();
				rt.scrollToRoutConf(); 
				h.clickRouting();	    Thread.sleep(log.slp_2);			
				h.clickViewEditRoute();     Thread.sleep(log.slp_2);	
				String pagHeadr1 = rt.pageHeader_viewRoutes();
				String actualPageHeader1 = rt.actPagHeader_viewRoutes();
				if (pagHeadr1.equals(actualPageHeader1)) {											
					rt.editRoutebtn(paramName, tr, td, tdbtn);
					Thread.sleep(2000);
					rt.updateRoute();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
	
					rt.editRoutebtn(paramName, tr, td, tdbtn);
					Thread.sleep(2000);
					rt.deleteRoute();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);																	
					
										
				}	
				
				
				
				
				// Add Route:-  add new Route for testing
				h.clickHome();
				rt.scrollToRoutConf(); 
				h.clickRouting();	    Thread.sleep(log.slp_2);			
				h.clickAddRoute();     Thread.sleep(log.slp_2);	
				String pagHeadr2 = rt.pageHeader_addRoutes();
				String actualPageHeader2 = rt.actPagHeader_addRoutes();
				if (pagHeadr2.equals(actualPageHeader2)) {	
					
					rt.selectparamsAddRoute("dropdown_route_dg", "option_routes_dg3");
					rt.selectparamsAddRoute("dropdown_route_cg", "option_routes_cg2");
					rt.selectparamsAddRoute("dropdown_route_omega", "option_routes_omega1");
					rt.selectparamsAddRoute("dropdown_route_rc", "option_routes_rc3");
					
					rt.routeConfSavBtn();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
				}
				
				
				
	}
}

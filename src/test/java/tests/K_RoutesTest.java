package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.J_Interchanges;
import pages.K_Routes;
import pages.A_Home;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class K_RoutesTest extends TestBase {
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static K_Routes rout;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	K_Routes rout = new K_Routes();
    	A_Login login = new A_Login();
    	
    	K_RoutesTest.home = home;
    	K_RoutesTest.rout = rout;
    	K_RoutesTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/
    
    

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	extent.attachReporter(spark);
    	ExtentTest test1 = extent.createTest("adminlogin");
    	
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test1);
    }
    
      
    
    
    // Add Route:-  add new Routes for configuration as well as for Regression testing
    @Test(groups = {"reggrsn1", "conf"}, priority = 2, dataProvider = "RouteData", dataProviderClass = ExcelDataProvider.class)
    public static void addRoutes(String paramName, String tr, String td, String tdbtn, String option_routes_dg, String option_routes_cg, String option_routes_omega, String option_routes_rc) throws IOException, InterruptedException {					    		        			        		        		           	
		//add route	
    	addRouteCommon(option_routes_dg, option_routes_cg,option_routes_omega, option_routes_rc);    	   	
	}
          
  
    
    
    // View Route:-  Update, Delete Routes for Regressin testing and then re-add
    @Test(groups = {"reggrsn1"}, priority = 3, dataProvider = "RouteData", dataProviderClass = ExcelDataProvider.class)
    public static void addRoutes1(String paramName, String tr, String td, String tdbtn, String option_routes_dg, String option_routes_cg, String option_routes_omega, String option_routes_rc) throws IOException, InterruptedException {					    		        			        		        		           			
    	//update and then delete route for testing
    	viewRouteCommon(paramName, tr, td, tdbtn);
    	
    	//add route			
    	addRouteCommon(option_routes_dg, option_routes_cg,option_routes_omega, option_routes_rc);    	    	   	
	}
		        
		        
	
     			    
                                     
    
    
    
    
    
    /*-------------General Functions--------------------------*/
    
    // Add Route:-  add new Route
    public static void addRouteCommon(String option_routes_dg, String option_routes_cg, String option_routes_omega, String option_routes_rc) throws IOException, InterruptedException {					
    	pomCall();
		        		        			        		        		            	
		home.clickHome();
		rout.scrollToRoutConf();
		home.clickRouting();	    		
		home.clickAddRoute();     	
		String pagHeadr = rout.pageHeader_addRoutes();
		String actualPageHeader = rout.actPagHeader_addRoutes();
		if (pagHeadr.equals(actualPageHeader)) {	
			System.out.println("Entered the Page : " +pagHeadr);
					
			rout.selectparamsAddRoute("dropdown_route_dg", option_routes_dg);
			rout.selectparamsAddRoute("dropdown_route_cg", option_routes_cg);
			rout.selectparamsAddRoute("dropdown_route_omega", option_routes_omega);
			String routingCat = rout.selectparamsAddRoute("dropdown_route_rc", option_routes_rc);
					
					rout.routeConfSavBtn();

					popupWindwHandlr.popupHandler(routingCat, "Route added : ", "error in adding Route : ");
		}
    }
    
    
    
    
    
    //View Route -> Update and Delete
    public static void viewRouteCommon(String paramName, String tr, String td, String tdbtn) throws IOException, InterruptedException {					
    	pomCall();
		        		        			        		        		            	
    	home.clickHome();
    	rout.scrollToRoutConf(); 
    	home.clickRouting();	    		
    	home.clickViewEditRoute();     
    	String pagHeadr = rout.pageHeader_viewRoutes();
    	String actualPageHeader = rout.actPagHeader_viewRoutes();
    	if (pagHeadr.equals(actualPageHeader)) {
    		System.out.println("Entered the Page : " +pagHeadr);	
    		
    		//update
    		rout.editRoutebtn(paramName, tr, td, tdbtn);  		
    		rout.updateRoute();

    		popupWindwHandlr.popupHandler(paramName, "Route updated : ", "error in updating Route : ");

    	
    		//delete
    		rout.editRoutebtn(paramName, tr, td, tdbtn); 		
    		rout.deleteRoute();

    		popupWindwHandlr.popupHandler(paramName, "Route deleted : ", "error in deleting Route : ");															
    		    							
    	}	
    }
    
}
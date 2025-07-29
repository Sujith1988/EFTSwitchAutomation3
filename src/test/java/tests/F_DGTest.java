package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Home;
import pages.A_Login;
import pages.F_DestinationGroup;
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
    	extent.attachReporter(spark);
    	ExtentTest test1 = extent.createTest("adminlogin");
    	
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test1);
    }
    
    
    
    
    /*--------Deleting the fields from the DG. from View-DG. Page and adding new fields using Add-DG page--------*/
	@Test(groups = {"reggrsn1", "conf"}, dataProvider = "DGData", dataProviderClass = ExcelDataProvider.class, priority = 2)
	public static void editDG(String paramName, String tr, String td, String tdEditbtn, String DGName) throws IOException, InterruptedException {					
		pomCall();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		home.clickHome();
		home.clickonDestinationGrp();	    			
		home.clickonViewDestinationGrp();     
		String pagHeadr = dg.pageHeader_viewDG();
		String actualPageHeader = dg.actPagHeader_viewDG();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn);   
			dg.clickonDGUpdatebtn();              
			popupWindwHandlr.popupHandler(paramName, "Destination Group Updated : ", "error in updating Destination Group : ");

			
			//Delete
			dg.clickonViewDGEditbtn(paramName,tr,td,tdEditbtn); 
			dg.clickonDGDeletebtn();              
			popupWindwHandlr.popupHandler(paramName, "Destination Group deleted : ", "error in deleting Destination Group : ");

			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
		
		
		
		// Add DG:-  Add DG Configurations testing
				home.clickonAddDestinationGrp();                   	
				String pagHeadr1 = dg.pageHeader_addDG();
				String actualPageHeader1 = dg.actPagHeader_addDG();
				if (pagHeadr1.equals(actualPageHeader1)) {
					
					//Add
					dg.destnatinGruop(DGName);        
					dg.clickonDestinationGroupSavebtn();      
					popupWindwHandlr.popupHandler(DGName, "Destination Group added : ", "error in adding Destination Group : ");
				}
				else  System.out.println("error in loading add Add Sys Conf page");   
							
	}  
		
		
}										
package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;
import utils.SortingRowOfTable;

public class K_Routes extends TestBase	{

	public K_Routes() throws IOException {
		 LocatorReader loc =new LocatorReader();
		 wbWaitCall();
	   }
	  
	  //-------------------common-------------------------
	  public String getLocator(String loctr) {
		  return LocatorReader.props.getProperty(loctr);
	  }
	  public WebElement getElement(String loctr) {
		  return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getLocator(loctr))));
//		 return driver.findElement(By.xpath(getLocator(loctr)));
	  }
	//--------------------------------------------------------
	  
	  
	  
	  
	  /*---------------WebDriver wait definition-------------*/
	  public static WebDriverWait wait;
	  
	    // Function to call in your method:
	    public void wbWaitCall() throws IOException {   	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));    	    
	    	K_Routes.wait = wait;
	    }
	   /*-----------------------------------------------------*/
	    
	    
	  
	  
	  
//-----------View Route page actions---------------
	  
	  public String pageHeader_viewRoutes() {
			return getElement("pag_header_viewRoutes").getText();
		}	
		public String actPagHeader_viewRoutes() {
			return getLocator("actual_pag_header_viewRoutes");
		}

		
		
		
		
		// Route edit button click
		  
		/*  paramName  : search the second column (CG)
		  		   tr  : Route_table_rows
			       td  : Route_table_firstcolumn     
			     tdbtn : Route_edit_btn-colmn_on_pickedRow   */ 	
		public void editRoutebtn(String paramName, String tr, String td, String tdbtn) {							
			 SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);			
		}
		
		//Update Route			
		public void updateRoute(){
			getElement("updat_btn_route").click();
		}
	    //Delete Route			
		public void deleteRoute(){
			getElement("del_btn_route").click();
		}
				
		
		//Scroll up to the side-nav button Routing Conf
		public  void scrollToRoutConf() {
			ScrollUtil.scrollToAnElement(driver, getElement("routing_conf"));
		}
		
		
		//-----------Add Route page actions---------------
		  
		  public String pageHeader_addRoutes() {
				return getElement("pag_header_addRoutes").getText();
			}	
			public String actPagHeader_addRoutes() {
				return getLocator("actual_pag_header_addRoutes");
			}

			
			
			
			public String selectparamsAddRoute(String dropdown_selector_addRoute, String option_selector_addRoute) {
				getElement(dropdown_selector_addRoute).click();
				String txt = getElement(option_selector_addRoute).getText();
				getElement(option_selector_addRoute).click();
				return txt;
			}
//			public void enterCG(String CG) {			
//				getElement("input_cg_routes").sendKeys(CG);
//			}
//			public void enterOmegaNd(String Omeganode) {			
//				getElement("input_omega_routes").sendKeys(Omeganode);
//			}
//			public void enterRC(String RC) {			
//				getElement("input_rc_routes").sendKeys(RC);
//			}
			
			
			
			public void routeConfSavBtn() {			
				getElement("rout_conf_sav_btn").click();
			}
				
				
				
}

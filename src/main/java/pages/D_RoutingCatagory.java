package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.SortingRowOfTable;

public class D_RoutingCatagory extends TestBase{

	public D_RoutingCatagory() throws IOException {
		 LocatorReader loc =new LocatorReader();
	   }
	  
	  //-------------------common-------------------------
	  public String getLocator(String loctr) {
		  return LocatorReader.props.getProperty(loctr);
	  }
	  public WebElement getElement(String loctr) {
		 return driver.findElement(By.xpath(getLocator(loctr)));
	  }
	//--------------------------------------------------------
	  
	
	

	
	//-----------View Routing Catagory page actions---------------
	  
	  
	  public String pageHeader_viewRC() {
			return getElement("pag_header_viewRC").getText();
		}	
		public String actPagHeader_viewRC() {
			return getLocator("actual_pag_header_viewRC");
		}
		
		
	  
	
	/* Filter out one particular routing catagory, then click on the edit buton,
	   then update or delete it so that we can add it one more time */
	
	//Edit button in the View RC screen
	   /*  paramName : Comes directly from the excelsheet-RCDetails,  column-paramName		 		                	 
		         tr  : sysconf_table_rows
		         td  : sysconf_table_firstcolumn     
		       tdbtn : RC_edit_btn-colmn_on_pickedRow   */ 		        	
	   public void clickonViewRCEditbtn(String paramName, String tr, String td, String tdbtn) {				
			SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);
		}
	
		   
	
	// update the RC after clicking on the Edit button
		public void clickonRCUpdatebtn() {
			getElement("rout_cat_updatebtn").click();  
		}
				

	// delete the RC after clicking on the Edit button
		public void clickonRCDeletebtn() {
			getElement("rout_cat_delbtn").click();  
		}
	
	
	
	
	
	
	//-----------Add Routing Catagory page actions---------------
	
	public String pageHeader_addRC() {
		return getElement("pag_header_addRC").getText();
	}	
	public String actPagHeader_addRC() {
		return getLocator("actual_pag_header_addRC");
	}
	
	
	
	/*  key : provide the name for the routing catagory  */	
	public void routingCatagory(String rcName) {
		getElement("rout_catagry").sendKeys(rcName);
	}
	
	
	public void clickonroutingCatagorySavebtn() {
		getElement("rout_catagry_sav_btn").click();
	}
	
		
	
}

package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.SortingRowOfTable;

public class e_DestinationGroup extends TestBase {

	public e_DestinationGroup() throws IOException {
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
	  

	

	
	//-----------View Destination Group page actions---------------
	  public String pageHeader_viewDG() {
			return getElement("pag_header_viewDG").getText();
		}	
		public String actPagHeader_viewDG() {
			return getLocator("actual_pag_header_viewDG");
		}
		
		
		
	
	/* Filter out one particular destination group, then click on the edit buton,
	   then delete it so that we can add it one more time */
	
	
	//Edit button in the View DG screen
	   /*  paramName : Comes directly from the excelsheet-DGDetails,  column-paramName		 		                	 
		         tr  : sysconf_table_rows
		         td  : sysconf_table_firstcolumn     
		       tdbtn : DG_edit_btn-colmn_on_pickedRow   */ 		        	
	   public void clickonViewDGEditbtn(String paramName, String tr, String td, String tdbtn) {				
			SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);
		}
		

	
	     // update the DG after clicking on the Edit button
			public void clickonDGUpdatebtn() {
				getElement("destGrp_updatebtn").click();  
			}
					

		// delete the DG after clicking on the Edit button
			public void clickonDGDeletebtn() {
				getElement("destGrp_delbtn").click();  
			}




	  
	//-----------Add Destinatin Group page actions---------------

			public String pageHeader_addDG() {
				return getElement("pag_header_addDG").getText();
			}	
			public String actPagHeader_addDG() {
				return getLocator("actual_pag_header_addDG");
			}
			
					
		
		
		/*  key : provide the name for the Destination Group  */	
		public void destnatinGruop(String DGName) {
			getElement("dest_group").sendKeys(DGName);
		}
		
		
		public void clickonDestinationGroupSavebtn() {
			getElement("dest_group_sav_btn").click();
		}
		
	

}

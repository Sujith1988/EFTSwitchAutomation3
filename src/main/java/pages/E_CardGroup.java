package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;
import utils.SortingRowOfTable;

public class E_CardGroup extends TestBase {

	public E_CardGroup() throws IOException {
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
	  


	
	  
	  		//-----------Add Card Group page actions---------------
			public String pageHeader_addCG() {
				return getElement("pag_header_addCG").getText();
			}	
			public String actPagHeader_addCG() {
				return getLocator("actual_pag_header_addCG");
			}
			
			
			//Add new CG 			
			public void addNewCG(String key){
				getElement("add_btn_CG").sendKeys(getLocator(key));
			}
			//Save the new CG Name		
			public void saveNewCG(){
				getElement("sav_btn_CG").click();
			}
			
			//Navigate to View CG page
			public void continuetoViewCGpage() {
				getElement("cont_btn_CG").click();
			}
	  
	  	  
	  
	  
	  
	//-----------View Card Group page actions---------------
	  
	  public String pageHeader_viewCG() {
			return getElement("pag_header_viewCG").getText();
		}	
		public String actPagHeader_viewCG() {
			return getLocator("actual_pag_header_viewCG");
		}
		
		
		
		
		//Delete empty CG from the view CG page				
		public void delEmptyCG(){
			getElement("del_btn_CG").click();
		}
		//Update CG from the view CG page				
		public void updateCG(){
			getElement("updat_btn_CG").click();
		}
		
		
		
	
	/* TO Filter out one particular card group, then click on the view button,
	   then the view-BIN table opens, so that we can delete all the available 
	   BINs on that card group. Finally delete the cardgroup so as to add a new
	   card group with the same name */
	
	// Card group edit button click
	  
	/*  paramName  : MasterCard (or MasterCardCR, Naiguata, CMSCardGroup, Visa
	  		   tr  : CardGrouop_table_rows
		       td  : CardGroup_table_firstcolumn     
		     tdbtn : CG_view_btn-colmn_on_pickedRow   */ 	
	public void editCGbtn(String paramName, String tr, String td, String tdbtn) {							
		 SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);			
	}
	// BIN Edit edit button click
	public void editBINbtn(String paramNameX, String tr, String td, String tdbtn) {							
		String paramName = paramNameX.toString().replace(".0", "");
		SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);			
	}
	
		
										
	
			// scroll upto the element of the page
			public  void scrollToBinBtn(String key) {
				ScrollUtil.scrollToAnElement(driver, getElement(key));
			}
	
	
			// scroll to the bottom of the page
			public  void scrollbotom() {
				ScrollUtil.scrollToBottom(driver);
			}
			

	
			
		/*---------------For complete BIN setup-------------------*/	
			//add new BIN configuration
			public void binConfFun1(String bin, String bin_descr, String pan_len, String bin_len, String RC) {
				String binStr = bin.toString().replace(".0", "");
			getElement("addBinbtn").click();
			getElement("input_Bin").sendKeys(binStr);
			getElement("input_Descript").sendKeys(bin_descr);
			getElement("input_PanLen").sendKeys(pan_len);
			getElement("input_BinLen").sendKeys(bin_len);	
			getElement("input_RC").click();
			getElement(RC).click();
			getElement("saveBinbtn").click();		
			}
			/*----------------------------------*/	
			
			
	
		//add new BIN configuration
		public void binConfFun(String paramName2, String key2, String key3, String key4, String key5) {
		getElement("addBinbtn").click();
		String key1 = paramName2.toString().replace(".0", "");
		getElement("input_Bin").sendKeys(key1);
		getElement("input_Descript").sendKeys(getLocator(key2));
		getElement("input_PanLen").sendKeys(getLocator(key3));
		getElement("input_BinLen").sendKeys(getLocator(key4));	
//		getElement("input_RC").click();
//		getElement(key5).click();
//		getElement("saveBinbtn").click();		
		}
		public void clickonRCSelctr() {			
			getElement("input_RC").click();
		}
		public void RCoptions(String key5) {			
			getElement(key5).click();
		}
		public void binConfSav() {			
			getElement("saveBinbtn").click();
		}
		
	
		//update the BIN-Configuration 
		public void updateBin() {		
			getElement("bin_form_update_btn").click();		
		}
									
								
		//Home link in CG page
		public void clickonHomeLinkCG() {
			getElement("hom_link_CG").click();
		}
		
		
		

}

package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;
import utils.SortingRowOfTable;

public class J_Interchanges extends TestBase{

	public J_Interchanges() throws IOException {
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
	  
	  
	
	  
	  		//-----------Add node app page actions---------------
			public String pageHeader_addInterchange() {
				return getElement("pag_header_addInterchnge").getText();
			}	
			public String actPagHeader_addInterchange() {
				return getLocator("actPagHeader_addInterchnge");
			}
			
			
			//----------------------------------form-----------------------------------------------------
						
			
			//---------General Method for all the enter-inputs-----------
			public void enterinputVlaueInterchange(String input_field, String input_value){
				getElement(input_field).sendKeys(getLocator(input_value));
			}
											
			
			//---------General Method for all the select-options-----------
			//select-field			
			public void selectFieldInterchange(String select_field){
				getElement(select_field).click();
			}
			//select-field-option
			public void selectFieldOptionInterchange(String select_field_option){
				getElement(select_field_option).click();
			}//-----------------------------------------------------------
			
			
					
			//Save the new Interchange conf	
			public void saveAddNewInterchngbtn(){
				getElement("sav_btn_intrchnge_add").click();
			}
			
			
			
			
			
																							
			
			//-------------------Scrolls-----------------
			
			 // scroll upto the element of the page
			public void scrollToanElementMehod(String var) {
				ScrollUtil.scrollToAnElement(driver,getElement(var));
			}
			
			
			
			
			
			//-----------view/edit interchange page actions---------------
			public String pageHeader_viewInternchge() {
				return getElement("pag_header_viewIntrchng").getText();
			}	
			public String actPagHeader_viewInternchge() {
				return getLocator("actPagHeader_viewIntrchng");
			}
			
			
			//Edit button in the view-Interchange conf
			   /*  paramName : Comes directly from the InterchangesTest.class, MDSInterchangeTest	 		                	 
				         tr  : view interchange_table_rows
				         td  : view interchange_table_secondcolumn     
				       tdbtn : Interchange_edit_btn-colmn_on_pickedRow   */ 		        	
			   public void clickonViewIntrchangeEditbtn(String paramName, String tr, String td, String tdbtn) {				
					SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);
				}
			
		
			
			//Update btn Interchange conf		
			public void updateIntrchngbtn(){
				getElement("update_btn_IntrchngConf").click();
			}
			
			//Delete btn Interchange conf		
			public void deleteIntrchngbtn(){
				getElement("delete_btn_IntrchngConf").click();
			}
			
}

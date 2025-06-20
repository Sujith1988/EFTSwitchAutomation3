package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;

public class I_NodeApp extends TestBase{
	
	public I_NodeApp() throws IOException {
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
			public String pageHeader_addnodeApp() {
				return getElement("pag_header_addAlphaNode").getText();
			}	
			public String actPagHeader_addnodeApp() {
				return getLocator("actPagHeader_addAlphaNode");
			}
			
			
			//----------------------------------form-----------------------------------------------------
						
			//Enter Nodeapp Name			
			public void enterNodeAppinputValues(String nodeApp_input_value){
				getElement("nodeApp_input").sendKeys(getLocator(nodeApp_input_value));
			}//-----------------------------------------------------------
			
						
			
			//---------General Method for all the select-options-----------
			//input-selects of the form nodeapp add			
			public void selectInputNodeappAddForm(String node_form_input_selct){
				getElement(node_form_input_selct).click();
			}
			//input-options of the  form nodeapp select	
			public void optionInputNodAppAddForm(String nodApp_form_input_option){
				getElement(nodApp_form_input_option).click();
			}//-----------------------------------------------------------
			
			
					
			//Save the new Nodeapp Name		
			public void saveNewaddNodeApp(){
				getElement("sav_btn_nodAppConf").click();
			}
			
			
			
			
			
			
			
			//-----------view/edit node app connections page actions---------------
			public String pageHeader_viewnodeConnction() {
				return getElement("pag_header_viewnodeConnctn").getText();
			}	
			public String actPagHeader_viewnodeConnction() {
				return getLocator("actPagHeader_viewnodeConnctn");
			}
			

			
			//select the nodeapp for connction creation
			  /* use the genral method for select opion */
			
			
			//view button node connection
			public void viewNodeConnctnbtn(){
				getElement("view_btn_nodConnctn").click();
			}
			
			//Eidt btn the Nodeapp connections	
			public void eidtNodeConnctnbtn(){
				getElement("edit_btn_nodConnctnConf").click();
			}
			
			//Update btn Nodeapp connections	
			public void updateNodeConnctnbtn(){
				getElement("update_btn_nodConnctn").click();
			}
			
			//Delete btn Nodeapp connections		
			public void deleteNodeConnctnbtn(){
				getElement("Delete_btn_nodConnctn").click();
			}
			
			
			//---------------------Add Node app connection-------------------
			//Add new node-app sap connection			
			public void clickonaddNodeConnctnbtn(){
				getElement("add_btn_nodConnctn").click();
			}
			
			//Enter Sap name for node-app connection		
			public void enterSapNameNodeConnctn(String sap_name_nodeapp){
				getElement("sap_name_nodConnctn").sendKeys(getLocator(sap_name_nodeapp));
			}
			
			//Enter Sap ip for node-app connection		
			public void enterSapIPNodeConnctn(String nod_conn_ip){
				getElement("sap_ip_nodConnctn").sendKeys(getLocator(nod_conn_ip));
			}
			
			//Enter Sap port for node-app connection		
			public void enterSapPortNodeConnctn(String nod_conn_port){
				getElement("sap_port_nodConnctn").sendKeys(getLocator(nod_conn_port));
			}
			
			//Enter max.no.of node-app connection		
			public void enterSapMaxNoOfNodeConnctn(String nod_conn_max){
				getElement("sap_max_no_of_nodConnctn").sendKeys(getLocator(nod_conn_max));
			}
			
				
			//For selecting the nod app connection select and options 
			     /* use the General Method for all the select-options - line47  */
			
		
			
			//Save the nodeapp sap connection button		
			public void clickonsaveNodeConnctnbtn(){
				getElement("sav_btn_nodConnctn_add").click();
			}
			
			
			
			
			
			
			//-------------------Scrolls-----------------
			
			 // scroll upto the element of the page
			public void scrollToanElementMehod(String var) {
				ScrollUtil.scrollToAnElement(driver,getElement(var));
			}
			
			
			
			
			
			//-----------view/edit node app page actions---------------
			public String pageHeader_viewnodeApp() {
				return getElement("pag_header_viewnodeApp").getText();
			}	
			public String actPagHeader_viewnodeApp() {
				return getLocator("actPagHeader_viewnodeApp");
			}
			
			
			//Eidt btn the Nodeapp conf		
			public void eidtNodeAppbtn(){
				getElement("edit_btn_nodAppConf").click();
			}
			
			//Update btn Nodeapp conf		
			public void updateNodeAppbtn(){
				getElement("update_btn_nodAppConf").click();
			}
			
			//Delete btn Nodeapp conf		
			public void deleteNodeAppbtn(){
				getElement("Delete_btn_nodAppConf").click();
			}
			
			
			
			

}

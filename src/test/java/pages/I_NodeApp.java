package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;

public class I_NodeApp extends TestBase{
	
	public I_NodeApp() throws IOException {
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
	    	I_NodeApp.wait = wait;
	    }
	   /*-----------------------------------------------------*/
	    
	    
	
	  
	  		//-----------Add node app page actions---------------
			public String pageHeader_addnodeApp() {
				return getElement("pag_header_addnodeApp").getText();
			}	
			public String actPagHeader_addnodeApp() {
				return getLocator("actPagHeader_addnodeApp");
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
						
			//input-options text-field of the  form add nodeapp select-nodeapp-option
			public String optionTextInputNodAppAddForm(String nodApp_form_input_option){
				return getElement(nodApp_form_input_option).getText();				
			}
			//input-options text-field of the  form add nodeapp connection select-nodeapp-option
			public String optionTextInputNodAppConnAdd(String nodApp_form_input_option) {
				return getElement(nodApp_form_input_option).getText();
			}
			
			
			
					
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
			
		
			//text-field of the  table first row Node App Connections	
			public String textInputNodAppConn(){
				return getElement("nodeAppConn_name_toact").getText();				
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
			
			
			//text-field of the  table first row	
			public String textInputNodAppEditbtnrow(){
				return getElement("nodeApp_name_toact").getText();				
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

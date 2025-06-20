package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;

public class L_Commands extends TestBase {

	public L_Commands() throws IOException {
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
	  

// -----------Commands page actions---------------
	public String pageHeader_applicationCommands() {
		return getElement("pag_header_appl_cmmnds").getText();
	}	
	public String actPagHeader_applicationCommands() {
		return getLocator("actual_pag_header_appl_cmmnds");
	}
	
						
	
	
	//----------------------------------form-----------------------------------------------------
	
											
	//---------General Method for all the select-options-----------
	//select-field	
	/*  key : slct_cmnd, slct_intrface, slct_intrchange  */
	public void selectFieldCommand(String select_field){
		getElement(select_field).click();
	}
	//select-field-option
	/*  key : slct_cmnd_conect , slct_cmnd_disconect, slct_comnd_singn_on,
     slct_cmnd_singn_off , slct_cmnd_eco_req , slct_comnd_key_chnge_req ,
     slct_cmnd_trace_on , slct_cmnd_trace_off, slct_comnd_clean ,
     slct_cmnd_loger_on, slct_cmnd_loger_off, slct_cmnd_resync   */
	public void selectFieldOptionCommand(String select_field_option){
		getElement(select_field_option).click();
	}//-----------------------------------------------------------
	
	
			
	//Send Command Button	
	public void sendCommandbtn(){
		getElement("cmd_send_btn").click();
	}
	
	//get the success text msg
	public String successTxtmsg() {
		return getElement("succss_txt_msg").getText();
	}
}

package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;

public class b_Commands extends TestBase {

	public b_Commands() throws IOException {
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
	public String pageHeader_addsysConf() {
		return getElement("pag_header_add_usr").getText();
	}	
	public String actPagHeader_addsysConf() {
		return getLocator("actual_pag_header_add_usr");
	}
	
	
	/*  key : slct_cmnd, slct_intrface, slct_intrchange  */	
	public void clickonSelectCommand(String key) {
		getElement("key").click();
	}	
	
	/*  key : slct_cmnd_conect , slct_cmnd_disconect, slct_comnd_singn_on,
	 	      slct_cmnd_singn_off , slct_cmnd_eco_req , slct_comnd_key_chnge_req ,
	 	      slct_cmnd_trace_on , slct_cmnd_trace_off, slct_comnd_clean ,
	 	      slct_cmnd_loger_on, slct_cmnd_loger_off, slct_cmnd_resync   */	   
	public void selectItemToCommand(String key) {
		getElement("key").click();
	}	
	
	
	
	public void clickonCommandSend() {
		getElement("cmd_send_btn").click();
	}	
		
}

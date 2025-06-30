package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;

public class L_Commands extends TestBase {

	public L_Commands() throws IOException {
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
	    	L_Commands.wait = wait;
	    }
	   /*-----------------------------------------------------*/
	  
	  
	  
	  
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
	
	
	
	//----------get the success text msg-----------------
	public WebElement waitForTextToBePresent(String locatorKey) {
	    By locator = By.xpath(getLocator(locatorKey));
	    
	    return wait.until(driver -> {
	        WebElement el = driver.findElement(locator);
	        String text = el.getText();
	        if (text.contains("Something went wrong") || text.contains("OK") || text.contains("CONNECTED") || text.contains("RESYNCED")) {
	            return el;
	        }
	        return null; // keep waiting
	    });
	}

	public String successTxtmsg() {
	    return waitForTextToBePresent("succss_txt_msg").getText();
	}	//-------------------------------------------------------------	
							/*OR*/
	
	//------------------------------------------------------------
//	public String successTxtmsg() {
//	    return waitForTextToBePresent("succss_txt_msg").getText();
//	}
//	public WebElement waitForTextToBePresent(String locatorKey) {
//	    By locator = By.xpath(getLocator(locatorKey));
//	    
//	    // Wait for text to be present (returns Boolean)
//	    wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, "Something went wrong"));
//
//	    // Then return the actual WebElement
//	    return driver.findElement(locator);
//	}
	//--------------------------------------------------------		
						/*OR*/
	
	//------------------------------------------------------------
//	public String successTxtmsg() {
////return getElement("succss_txt_msg").getText();
// WebElement elem = wait.until(driver ->
//    !getElement("succss_txt_msg").getText().trim().isEmpty() ? getElement("succss_txt_msg") : null
//);
//return elem.getText();
//}
	//--------------------------------------------------------------		
						/*OR*/
	
	//---------------------------------------------------------
//	public WebElement waitForTextToBePresent(String locatorKey) {
//	    By locator = By.xpath(getLocator(locatorKey));
//	    return wait.until(driver -> {
//	        WebElement el = driver.findElement(locator);
//	        return !el.getText().trim().isEmpty() ? el : null;
//	    });
//	}
//
//	public String successTxtmsg() {
//	    return waitForTextToBePresent("succss_txt_msg").getText();
//	}
//---------------------------------------------------------------
	
	
}

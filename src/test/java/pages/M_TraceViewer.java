package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;

public class M_TraceViewer extends TestBase {

	public M_TraceViewer() throws IOException {
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
	    	M_TraceViewer.wait = wait;
	    }
	   /*-----------------------------------------------------*/
	    
	    
	    
	    
	    
	    

    //-----------Commands page actions---------------
	public String pageHeader_traceViewer() {
		return getElement("pag_header_traceViewer").getText();
	}	
	public String actPagHeader_traceViewer() {
		return getLocator("actual_pag_header_traceViewer");
	}
	
		
	//click on the Pravega Logger
	public void clickonPravegaLogger() {
		getElement("prav_log_link").click();
	}
		
	
}
package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;

public class M_TraceViewer extends TestBase {

	public M_TraceViewer() throws IOException {
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
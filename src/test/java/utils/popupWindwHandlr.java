package utils;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TestBase;
import postilion.realtime.sdk.crypto.impl.atalla.AtallaMsg.Msg;
import tests.A_LoginTest;

public class popupWindwHandlr extends TestBase {
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(popupWindwHandlr.class.getName());
	
//import the utility folder in to the package(tests)-> class(LoginTest)
// JavaScript Alert Popup (e.g. alert(), confirm()) : Handled using Alert interface:
	public static String alertHandler() {
		// 🔔 Alert Handling Block 🔔🔔🔔
		String msg="No alert found";
		try {
			Alert alert = driver.switchTo().alert();
			loger.info("Alert found: " + alert.getText());
			msg=alert.getText();
			alert.accept();	
			return msg;
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			return msg;
		}
		
	}	
	
	
	public static String alertHandler1() {
		String a;
		// 🔔 Alert Handling Block 🔔🔔🔔
		try {
			Alert alert = driver.switchTo().alert();			
			loger.info("Alert found: " + alert.getText());
			alert.accept();			
		} catch (org.openqa.selenium.NoAlertPresentException e) {		
			return a= "alert not found";
		}
		return a= "alert accepted";
	}	
	
	
	
	
 /*--------------------Popup Handler with webdriver wait-------------------*/
	
	public static String popupHandler(String paramName, String txt1, String txt2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		String msg="No alert found";
		// ✅ Wait for alert to be present before calling handler
	    try {
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	//handling the alert window popup 💡			        
	    	msg=alertHandler();	
	    	
	    	loger.info(txt1 +paramName +", (alert accepted)");		    	
	    	return msg;
	    } 
	    catch (TimeoutException e) {
	      
	        loger.info(txt2 +paramName +", No alert, Timeout of 2s elapsed.");	
	        return msg;
	    }
		
	}
	
	
}
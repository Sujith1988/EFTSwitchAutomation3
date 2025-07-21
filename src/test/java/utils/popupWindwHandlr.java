package utils;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
public class popupWindwHandlr extends TestBase {
//import the utility folder in to the package(tests)-> class(LoginTest)
// JavaScript Alert Popup (e.g. alert(), confirm()) : Handled using Alert interface:
	public static int alertHandler() {
		// 🔔 Alert Handling Block 🔔🔔🔔
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert found: " + alert.getText());
			alert.accept();
//			System.out.println("Alert accepted successfully.");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
//			System.out.println("No alert found");
			return 0;
		}
		return 1;
	}	
	
	
	public static String alertHandler1() {
		String a;
		// 🔔 Alert Handling Block 🔔🔔🔔
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert found: " + alert.getText());
			alert.accept();
			System.out.println("Alert accepted successfully.");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			System.out.println("No alert found");
			return a= "alert not found";
		}
		return a= "alert accepted";
	}	
	
	
	
	
 /*--------------------Popup Handler with webdriver wait-------------------*/
	
	public static void popupHandler(String paramName, String txt1, String txt2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		// ✅ Wait for alert to be present before calling handler
	    try {
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	//handling the alert window popup 💡			        
	    	alertHandler();	
			System.out.println(txt1 +paramName +", : alert accepted");					        
	    } 
	    catch (TimeoutException e) {
	        System.out.println(txt2 +paramName +", No alert, Timeout of 2s elapsed.");		        	     
	    }
		
	}
	
	
}
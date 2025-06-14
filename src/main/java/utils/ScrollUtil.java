package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {

	            // scroll upto the element of the page
				public static  void scrollToAnElement(WebDriver driver, WebElement obj) {
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", obj);                            
				}
				
				// scroll to bottom of the page
				public  static void scrollToBottom(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0, document.body.scrollHeight);");                            
				}
				
				// scroll to the top of the page
				public static void scrollToTop(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;      
					js.executeScript("window.scrollTo(0, 0);");
				}
				
}

package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollUtil {

	            // scroll upto the element of the page
				public static  void scrollToAnElement(WebDriver driver, WebElement obj) {
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", obj);                            
				}
				
				// scroll to bottom of the page smoothly
				public  static void scrollToBottom(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
					js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");					        					            					            					        					    
				}
				
				// scroll to the top of the page
				public static void scrollToTop(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;      
					js.executeScript("window.scrollTo(0, 0);");
				}
				
				// scroll to the right of the page
				public static void scrollToRight(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;      
					js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
				}
				
				
				public static void zoomOutAndScrollRightInWindow(WebDriver driver) {
				    JavascriptExecutor js = (JavascriptExecutor) driver;

				    // Zoom out to 70%
				    js.executeScript("document.body.style.zoom='70%'");

				    // Scroll to the far right
				    js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
				}
				
				
				
				public static void zoomOutAndScrollRightInElement(WebDriver driver, WebElement scrollableDiv) {
				    JavascriptExecutor js = (JavascriptExecutor) driver;

				    // Step 2: Zoom out the container (optional)
				    js.executeScript("arguments[0].style.zoom='70%'", scrollableDiv);
				    				

				    // Step 3: Scroll to the right end inside the container
				    js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);
				}
																													


}

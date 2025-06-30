package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;

public class B_UserRegistration extends TestBase{
		//constructor
	  public B_UserRegistration() throws IOException {
		 LocatorReader loc =new LocatorReader();
		 wbWaitCall();
	   }
	  
	  
	  /*---------------WebDriver wait definition-------------*/
		public static WebDriverWait wait;

	    // Function to call in your method:
	    public void wbWaitCall() throws IOException {   	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));    	    
	    	B_UserRegistration.wait = wait;
	    }
	    /*-----------------------------------------------------*/
	    
	    
	    
	  
	  //-------------------common-------------------------
	  public String getLocator(String loctr) {
		  return LocatorReader.props.getProperty(loctr);
	  }
	  public WebElement getElement(String loctr) {
		  return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getLocator(loctr))));
//		  return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getLocator(loctr)))));
//		  return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getLocator(loctr))));
//		 return driver.findElement(By.xpath(getLocator(loctr)));
	  }
	//--------------------------------------------------------
	  

// -----------Add user page actions---------------
	public String pageHeader_addUser() {
		return getElement("pag_header_add_usr").getText();
	}	
	public String actPagHeader_addUser() {
		return getLocator("actual_pag_header_add_usr");
	}
	
	
	 
	public void firstName(String key) {
		getElement("frst_name").sendKeys(key);
	}	
	public void lastName(String key) {
		getElement("last_name").sendKeys(key);
	}
	public void emailID(String key) {
		driver.findElement(By.xpath(getLocator("user_email"))).sendKeys(key);
	}	
	public void phonNum(String key) {
		String key1 = key.toString().replace(".0", "");;
		getElement("ph_no").sendKeys(key1);
	}	
	public void userRole() {
		getElement("usr_rol").click();
	}
	public void roleOption() {
		getElement("selct_rol_admn").click();
	}
	public void userName(String key) {
		getElement("user_name").sendKeys(key);
	}
	public void pass(String key) {
		getElement("usr_pswd").sendKeys(key);
	}
	public void confirmPass(String key) {
		getElement("cnfrm_pswd").sendKeys(key);
	}
	
	
	public void saveUserConf() {
		getElement("sav_btn").click();
	}	
	public void deletUserConf() {
		getElement("cancl_btn").click();
	}

	
	
	
// ------------View user page actions---------------
	
	public String pageHeader_viewUser() {
		return getElement("pag_header_view_usr").getText();
	}	
	public String actPagHeader_viewUser() {
		return getLocator("actual_pag_header_view_usr");
	}
	
	
	/* key : jith, jith1, admin, etc. */
	public void deletUser(String key) {						
		// Target value to match
        String targetValue = key;
        boolean isMatchFound = false;

        // Get all rows in the tbody of the table
        List<WebElement> rows = driver.findElements(By.xpath(getLocator("user_table_rows")));
    
        // Loop through each row
        for (WebElement row : rows) {
            // Get the first column (td) of the current row
            WebElement firstColumn = row.findElement(By.xpath(getLocator("user_table_data_row1")));  // XPath index is 1-based
            String cellText = firstColumn.getText().trim();

            // Check if it matches the target value
            if (cellText.equalsIgnoreCase(targetValue)) {
                System.out.println("Match found: " + cellText);
                isMatchFound = true;
                row.findElement(By.xpath(getLocator("user_delet_btn_on_pickedRow"))).click();              
                break;
            }
        }

        if (!isMatchFound) {
            System.out.println("No match found for: " + targetValue);
        }		
	}	
}

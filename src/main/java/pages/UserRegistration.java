package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.TestBase;
import utils.LocatorReader;

public class UserRegistration extends TestBase{
	  public UserRegistration() throws IOException {
		 LocatorReader loc =new LocatorReader();
	   }
	  
	  public String getLocator(String loctr) {
		  return LocatorReader.props.getProperty(loctr);
	  }
// -----------Add user page---------------
	public String pageHeader_addUser() {
		return driver.findElement(By.xpath(LocatorReader.props.getProperty("pag_header_add_usr"))).getText();
	}
	
	public void firstName(String key) {
		driver.findElement(By.id(getLocator("frst_name"))).sendKeys(key);
	}
	
	public void lastName(String key) {
		driver.findElement(By.id(getLocator("last_name"))).sendKeys(key);
	}
	
	public void emailID(String key) {
		driver.findElement(By.id(getLocator("user_email"))).sendKeys(key);
	}
	
	public void phonNum(String key) {
		driver.findElement(By.id(getLocator("ph_no"))).sendKeys(key);
	}
	
	public void userRole() {
		driver.findElement(By.id(getLocator("usr_rol"))).click();
	}
	
	public void roleOption() {
		driver.findElement(By.id(getLocator("selct_rol_admn"))).click();
	}
	
	public void userName(String key) {
		driver.findElement(By.id(getLocator("usr_name"))).sendKeys(key);
	}
	
	public void pass(String key) {
		driver.findElement(By.id(getLocator("usr_pswd"))).sendKeys(key);
	}
	
	public void confirmPass(String key) {
		driver.findElement(By.id(getLocator("cnfrm_pswd"))).sendKeys(key);
	}
	
	public void saveUserConf() {
		driver.findElement(By.id(getLocator("sav_btn"))).click();
	}
	
	public void deletUserConf() {
		driver.findElement(By.id(getLocator("cancl_btn"))).click();
	}
	
// ------------View user page---------------
	
	public String pageHeader_viewUser() {
		return driver.findElement(By.xpath(getLocator("pag_header_add_usr"))).getText();
	}
	
	public String userNameCheck() {
		return driver.findElement(By.xpath(getLocator("usr_name_on_viewpage"))).getText();
	}
	
	public void deletUser() {
		driver.findElement(By.id(getLocator("usr_delet_btn"))).click();
	}
	
}

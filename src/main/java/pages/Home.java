package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;

public class Home extends TestBase{			
	  public Home() throws IOException {
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
	  	  
	
   /*- - - - - - - - -side nav bar actions -  - - - - -  - - -*/  
	public String actualText() {
		return getLocator("btn_txt_logout_actual");
	}
	
	public String getButtonText() {
        return getElement("logout_btn").getText();
    }
	
	public void clickButton() {
		getElement("logout_btn").click();
    }
	
	public void clickHome() {
		getElement("home_btn").click();
    }
	
	public void clickUserLink() {
		getElement("user_link").click();
    }
		
	public void clickAddUserLink() {	
		getElement("add_user_link").click();
    }
	
	public void clickViewUserLink() {
		getElement("view_user_link").click();
    }
	
	public void clickBasicConf() {
		getElement("basic_conf").click();
    }
	
	public void clickSysConf() {
		getElement("sys_conf").click();
    }
	
	public void clickAddSysConf() {
		getElement("add_sys_conf").click();
    }
	
	public void clickViewSysConf() {
		getElement("view_sys_conf").click();
    }
	
	public void clickCardGrpAndBin() {
		getElement("card_grp&bin").click();
    }
	
	public void clickAddCardGrp() {
		getElement("add_card_grp").click();
    }
	
	public void clickViewCardGrpAndBin() {
		getElement("view_card_grp&bin").click();
    }
	
	public void clickAlphaConf() {
		getElement("alfa_conf").click();
    }
	
	public void clickAddAlphaNod() {
		getElement("add_alfa_nod").click();
    }
	
	public void clickViewEditAlphaNod() {
		getElement("view_edit_alfa_nod").click();
    }
	
}

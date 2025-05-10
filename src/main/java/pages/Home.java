package pages;

import java.io.IOException;
import org.openqa.selenium.By;

import base.TestBase;
import utils.LocatorReader;

public class Home extends TestBase{		
	  public Home() throws IOException {
		LocatorReader loc =new LocatorReader();
	  }
	
	public String actualText = LocatorReader.props.getProperty("btn_txt_logout_actual");
	
	public String getButtonText() {
        return driver.findElement(By.xpath(LocatorReader.props.getProperty("logout_btn"))).getText();
    }
	
	public void clickButton() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("logout_btn"))).click();
    }
	
	public void clickUserLink() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("user_link"))).click();
    }
	
	public void clickAddUserLink() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("add_user_link"))).click();
    }
	
	public void clickViewUserLink() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("view_user_link"))).click();
    }
	
	public void clickBasicConf() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("basic_conf"))).click();
    }
	
	public void clickSysConf() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("sys_conf"))).click();
    }
	
	public void clickAddSysConf() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("add_sys_conf"))).click();
    }
	
	public void clickViewSysConf() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("view_sys_conf"))).click();
    }
	
	public void clickCardGrpAndBin() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("card_grp&bin"))).click();
    }
	
	public void clickAddCardGrp() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("add_card_grp"))).click();
    }
	
	public void clickViewCardGrpAndBin() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("view_card_grp&bin"))).click();
    }
	
	public void clickAlphaConf() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("alfa_conf"))).click();
    }
	
	public void clickAddAlphaNod() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("add_alfa_nod"))).click();
    }
	
	public void clickViewEditAlphaNod() {
        driver.findElement(By.xpath(LocatorReader.props.getProperty("view_edit_alfa_nod"))).click();
    }
	
	
	
}

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
	
	public String getButtonText(String btn) {
        return driver.findElement(By.xpath(LocatorReader.props.getProperty(btn))).getText();
    }
	
	public void clickButton(String btn) {
        driver.findElement(By.xpath(LocatorReader.props.getProperty(btn))).click();
    }
	
	
}

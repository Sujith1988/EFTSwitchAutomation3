package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;


public class LoginTest extends TestBase {	
	@Test()
	public static void LoginFunc() throws NumberFormatException, InterruptedException {
		
		String usrN = "admin";
		String passW = "useradmin";
		
		// The actual login fuction testing
		WebElement username = driver.findElement(By.id(locs.getProperty("usr_name")));
		username.sendKeys(usrN);
		driver.findElement(By.id(locs.getProperty("pas_word"))).sendKeys(passW);
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_2")));
		driver.findElement(By.className(locs.getProperty("login_button"))).click();
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_1")));
			

	}

};
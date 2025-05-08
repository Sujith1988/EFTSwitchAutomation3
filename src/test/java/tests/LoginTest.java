package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.TestBase;
import utils.popupWindwHandlr;

public class LoginTest extends TestBase {	
	@Test(dataProvider = "userCredentialsFromInternalArray", dataProviderClass = TestBase.class)
	public static void LoginFunc(String usrN, String passW) throws NumberFormatException, InterruptedException {
		
		// The actual login fuction testing
		WebElement username = driver.findElement(By.id(usr));
		username.sendKeys(usrN);
		driver.findElement(By.id(psw)).sendKeys(passW);
		Thread.sleep(slp_2);
		driver.findElement(By.className(btn)).click();
		Thread.sleep(slp_1);
			
		
		//handling the alert window popup 💡	
		int alert_active = popupWindwHandlr.alertHandler();
		
		//printing the test status
		if(alert_active==0) {
			String LogoutText = driver.findElement(By.xpath("//a[@href='../../index.jsp']")).getText();
			System.out.println(LogoutText);
			driver.findElement(By.xpath("//a[@href='../../index.jsp']")).click();	
			String actual = "LOGOUT";
			if(LogoutText.equals(actual)) {
			System.out.println("*******Login test-positive success and clicked on button :"+LogoutText +"*****");
			}
		}else if(alert_active==1) {
			System.out.println("******Login test-negative success(Login failed!!)*******");
			//driver.findElement(By.xpath("//a[@href='../../index.jsp']")); --> if u want to fail the test case.
		}

	}
	
};
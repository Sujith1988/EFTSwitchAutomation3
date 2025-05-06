package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		// base --
		WebDriverManager.chromedriver().setup();		
		WebDriver driver =new ChromeDriver();
		
		// properties--config -- 
		String url = "http://localhost:8081/apt_switch_ui/";

		/* Manage the window and loading time out */
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); //props
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));    //props
		driver.get(url);
		Thread.sleep(2000);//props
		driver.manage().window().maximize();
		Thread.sleep(2000);//props

		/*Login using the credentials--> */		
		WebElement username = driver.findElement(By.id("username"));//locators  properties--config
		username.sendKeys("admin");		//credentials -- test data --csv,excel
		driver.findElement(By.id("password")).sendKeys("useradmin"); //properties--config --locators + test data
		Thread.sleep(200);
		driver.findElement(By.className("button")).click(); //properties--config --locators
		Thread.sleep(1000);

		/*  base --tear down*/
		driver.close();
		

	}

}

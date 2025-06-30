package base;
import java.io.IOException;
import java.time.Duration;
import utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.A_Login;

public class TestBase {
	public static WebDriver driver;
	
	//@BeforeTest ->for non datadriven testing only
	@BeforeTest(groups = {"reggrsn1", "conf", "function-P", "function-C", "login"})
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			//chromedriver system property setting and new driver obj instantiation
			ConfigReader conf =new ConfigReader();		
			
			// POM -- Login page (class object-instance created and constructor invoked)
			A_Login log = new A_Login();
			
			if (conf.brw.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
				driver.get(conf.url);	//url invoking		 
				System.out.println("Chrome browser setUP successful, loaded the URL");	
				
			}
			//firefoxdriver system property setting and new driver obj instantiation
			else if (conf.brw.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(conf.url);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(log.wnd_delay));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(log.pag_delay));
				System.out.println("Firefox browser setUP successful, loaded the URL");
				driver.manage().window().minimize();
			}
		}
	}

	
	
	//@AfterTest ->for non datadriven testing only
		@AfterTest(groups = {"reggrsn1", "conf", "function-P", "function-C", "login"})
		public void tearDown() throws InterruptedException {
			driver.quit();
			driver=null;  
			System.out.println("Tear down successful");		
		}
		
}

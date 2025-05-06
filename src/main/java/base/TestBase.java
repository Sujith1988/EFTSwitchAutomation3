package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties props = new Properties();
	public static Properties locs  = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	//@BeforeTest ->for non datadriven testing only
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		String user_dir = System.getProperty("user.dir");

		if (driver == null) {
			fr = new FileReader(user_dir + "\\src\\main\\resources\\config.properties");
			props.load(fr);
			fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\locators.properties");
			locs.load(fr1);

			//chromedriver system property setting and new driver obj instantiation
			if (props.getProperty("browserName").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
				driver.get(props.getProperty("urlName"));	//url invoking		 
				System.out.println("Chrome browser setUP successful, loaded the URL");					
			}

			//firefoxdriver system property setting and new driver obj instantiation
			else if (props.getProperty("browserName").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(props.getProperty("urlName"));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(locs.getProperty("windo_timeout"))));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(locs.getProperty("pag_load_wait"))));
				System.out.println("Firefox browser setUP successful, loaded the URL");
				driver.manage().window().minimize();
			}

		}

	}

	
	
	//@AfterTest ->for non datadriven testing only
		@AfterMethod
		public void tearDown() throws InterruptedException {
			driver.quit();
			driver=null;  
			System.out.println("Tear down successful");		
		}
}

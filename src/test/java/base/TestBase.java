package base;
import java.io.IOException;
import java.time.Duration;
import utils.ConfigReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.A_Login;
import tests.B_UserRegistrationTest;

public class TestBase {
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	
	public static ExtentSparkReporter spark;
	public static ExtentSparkReporter regression;
	public static ExtentSparkReporter function1;
    public static ExtentReports extent;	
    
	// @BeforeTest ->for non datadriven testing only
	@BeforeTest(groups = { "reggrsn1", "conf", "function-P", "function-C", "login" })
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {

			// chromedriver system property setting and new driver obj instantiation
			ConfigReader conf = new ConfigReader();

			// POM -- Login page (class object-instance created and constructor invoked)
			A_Login log = new A_Login();

			if (conf.brw.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(conf.url); // url invoking

				loger.info("Chrome browser setUP successful, loaded the URL");

			}

			// firefoxdriver system property setting and new driver obj instantiation
			else if (conf.brw.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(conf.url);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(log.wnd_delay));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(log.pag_delay));

				loger.info("Firefox browser setUP successful, loaded the URL");
				driver.manage().window().minimize();
			}
		}

		// Extent Reporter refernce setup
		spark = new ExtentSparkReporter("./reports/login-test-report.html");
		regression = new ExtentSparkReporter("./reports/regression-test-report.html");
		extent = new ExtentReports();

	}
	
	
	
	
	
	// @AfterTest ->for non datadriven testing only
	@AfterTest(groups = { "reggrsn1", "conf", "function-P", "function-C", "login" })
	public void tearDown() throws InterruptedException {
		driver.quit();
		driver = null;
		
		extent.flush();
		
		loger.info("Extent Report flushin over");
		loger.info("Tear down successful");
	}
		
}

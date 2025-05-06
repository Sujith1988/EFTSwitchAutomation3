package tests;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Test config reading from the property file.
		FileReader fr = new FileReader("F:\\eclipse workspaces\\1. Automation Frameworks Tutorial Maven\\EFTSwitchAutomation\\src\\main\\resources\\config.properties");		
		Properties props = new Properties();
		props.load(fr);	
		FileReader fr1 = new FileReader("F:\\eclipse workspaces\\1. Automation Frameworks Tutorial Maven\\EFTSwitchAutomation\\src\\main\\resources\\locators.properties");		
		Properties locs = new Properties();
		locs.load(fr1);	
		
		//Assigning the variable values from the properties files
		String browserEnv = props.getProperty("browserName");
		String testURL = props.getProperty("urlName");
		String usr = locs.getProperty("usr_name");
		String pass = locs.getProperty("pas_word");
		String logBtn = locs.getProperty("login_button");
		int timr1 = Integer.parseInt(locs.getProperty("windo_timeout"));
		int timr2 = Integer.parseInt(locs.getProperty("pag_load_wait"));
		int slp1 = Integer.parseInt(locs.getProperty("sleep_1"));
		int slp2 = Integer.parseInt(locs.getProperty("sleep_2"));

		
		// Test data reading from the csv file.
		    // --to be implemented.
		
		
		
		// base -- setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		String url = testURL; // props--

		/* Manage the window and loading time out */
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timr1)); //props
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(timr2));    //props
		driver.get(url);
		Thread.sleep(slp1);//props
		driver.manage().window().maximize();
		Thread.sleep(slp1);//props

		/*Login using the credentials--> */		
		WebElement username = driver.findElement(By.id(usr));//locators--props
		username.sendKeys("admin");		//credentials -- test data --csv,excel
		driver.findElement(By.id(pass)).sendKeys("useradmin"); //locators--props + test data
		Thread.sleep(slp2);
		driver.findElement(By.className(logBtn)).click(); //locators--props
		Thread.sleep(slp1);

		/*  base --tear down*/
		driver.close();
		
	}

}

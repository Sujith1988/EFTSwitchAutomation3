package pages;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.LocatorReader;
public class A_Login extends TestBase {
	public int wnd_delay = 10;
	public int pag_delay = 10;
	public int slp_1 = 10;

	//Constructor
	public A_Login() throws IOException {
		LocatorReader loc = new LocatorReader();
		wbWaitCall();

		wnd_delay = Integer.parseInt(LocatorReader.props.getProperty("windo_timeout"));
		pag_delay = Integer.parseInt(LocatorReader.props.getProperty("pag_load_wait"));
		slp_1 = Integer.parseInt(LocatorReader.props.getProperty("sleep_1"));
	};
	
	
	

	//initialization usually happen before the constucotor run. So must be initialised explicitly.
	public int slp_2 = Integer.parseInt(LocatorReader.props.getProperty("sleep_2", "10"));
	
	//----Login credential for admin user only, from the locators.props----
	public String admnUser = LocatorReader.props.getProperty("admin_user");
	public String admnPass = LocatorReader.props.getProperty("admin_password");
	
	
/*-----------------------actual used code starts from here-------------------------*/
	
	//---locators for the username,paswd and login button-------
		public String usr = LocatorReader.props.getProperty("usr_name");
		public String psw = LocatorReader.props.getProperty("pas_word");
		public String btn = LocatorReader.props.getProperty("login_button");
		
	
		
		
		
		
	/*---------------WebDriver wait definition-------------*/
	public static WebDriverWait wait;

    // Function to call in your method:
    public void wbWaitCall() throws IOException {   	    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));    	    
    	A_Login.wait = wait;
    }
    /*-----------------------------------------------------*/
    
		
	
    
    
	//----------Login page actions-------------
	/* key : admin */
	public  void userNameFill(String key) throws IOException {		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usr))).sendKeys(key);
		//driver.findElement(By.id(usr)).sendKeys(key);
	}

	/* key : useradmin */
	public void userPassFill(String key) throws IOException {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(psw))).sendKeys(key);
		//driver.findElement(By.id(psw)).sendKeys(key);
	}
	
	
	public void loginbtnClick() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(btn))).click();
		//driver.findElement(By.className(btn)).click();
	}

}

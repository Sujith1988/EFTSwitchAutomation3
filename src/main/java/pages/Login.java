package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.TestBase;
import utils.LocatorReader;

public class Login extends TestBase {
	public int wnd_delay = 10;
	public int pag_delay = 10;
	public int slp_1 = 10;

	public Login() throws IOException {
		LocatorReader loc = new LocatorReader();

		wnd_delay = Integer.parseInt(LocatorReader.props.getProperty("windo_timeout"));
		pag_delay = Integer.parseInt(LocatorReader.props.getProperty("pag_load_wait"));
		slp_1 = Integer.parseInt(LocatorReader.props.getProperty("sleep_1"));
	};

	public int slp_2 = Integer.parseInt(LocatorReader.props.getProperty("sleep_2", "10"));

	public String usr = LocatorReader.props.getProperty("usr_name");
	public String psw = LocatorReader.props.getProperty("pas_word");
	public String btn = LocatorReader.props.getProperty("login_button");

	public void userNameFill(String key) {
		driver.findElement(By.id(usr)).sendKeys(key);
	}

	public void userPassFill(String key) {
		driver.findElement(By.id(psw)).sendKeys(key);
	}

	public void loginbtnClick() {
		driver.findElement(By.className(btn)).click();
	}

}

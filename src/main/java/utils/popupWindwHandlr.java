package utils;

import org.openqa.selenium.Alert;

import base.TestBase;

public class popupWindwHandlr extends TestBase {

	
//import the utility folder in to the package(tests)-> class(LoginTest)
// JavaScript Alert Popup (e.g. alert(), confirm()) : Handled using Alert interface:
	public static int alertHandler() {
		// 🔔 Alert Handling Block 🔔🔔🔔
		int alert_active = 1;
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Login failed, Alert found: " + alert.getText());
			alert.accept();
			System.out.println("Alert accepted successfully.");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			System.out.println("No alert present, Clean login.");
			alert_active = 0;
		}
		return alert_active;
	}
	
}
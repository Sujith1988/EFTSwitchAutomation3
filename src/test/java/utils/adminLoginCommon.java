package utils;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import pages.A_Login;
public class adminLoginCommon extends TestBase {

	/*--------Admin login, used for other tests to login before the test-case run*/
	public static void adminLogin(String usr, String pas, A_Login obj, ExtentTest obj2) throws IOException, InterruptedException {			
		
		// The actual login fuction testing
		obj.userNameFill(usr);
		obj2.pass("Enter username, success : "+usr);
		
		obj.userPassFill(pas);
		obj2.pass("Enter password, success : "+pas);
		
		obj.loginbtnClick(); 
		obj2.pass("Login click, success : ");
	  }	
}

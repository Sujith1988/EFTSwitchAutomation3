package utils;
import java.io.IOException;
import pages.A_Login;
public class adminLoginCommon {

	/*--------Admin login, used for other tests to login before the test-case run*/
	public static void adminLogin(String usr, String pas, A_Login obj) throws IOException, InterruptedException {	
	   // The actual login fuction testing
		obj.userNameFill(usr);
		obj.userPassFill(pas);
		obj.loginbtnClick(); 			
	  }	
}

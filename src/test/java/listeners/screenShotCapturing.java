package listeners;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class screenShotCapturing extends utils.Common implements ITestListener {
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(screenShotCapturing.class.getName());
	
	
	public String scrnpath;
	@Override
	public void onTestFailure(ITestResult result) {										
		try {  /*-----Calling screen shot method---------*/
			scrnpath = screenShotCapturing(result.getName());
//			loger.info("screen captured: "+scrnpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			loger.error("Error in screen capturing", e);
			
		}  	  /*------------------------------------------*/	
				
		Reporter.log("the method failed & status are : " + result.getName() +", " +result.getStatus());
		System.setProperty("org.uncommons.reportng.escape-output", "false");  //--> this is for the reportng custom reports
		Reporter.log("<a href='"+System.getProperty("user.dir") + "/screenshot/" + scrnpath + "'>Screen Shot</a>");			
		loger.info("--Screen captured on test failure-- screenshot: " +scrnpath);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {							
	}
	
	@Override
	public void onTestStart(ITestResult result) {					
		//ReportNG custom Title setting
		System.setProperty("org.uncommons.reportng.title", "Custom-Report-Sujith");
	}
}
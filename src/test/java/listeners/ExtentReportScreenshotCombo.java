package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import utils.Common;


public class ExtentReportScreenshotCombo extends Common implements ITestListener {

	/*Calling the function getExtentReport() from the class utils.Common*/ 	
	public static ExtentReports report = getExtentReport();
	public static ExtentReports report1 = getExtentReport1();
	public static ExtentTest eTest;
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		
		// Creating Extent Test
		if(TestBase.listener.equalsIgnoreCase("log")) {
			eTest = report.createTest(testName);		
		}else if(TestBase.listener.equalsIgnoreCase("reg")) {
			eTest = report1.createTest(testName);			
		}
		
		
		eTest.info(testName +" test execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();		
		eTest.info(testName +" : got successfully executed");
		
		
		// flushing the report
				if(TestBase.listener.equalsIgnoreCase("log")) {
					report.flush();		
				}else if(TestBase.listener.equalsIgnoreCase("reg")) {
					report1.flush();			
				}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();		
		eTest.fail(testName +" : test got failed");
		
		
		/* to get the driver of this particular test class  
		 * -- it is optional since we have extends the base class which already have this driver in it. */ 
//		WebDriver driver = null;
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		
//		} catch (IllegalArgumentException e) {			
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
		
		
		/*-------screen capturing method calling---------*/		
		eTest.addScreenCaptureFromPath(screenShotCatch(testName, driver), testName);
		
		/*--the failure result log--*/
		eTest.info(result.getThrowable());
		
		
		// flushing the report
		if(TestBase.listener.equalsIgnoreCase("log")) {
			report.flush();		
		}else if(TestBase.listener.equalsIgnoreCase("reg")) {
			report1.flush();			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();		
		eTest.skip(testName +" : got skipped");
		
		// flushing the report
		if(TestBase.listener.equalsIgnoreCase("log")) {
			report.flush();		
		}else if(TestBase.listener.equalsIgnoreCase("reg")) {
			report1.flush();			
		}
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		// flushing the report
		if(TestBase.listener.equalsIgnoreCase("log")) {
			report.flush();		
		}else if(TestBase.listener.equalsIgnoreCase("reg")) {
			report1.flush();			
		}
		
		
		//auto open generated extent-report file
		if(TestBase.listener.equalsIgnoreCase("log")) {			
			File reportname = new File(System.getProperty("user.dir") +"./reports/login-test-report1.html" );
			try {
				Desktop.getDesktop().browse(reportname.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(TestBase.listener.equalsIgnoreCase("reg")) {			
			File reportname = new File(System.getProperty("user.dir") +"./reports/regression-test-report1.html" );
			try {
				Desktop.getDesktop().browse(reportname.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

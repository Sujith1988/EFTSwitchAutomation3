package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.TestBase;

public class Common extends TestBase {

	/*---SREENSHOT FOR THE LISTENER ->screenShotCapturing---*/
	// screen capture for the listener class -> screenShotCapturing
	public String screenShotCapturing(String key) throws IOException {
		Date currentDate = new Date();
		String screenShotFileName = currentDate.toString().replace(" ", ".").replace(":", ".");
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("./screenshot/" + key + screenShotFileName + ".png"));
		String scrnshotpath = key + screenShotFileName + ".png";
		return scrnshotpath;
	}
	/*----------------------------------------------------------*/

	
	
	
	/*---SREENSHOT & EXTENT-REPORT FOR THE LISTENER ->ExtentReportScreenshotCombo---*/

	// screen capture
	public String screenShotCatch(String testName, WebDriver driver) {
		Date currentDate = new Date();
		String screenShotFileName = currentDate.toString().replace(" ", ".").replace(":", ".");
		File sourceScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				System.getProperty("user.dir") + "./screenshots/" + testName + screenShotFileName + ".png");
		try {
			FileUtils.copyFile(sourceScreenshotFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();
	}

	
	/*------------------------------------------*/
	public static ExtentSparkReporter spark;
	public static ExtentSparkReporter regression;
	public static ExtentReports extent;

	// Extent Report Reference Creation for LoginTest
	public static ExtentReports getExtentReport() {

		spark = new ExtentSparkReporter("./reports/login-test-report1.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Login Test Report");
		spark.config().setReportName("All Tests in Login class");

		return extent;
	}

	// Extent Report Reference Creation for RegressionTest
	public static ExtentReports getExtentReport1() {

		regression = new ExtentSparkReporter("./reports/regression-test-report1.html");
		extent = new ExtentReports();
		extent.attachReporter(regression);

		regression.config().setTheme(Theme.DARK);
		regression.config().setDocumentTitle("Regression Test Report");
		regression.config().setReportName("All Tests in Regression suite");

		return extent;
	}

}

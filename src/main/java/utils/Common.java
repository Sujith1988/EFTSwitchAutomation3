package utils;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class Common extends TestBase{
	
	public String screenShotCapturing(String key) throws IOException {		
		Date currentDate = new Date();
		String screenShotFileName = currentDate.toString().replace(" ",".").replace(":", ".");
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("./screenshot/" +key +screenShotFileName +".png"));
		String scrnshotpath = key +screenShotFileName +".png";
			return  scrnshotpath;			
	}
}


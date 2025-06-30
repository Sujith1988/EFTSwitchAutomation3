package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class SortingRowOfTable extends TestBase {
	
	public SortingRowOfTable() throws IOException {
		 LocatorReader loc =new LocatorReader();
	   }

//-------------------common-------------------------
public static String getLocator(String loctr) {
	  return LocatorReader.props.getProperty(loctr);
}
public WebElement getElement(String loctr) {
	 return driver.findElement(By.xpath(getLocator(loctr)));
}
//--------------------------------------------------------
	


	public static void editDeleteTableRowElements(String key, String tr, String td, String tdbtn) {						
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		// Target value to match
//          String targetValue = getLocator(key);
		String targetValue  = key;
       boolean isMatchFound = false;
//     System.out.println("what to search!!!!!!!!! : " +targetValue);
     
     // Get all rows in the tbody of the table
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getLocator(tr)))));
     List<WebElement> rows = driver.findElements(By.xpath(getLocator(tr)));//tbody/tr -> similar to View User page

     // Loop through each row
     for (WebElement row : rows) {
         // Get the first column (td) of the current row
         WebElement firstColumn = row.findElement(By.xpath(getLocator(td)));  //td[1] -> similar to View User page
         String cellText = firstColumn.getText().trim();        
//         System.out.println("search result!!!!!!!  :" +cellText);
         
         // Check if it matches the target value
         if (cellText.equalsIgnoreCase(targetValue)) {
             System.out.println("Table Column search, Match found for ExelData: "+targetValue +", in the 'td-cellText' : "+cellText);
             isMatchFound = true;
             
             	wait.until(ExpectedConditions.visibilityOf(row.findElement(By.xpath(getLocator(tdbtn))))).click();
             //row.findElement(By.xpath(getLocator(tdbtn))).click(); //td[x]/button               	
             break;
         }
     }

     if (!isMatchFound) {
         System.out.println("No match found for ExcelData : " + targetValue);
     }		
	}

}

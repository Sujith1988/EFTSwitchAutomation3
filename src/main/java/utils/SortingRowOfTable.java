package utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		// Target value to match
//     String targetValue = getLocator(key);
		String targetValue = key;
     boolean isMatchFound = false;
//     System.out.println("what to search!!!!!!!!! : " +targetValue);
     
     // Get all rows in the tbody of the table
     List<WebElement> rows = driver.findElements(By.xpath(getLocator(tr)));//tbody/tr -> similar to View User page

     // Loop through each row
     for (WebElement row : rows) {
         // Get the first column (td) of the current row
         WebElement firstColumn = row.findElement(By.xpath(getLocator(td)));  //td[1] -> similar to View User page
         String cellText = firstColumn.getText().trim();        
//         System.out.println("search result!!!!!!!  :" +cellText);
         
         // Check if it matches the target value
         if (cellText.equalsIgnoreCase(targetValue)) {
             System.out.println("Match found--> ExelData= "+targetValue +", td-cellText= "+cellText);
             isMatchFound = true;
             row.findElement(By.xpath(getLocator(tdbtn))).click(); //td[x]/button             
             break;
         }
     }

     if (!isMatchFound) {
         System.out.println("No match found for: " + targetValue);
     }		
	}

}

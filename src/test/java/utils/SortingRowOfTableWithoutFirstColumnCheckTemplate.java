package utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class SortingRowOfTableWithoutFirstColumnCheckTemplate extends TestBase {

	
	public SortingRowOfTableWithoutFirstColumnCheckTemplate() throws IOException {
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
	



	
	//To delete all the rows from the BIN-table(after clicking on the CG-view button)
	
		/* key   : BIN number (not used here actually)
		 * tr    : bin_tr
		 * td    : bin_td
		 * tdbtn : bin_td_delbtn  */
		public void deleteBINs(String key, String tr, String td, String tdbtn) {						  
	     boolean isMatchFound = false;
	     // Get all rows in the tbody of the table
	     List<WebElement> rows = driver.findElements(By.xpath(getLocator(tr)));//tbody/tr -> similar to View User page
	 System.out.println(tr+rows);
	     // Loop through each row
	     for (WebElement row : rows) {
	         // Get the first column (td) of the current row
	         WebElement firstColumn = row.findElement(By.xpath(getLocator(td)));  /* .//td[1] -> similar to View User page*/
	         String cellText = firstColumn.getText().trim();
	         System.out.println("!!!!!!!!!!!!!!!  :" +cellText);

	         // Check if it is not empty, and click on delete btn
	         if (!cellText.equals("")) {
	             System.out.println(": " + cellText);
	             isMatchFound = true;
	             row.findElement(By.xpath(getLocator(tdbtn))).click(); //td[7]/button             
	             popupWindwHandlr.alertHandler();                      
	             break;
	         }
	        
	     }
	     if (!isMatchFound)  System.out.println("BIN table rows are empty:");            		
		}
		
}

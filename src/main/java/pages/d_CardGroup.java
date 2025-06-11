package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;

public class d_CardGroup extends TestBase {

	public d_CardGroup() throws IOException {
		 LocatorReader loc =new LocatorReader();
	   }
	  
	  //-------------------common-------------------------
	  public String getLocator(String loctr) {
		  return LocatorReader.props.getProperty(loctr);
	  }
	  public WebElement getElement(String loctr) {
		 return driver.findElement(By.xpath(getLocator(loctr)));
	  }
	//--------------------------------------------------------
	  

//-----------Add Card Group page actions---------------
	public String pageHeader_addsysConf() {
		return getElement("pag_header_add_usr").getText();
	}	
	public String actPagHeader_addsysConf() {
		return getLocator("actual_pag_header_add_usr");
	}
	
	
	/*  key : provide the name for the Card Group  */	
	public void routingCatagory(String key) {
		getElement("card_group").sendKeys("key");
	}
	
	
	public void clickonroutingCatagorySavebtn() {
		getElement("card_group_sav_btn").click();
	}
	

	
	//-----------View Routing Catagory page actions---------------
	
	/* TO Filter out one particular card group, then click on the view button,
	   then the view-BIN table opens, so that we can delete all the available 
	   BINs on that card group */
	
	
	/* key   : MasterCard (or MasterCardCR, Naiguata, CMSCardGroup, Visa
	 * tr    : cardGrp_tr
	 * td    : cardGrp_td
	 * tdbtn : cardGrp_td_Viewbtn, cardGrp_td_Editbtn  */
	public void editCG(String key, String tr, String td, String tdbtn) {						
		// Target value to match
     String targetValue = key;
     boolean isMatchFound = false;

     // Get all rows in the tbody of the table
     List<WebElement> rows = driver.findElements(By.xpath(getLocator(tr)));//tbody/tr -> similar to View User page
 
     // Loop through each row
     for (WebElement row : rows) {
         // Get the first column (td) of the current row
         WebElement firstColumn = row.findElement(By.xpath(getLocator(td)));  //td[1] -> similar to View User page
         String cellText = firstColumn.getText().trim();

         // Check if it matches the target value
         if (cellText.equalsIgnoreCase(targetValue)) {
             System.out.println("Match found: " + cellText);
             isMatchFound = true;
             row.findElement(By.xpath(getLocator(tdbtn))).click(); //td[2]/button             
             break;
         }
     }

     if (!isMatchFound) {
         System.out.println("No match found for: " + targetValue);
     }		
	}
	
	
	
	

	//To delete all the rows from the BIN-table(after clicking on the view button)
	
	/* key   : BIN number (not required actually)
	 * tr    : bin_tr
	 * td    : bin_td
	 * tdbtn : bin_td_delbtn  */
	public void deleteBIN(String key, String tr, String td, String tdbtn) {						
		// Target value to match
     String targetValue = key;
     boolean isMatchFound = false;

     // Get all rows in the tbody of the table
     List<WebElement> rows = driver.findElements(By.xpath(getLocator(tr)));//tbody/tr -> similar to View User page
 
     // Loop through each row
     for (WebElement row : rows) {
         // Get the first column (td) of the current row
         WebElement firstColumn = row.findElement(By.xpath(getLocator(td)));  //td[1] -> similar to View User page
         String cellText = firstColumn.getText().trim();
         System.out.println("!!!!!!!!!!!!!!!  :" +cellText);

         // Check if it is not empty, and click on delete btn
         if (cellText!="") {
             System.out.println(": " + cellText);
             isMatchFound = true;
             row.findElement(By.xpath(getLocator(tdbtn))).click(); //td[7]/button             
             break;
         }
        
     }
     if (!isMatchFound)  System.out.println("BIN table rows are empty:");            		
	}
	
	
	
	
	
	/* Finally delete the card group from the first table -> use the same function
	   - editCG  with the variable tdbtn = cardGrp_td_Editbtn to click on the 
	   Card Group Edit button */
	// delete the CG after clicking on the Edit button
		public void clickonCardGroupDeletebtn() {
			getElement("cardGrp_delbtn").click();  //button[@value="Delete"]
		}
	
	
}

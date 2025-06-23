package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.A_Home;
import pages.E_CardGroup;
import utils.SqlConnectUtil;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class E_CardGroupTest extends TestBase {
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    
    @Test(groups = "reggrsn1", priority = 2)
    public static void addCG() throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				A_Home h = new A_Home();
		// POM -- Card Group page (class object-instance created and constructor invoked)
				E_CardGroup cg = new E_CardGroup();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	        		        
		
		     // Add CG:-  add new CG for testing
				h.clickHome();
				h.clickonCardGrpAndBin();	    Thread.sleep(log.slp_2);			
				h.clickonAddCardGrp();     Thread.sleep(log.slp_2);	
				String pagHeadr1 = cg.pageHeader_addCG();
				String actualPageHeader1 = cg.actPagHeader_addCG();
				if (pagHeadr1.equals(actualPageHeader1)) {			
					cg.addNewCG("sample_cg");			
					cg.saveNewCG();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
	
					
					String pagHeadr2 = cg.pageHeader_addCG();
					System.out.println("pageHeader : " +pagHeadr2);
					String actualPageHeader2 = "Configure Card Group";   //cg.actPagHeader_addCG();
					if(pagHeadr2.equals(actualPageHeader2)) {
						cg.continuetoViewCGpage();	
						Thread.sleep(2000);
					}					
					/*Deleting option is in the view/Edit CG page actually, but the function is just -
					 calling from here for ease of understanding*/
					
					//click on 'Edit CG' on the selected 'CG'
					cg.editCGbtn("TestCG1","tr11","td11","cardGrp_td_Editbtn");
					Thread.sleep(2000);	
						
					//delete the CG
					cg.delEmptyCG();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
				}
	}	  
    
    
    
    
    
    
    /*--------Deleting the fields from the CG. from View-CG. Page and adding new fields using Add-CG page--------*/
	@Test(groups = {"reggrsn1"}, dataProvider = "CGData", dataProviderClass = ExcelDataProvider.class, priority = 3)
	public static void editCG(String paramName1, String tr1, String td1, String tdViewbtnCG, String paramName2, String tr2, String td2, String tdEditbtnBIN, String tdDeletebtnBIN, String tdEditbtnCG, String RC) throws IOException, InterruptedException {					
		
		// POM -- home page (class object-instance created and constructor invoked)
				A_Home h = new A_Home();
		// POM -- Card Group page (class object-instance created and constructor invoked)
				E_CardGroup cg = new E_CardGroup();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	        		        		
		     																						       
		// View/Edit CG:-  view/edit CG conf. for testing			
		h.clickHome();
		h.clickonCardGrpAndBin();	    Thread.sleep(log.slp_2);			
		h.clickonViewCardGrpAndBin();     Thread.sleep(log.slp_2);	
		String pagHeadr = cg.pageHeader_viewCG();
		String actualPageHeader = cg.actPagHeader_viewCG();
		if (pagHeadr.equals(actualPageHeader)) {
			
			
			//click on table1-'view BIN' on the selected 'CG' and scroll down upto bin-button
			driver.manage().window().maximize();
			Thread.sleep(log.slp_2);
			
			cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);
			Thread.sleep(log.slp_2);
			
			cg.scrollToBinBtn("addBinbtn");    //cg.scrollToBottom(driver);
			Thread.sleep(log.slp_2);	
			
			//add a BIN using the 'Bin' button and add the BIN-configurations
			cg.binConfFun(paramName2,"bin_descr","pan_len","bin_len",RC);   
			Thread.sleep(2000);
			cg.clickonRCSelctr();    
			Thread.sleep(2000);
			cg.RCoptions(RC);
			Thread.sleep(2000);
			cg.scrollbotom();
			Thread.sleep(2000);
			cg.binConfSav();
			Thread.sleep(2000);
			popupWindwHandlr.alertHandler();
			Thread.sleep(2000);
			
			//click on table1-'view BIN' on the selected 'CG' and scroll down to the element
			cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);
			Thread.sleep(log.slp_2);	
			cg.scrollToBinBtn("addBinbtn");      // cg.scrollToBottom1(driver);
			Thread.sleep(log.slp_2);
			
			//click on the table2-'Edit BIN' button on the selected 'CG' and update
			cg.editBINbtn(paramName2,tr2,td2,tdEditbtnBIN);
			Thread.sleep(2000);
			cg.scrollbotom();
			Thread.sleep(2000);
			cg.updateBin();
			Thread.sleep(2000);
			popupWindwHandlr.alertHandler();
			Thread.sleep(2000);
			
			//click on table1-'view BIN' on the selected 'CG' and scroll down to element
			cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);
			Thread.sleep(log.slp_2);	
			cg.scrollToBinBtn("addBinbtn");      // cg.scrollToBottom1(driver);
			Thread.sleep(log.slp_2);
			
			//click on the table2-'Delete BIN' button on the selected 'CG'
			cg.editBINbtn(paramName2,tr2,td2,tdDeletebtnBIN);
			Thread.sleep(2000);			
			popupWindwHandlr.alertHandler();
			Thread.sleep(2000);

			
		
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
		
		
		
		
		
		// Add CG:-  add new CG for testing
//		h.clickHome();
//		h.clickonCardGrpAndBin();	    Thread.sleep(log.slp_2);			
//		h.clickonAddCardGrp();     Thread.sleep(log.slp_2);	
//		String pagHeadr1 = cg.pageHeader_addCG();
//		String actualPageHeader1 = cg.actPagHeader_addCG();
//		if (pagHeadr1.equals(actualPageHeader1)) {			
//			cg.addNewCG("sample_cg");			
//			cg.saveNewCG();
//			Thread.sleep(2000);
//			popupWindwHandlr.alertHandler();
//			Thread.sleep(2000);
//
//			
//			String pagHeadr2 = cg.pageHeader_addCG();
//			System.out.println("pageHeader : " +pagHeadr2);
//			String actualPageHeader2 = "Configure Card Group";   //cg.actPagHeader_addCG();
//			if(pagHeadr2.equals(actualPageHeader2)) {
//				cg.continuetoViewCGpage();	
//				Thread.sleep(2000);
//			}					
//			/*Deleting option is in the view/Edit CG page actually, but the function is just -
//			 calling from here for ease of understanding*/
//			
//			//click on 'Edit CG' on the selected 'CG'
//			cg.editCGbtn("sample_cg",tr1,td1,"cardGrp_td_Editbtn");
//			Thread.sleep(2000);	
//				
//			//delete the CG
//			cg.delEmptyCG();
//			Thread.sleep(2000);
//			popupWindwHandlr.alertHandler();
//			Thread.sleep(2000);
//		}
				
				
    }
	
	
	
	
	
	
	
	//Complete BIN settings Removal from the database tables
	@Test(groups = "conf", priority = 4)
	public static void truncateDBTablesOfBins() throws SQLException {
		//utils	-> SqlConnectUtil -> to remove all the correct bin values from all the CGs	
		SqlConnectUtil.binTableevacuate();
	}
	
	
	
	
	
	
	
	//Complete BIN setting for the CGs -  'CMS', 'MDS', 'MasterCardCR', 'Naiguata', 'Visa'
	@Test(groups = "conf", priority = 5, dataProvider = "BINData", dataProviderClass = ExcelDataProvider.class)
	public static void binConfigurationCMSCardGroup(String paramName1, String tr1, String td1, String tdViewbtnCG, String bin, String bin_descr, String pan_len, String bin_len, String RC) throws IOException, InterruptedException {
		
		// POM -- home page (class object-instance created and constructor invoked)
		A_Home h = new A_Home();
		// POM -- Card Group page (class object-instance created and constructor invoked)
		E_CardGroup cg = new E_CardGroup();
		// POM -- Login page (class object-instance created and constructor invoked)
        A_Login log = new A_Login();
        
        
        
        
     // Navigate to view CG page		
     		h.clickHome();
     		h.clickonCardGrpAndBin();	    Thread.sleep(log.slp_2);			
     		h.clickonViewCardGrpAndBin();     Thread.sleep(log.slp_2);	
     		String pagHeadr = cg.pageHeader_viewCG();
     		String actualPageHeader = cg.actPagHeader_viewCG();
     		if (pagHeadr.equals(actualPageHeader)) {
     			
     			
     			//click on table1-'view BIN' on the selected 'CG' and scroll down upto bin-button
     			cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);
     			Thread.sleep(log.slp_2);	
     			cg.scrollToBinBtn("addBinbtn");         //cg.scrollToBottom(driver);
     			Thread.sleep(log.slp_2);	
     			
     			//add a BIN using the 'Bin' button and add the BIN-configurations
     			cg.binConfFun1(bin, bin_descr, pan_len, bin_len, RC);   Thread.sleep(2000);			
//     			cg.clickonRCSelctr();    Thread.sleep(2000);	
//     			cg.RCoptions(RC);        Thread.sleep(2000);	
//     			cg.binConfSav();
     			Thread.sleep(2000);
     			popupWindwHandlr.alertHandler();
     			Thread.sleep(2000);
        
        
     		}                                                                       
                
		
	}

	
}

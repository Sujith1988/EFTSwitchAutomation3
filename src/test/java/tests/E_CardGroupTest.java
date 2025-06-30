package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.D_RoutingCatagory;
import pages.A_Home;
import pages.E_CardGroup;
import utils.SqlConnectUtil;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class E_CardGroupTest extends TestBase {
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static E_CardGroup cg;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	E_CardGroup cg = new E_CardGroup();
    	A_Login login = new A_Login();
    	
    	E_CardGroupTest.home = home;
    	E_CardGroupTest.cg = cg;
    	E_CardGroupTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/
    
    
    
    
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    
    
    // Regression test for adding and update / delete CG
    @Test(groups = "reggrsn1", priority = 2, enabled = true)
    public static void addCG() throws IOException, InterruptedException {									               	        		        		
		     // Add CG:-  add new CG for testing
    	     addCGCommon("sample_cg");
    	         	     
    	     // Update CG
    	     viewCGCommon(1, 0, "TestCG1", "tr11", "td11", "cardGrp_td_Editbtn");    	     
    	     // Delete CG
    	     viewCGCommon(0, 1, "TestCG1", "tr11", "td11", "cardGrp_td_Editbtn");
	}	  
    
                         
    
    
  /*--------Adding new bin-fields on a CG and updating / deleting the same bin-fields from the same CG. (REGRESSION TESTING)--------*/
	@Test(groups = {"reggrsn1"}, priority = 3, dataProvider = "CGBinData", dataProviderClass = ExcelDataProvider.class, enabled = true)
	public static void editBin(String paramName1, String tr1, String td1, String tdViewbtnCG, String paramName2, String tr2, String td2, String tdEditbtnBIN, String tdDeletebtnBIN, String bin, String bin_descr, String pan_len, String bin_len, String RC) throws IOException, InterruptedException {					
		
		//add bin
		addBinCommon(paramName1, tr1, td1, tdViewbtnCG, bin, bin_descr, pan_len, bin_len, RC);
		
		//update bin
		viewCG1Common(1, 0, paramName1, tr1, td1, tdViewbtnCG, paramName2, tr2, td2, tdEditbtnBIN, tdDeletebtnBIN);
    
		//delete bin
		viewCG1Common(0, 1, paramName1, tr1, td1, tdViewbtnCG, paramName2, tr2, td2, tdEditbtnBIN, tdDeletebtnBIN);
		    
	}

					
	
	
	
	//Complete BIN settings Removal from the database tables
	@Test(groups = "conf", priority = 4, enabled = true)
	public static void truncateDBTablesOfBins() throws SQLException {
		//utils	-> SqlConnectUtil -> to remove all the correct bin values from all the CGs	
		SqlConnectUtil.binTableevacuate();
	}
	
					
	
	//Complete BIN setting adding for the CGs: ('CMS', 'MDS', 'MasterCardCR', 'Naiguata', 'Visa')
	@Test(groups = "conf", priority = 5, dataProvider = "BINData", dataProviderClass = ExcelDataProvider.class, enabled = true)
	public static void binConfigurationCMSCardGroup(String paramName1, String tr1, String td1, String tdViewbtnCG, String bin, String bin_descr, String pan_len, String bin_len, String RC) throws IOException, InterruptedException {		
		addBinCommon(paramName1, tr1, td1, tdViewbtnCG, bin, bin_descr, pan_len, bin_len, RC);                                                                                    		
	}

	
	
	
	
	
	
	
	/*-----------------General Functions--------------------*/
	
	
	// Add CG:-  add new CG
	public static void addCGCommon(String CGname) throws IOException, InterruptedException {							
        pomCall();		        	        		             
		home.clickHome();
		home.clickonCardGrpAndBin();	    			
		home.clickonAddCardGrp();     
		String pagHeadr = cg.pageHeader_addCG();
		String actualPageHeader = cg.actPagHeader_addCG();
		if (pagHeadr.equals(actualPageHeader)) {	
			System.out.println("Entered the Page : " +pagHeadr);
			
			cg.addNewCG(CGname);
			cg.saveNewCG();
			popupWindwHandlr.popupHandler(CGname, "Card Group added : ", "error in adding Card Group : ");
				
			String pagHeadr2 = cg.pageHeader_addCG();
			if(pagHeadr2.equals(actualPageHeader)) {
				cg.continuetoViewCGpage();				
			}
		}
	
	}	
	
		
	
	
	    // View CG:-  Update and Delete CG
		public static void viewCGCommon(int upd, int del, String param, String tr, String td, String tdName) throws IOException, InterruptedException {							
	        pomCall();		        	        		        	     
			home.clickHome();
			home.clickonCardGrpAndBin();		
			home.clickonViewCardGrpAndBin();     
			String pagHeadr = cg.pageHeader_viewCG();
			String actualPageHeader = cg.actPagHeader_viewCG();	
			if (pagHeadr.equals(actualPageHeader)) {
				System.out.println("Entered the Page : " +pagHeadr);
				
				//click on 'Edit CG' on the selected 'CG'
				cg.editCGbtn(param, tr, td, tdName); 
				
				if(upd==1) {
					//update the CG
					cg.updateCG();
					popupWindwHandlr.popupHandler(param, "Card Group updated : ", "error in updating Card Group : ");
				}else if(del==1) {
					//delete the CG
					cg.delEmptyCG();
					popupWindwHandlr.popupHandler(param, "Card Group deleted : ", "error in deleting Card Group : ");
				}
		
				
			}
		}
	
		
				
				
		
		public static void addBinCommon(String paramName1, String tr1, String td1, String tdViewbtnCG, String bin, String bin_descr, String pan_len, String bin_len, String RC) throws IOException, InterruptedException {		
			pomCall();                              
			// Navigate to view CG page		
     		home.clickHome();
     		home.clickonCardGrpAndBin();	    		
     		home.clickonViewCardGrpAndBin();     	
     		String pagHeadr = cg.pageHeader_viewCG();
     		String actualPageHeader = cg.actPagHeader_viewCG();
     		if (pagHeadr.equals(actualPageHeader)) {
     			System.out.println("Entered the Page : " +pagHeadr);
     			     			
     			//click on table1-'view BIN' on the selected 'CG' and scroll down upto bin-button
     			cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);	
     			cg.scrollToBinBtn("addBinbtn");         
     			
     			//add a BIN using the binConfFun
     			cg.binConfFun1(bin, bin_descr, pan_len, bin_len, RC);   		     			
     			popupWindwHandlr.popupHandler(bin, "BIN added : ", "error in adding BIN : ");      
     		}                                                                                      		
	}
		
						
		
		
		
		// View CG:-  bin update / delete from the filtered CG
		public static void viewCG1Common(int upd, int del, String paramName1, String tr1, String td1, String tdViewbtnCG, String paramName2, String tr2, String td2, String tdEditbtnBIN, String tdDeletebtnBIN) throws IOException, InterruptedException {							
			pomCall();		        	        		        	     
			home.clickHome();
			home.clickonCardGrpAndBin();			
			home.clickonViewCardGrpAndBin();     
			String pagHeadr = cg.pageHeader_viewCG();
			String actualPageHeader = cg.actPagHeader_viewCG();	
			if (pagHeadr.equals(actualPageHeader)) {
				System.out.println("Entered the Page : " +pagHeadr);
						
				driver.manage().window().maximize();					  
						
					//click on table1-'view BIN' on the selected 'CG'
					cg.editCGbtn(paramName1,tr1,td1,tdViewbtnCG);							
					cg.scrollToBinBtn("addBinbtn");      
						
					if(upd == 1) {
						//click on the table2-'Edit BIN' button and update
						cg.editBINbtn(paramName2,tr2,td2,tdEditbtnBIN);				
						  cg.scrollbotom();

							//update
							cg.updateBin();
							popupWindwHandlr.popupHandler(paramName2, "BIN updated : ", "error in updating BIN : ");

					}
					else if(del == 1) {
						//click on the table2-'Delete BIN' button
						cg.editBINbtn(paramName2,tr2,td2,tdDeletebtnBIN);
						popupWindwHandlr.popupHandler(paramName2, "BIN deleted : ", "error in deleting BIN : ");
					}	
																																						
			}
			else System.out.println("error in loading View Sys Conf page");				
						
		}
				
			
		
}
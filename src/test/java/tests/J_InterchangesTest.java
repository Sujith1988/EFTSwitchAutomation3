package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import pages.A_Login;
import pages.A_Home;
import pages.J_Interchanges;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class J_InterchangesTest extends TestBase{

	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static J_Interchanges in;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	J_Interchanges in = new J_Interchanges();
    	A_Login login = new A_Login();
    	
    	J_InterchangesTest.home = home;
    	J_InterchangesTest.in = in;
    	J_InterchangesTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/  
    
    
    
    
    
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	extent.attachReporter(spark);
    	ExtentTest test1 = extent.createTest("adminlogin");
    	
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login, test1);
    }
    
    
    
    
    // Add Interchange and update/Delete Interchanges for regrshn testing
    @Test(priority = 2, groups = "reggrsn1")
    public static void addIntrchng() throws IOException, InterruptedException {					
		   	
    	// Add Interchange:
    	addInterchCommon("option_intrchng_interface_Dashboard", "input_intrchng_name_value_MDS_ATM_Test", "option_intrchng_nodType_Omega", "option_intrchnge_omeganode_MDS", "input_interchange_sapName_value_mds_Test", "option_intrchng_conct_typ_omega_client", "input_interchange_sapIp_omega_value", "input_interchange_sapPort_omega_value_Test");
    	  	    	 
    	// Eidit/View Interchange:
    		//update:
    	viewInterchCommon(1, 0, "DashBrdInterchange", "intrchg_tr", "intrchg_td", "intrchg_tdbtn");
    		//Delete:
    	viewInterchCommon(0,1, "DashBrdInterchange", "intrchg_tr", "intrchg_td", "intrchg_tdbtn");							
	}
				
																      
    
    
    
    
  //Configuration adding for the Interchanges
    @Test(priority = 3, groups = {"conf", "reggrsn1"}, dataProvider = "IntrchngData", dataProviderClass = ArrayDataProvider.class)
    public static void addIntrchngConf(String option_intrchng_interface_MDS, String input_intrchng_name_value_MDS_ATM_Test, String option_intrchng_nodType_Omega, String option_intrchnge_omeganode_MDS, String input_interchange_sapName_value_mds_Test, String option_intrchng_conct_typ_omega_client, String input_interchange_sapIp_omega_value, String input_interchange_sapPort_omega_value_Test) throws IOException, InterruptedException {
    // Add Interchange:
	addInterchCommon(option_intrchng_interface_MDS, input_intrchng_name_value_MDS_ATM_Test, option_intrchng_nodType_Omega, option_intrchnge_omeganode_MDS, input_interchange_sapName_value_mds_Test, option_intrchng_conct_typ_omega_client, input_interchange_sapIp_omega_value, input_interchange_sapPort_omega_value_Test);	  	    												       				   
    }
    
    
         				   				
		
		
		
		                          
    
    
  /*------------------General Methods-----------------------------*/  
 
    // Add Interchange:-  add new Interchanges
    public static void addInterchCommon(String intrfce, String intrchng, String nodTyp, String selctAlpha, String sapName, String sapConTyp, String sapIP, String sapPort) throws IOException, InterruptedException {								    	
		pomCall();
             
        home.clickHome();
        home.scrollToanElementInHome("intrchng_nav");
		driver.manage().window().maximize();
		home.clickInterchange();
		home.clickaddInterchange();
		String pagHeadr = in.pageHeader_addInterchange();
		String actualPageHeader = in.actPagHeader_addInterchange();
		if (pagHeadr.equals(actualPageHeader)) {	
			System.out.println("Entered the Page : " +pagHeadr);
													
			
			//select the interface for the interchange
			in.selectFieldInterchange("select_intrchng_interface");					
			in.selectFieldOptionInterchange(intrfce); 
			
			//enter the interchange name
			String intrchName = in.enterinputVlaueInterchange("input_intrchng_name", intrchng);  	
			
			//enter the user parmeter
			in.enterinputVlaueInterchange("input_intrchng_usrParm", "input_intrchng_usrParm_value");
			
			//select node type
			in.selectFieldInterchange("select_intrchng_nodType");				
			in.selectFieldOptionInterchange(nodTyp); 
			
			if(nodTyp.equalsIgnoreCase("option_intrchng_nodType_Alpha")) {
				//select alpha node
				in.selectFieldInterchange("select_intrchng_alphanode");				
				in.selectFieldOptionInterchange(selctAlpha);  
				
				//enter sap name
				in.enterinputVlaueInterchange("input_interchange_sapName_alpha", sapName); 
				
				
					//scroll upto element
					in.scrollToanElementMehod("select_intrchng_tls_sts");
					Thread.sleep(login.slp_2);
				
				
				//select sap connection type
				in.selectFieldInterchange("select_intrchng_conct_typ_alpha");					
				in.selectFieldOptionInterchange(sapConTyp); 
				
																		
				//select sap protocol
				in.selectFieldInterchange("select_intrchng_sap_protocol_alpha");					
				in.selectFieldOptionInterchange("option_intrchng_sap_protocol_alpha_tcp");
				
				//enter sap ip
				in.enterinputVlaueInterchange("input_interchange_sapIp_alpha", sapIP); 
				
				//enter sap port
				in.enterinputVlaueInterchange("input_interchange_sapPort_alpha", sapPort); 																	
			}									
			if(nodTyp.equalsIgnoreCase("option_intrchng_nodType_Omega")) {
				//select omega node
				in.selectFieldInterchange("select_intrchng_omeganode");					
				in.selectFieldOptionInterchange(selctAlpha);  
				
				//enter sap name
				in.enterinputVlaueInterchange("input_interchange_sapName_omega", sapName); 
				
				
					//scroll upto element
					in.scrollToanElementMehod("select_intrchng_tls_sts");					
				
				
				//select sap connection type
				in.selectFieldInterchange("select_intrchng_conct_typ_omega");					
				in.selectFieldOptionInterchange(sapConTyp);
				
																		
				//select sap protocol
				in.selectFieldInterchange("select_intrchng_sap_protocol_omega");					
				in.selectFieldOptionInterchange("option_intrchng_sap_protocol_omega_tcp");
				
				//enter sap ip
				in.enterinputVlaueInterchange("input_interchange_sapIp_omega", sapIP); 
				
				//enter sap port
				in.enterinputVlaueInterchange("input_interchange_sapPort_omega", sapPort); 
			}
						
			
			
			//select tls state
			in.selectFieldInterchange("select_intrchng_tls_sts");					
			in.selectFieldOptionInterchange("option_intrchng_tls_sts_disable");
			
			
			//save the conf btn
			in.saveAddNewInterchngbtn();	
						
			popupWindwHandlr.popupHandler(intrchName, "Interchange added : ", "error in adding Ingerchange : ");												
		}
									       				   
}
		
				
				
    
    
    
				
 // Eidit/View Interchange:-  Update and delete Interchange
    public static void viewInterchCommon(int upd, int del, String param, String tr, String td, String tdbtn) throws IOException, InterruptedException {
    			pomCall();	
    	
		        home.clickHome();
		        home.scrollToanElementInHome("intrchng_nav");
				driver.manage().window().maximize();		
				home.clickInterchange();
				home.clickviewInterchange();
				String pagHeadr = in.pageHeader_viewInternchge();
				String actualPageHeader = in.actPagHeader_viewInternchge();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Entered the Page : " +pagHeadr);
							
					//Edit btn for the test interchange
					in.clickonViewIntrchangeEditbtn(param, tr, td, tdbtn);   
					
					//scroll upto element
					in.scrollToanElementMehod("update_btn_IntrchngConf");
					
					if(upd==1) {
						//update the interchange conf
						in.updateIntrchngbtn(); 
						
						popupWindwHandlr.popupHandler(param, "Interchange updated : ", "error in updating Ingerchange : ");   
					}else if(del==1) {
						//delete the interchange conf
						in.deleteIntrchngbtn();
						
						popupWindwHandlr.popupHandler(param, "Interchange deleted : ", "error in deleting Ingerchange : ");    
					}																																			
				}										
    }
    
             
    
}
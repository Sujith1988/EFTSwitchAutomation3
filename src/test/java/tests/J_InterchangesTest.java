package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import pages.A_Login;
import pages.B_Home;
import pages.J_Interchanges;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class J_InterchangesTest extends TestBase{

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    
  //Configuration adding for the Interchanges
    @Test(priority = 2, groups = "reggrsn1")
    public static void addNodeApp() throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Interchange page (class object-instance created and constructor invoked)
				J_Interchanges in = new J_Interchanges();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
	
		        
		        // Add Interchange:-  add new Interchanges for regrshn testing purpose only
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("intrchng_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				Thread.sleep(log.slp_2);
				h.clickInterchange();
				Thread.sleep(log.slp_2);
				h.clickaddInterchange();
				Thread.sleep(log.slp_2);
				String pagHeadr = in.pageHeader_addInterchange();
				String actualPageHeader = in.actPagHeader_addInterchange();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
															
					
					//select the interface for the interchange
					in.selectFieldInterchange("select_intrchng_interface");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange("option_intrchng_interface_MDS");
					Thread.sleep(log.slp_2);
					
					//enter the interchange name
					in.enterinputVlaueInterchange("input_intrchng_name", "input_intrchng_name_value_MDS_ATM_Test");
					Thread.sleep(log.slp_2);	
					
					//enter the user parmeter
					in.enterinputVlaueInterchange("input_intrchng_usrParm", "input_intrchng_usrParm_value");
					Thread.sleep(log.slp_2);	
					
					//select node type
					in.selectFieldInterchange("select_intrchng_nodType");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange("option_intrchng_nodType_Omega");
					Thread.sleep(log.slp_2);
									
														
						//select omega node
						in.selectFieldInterchange("select_intrchng_omeganode");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange("option_intrchnge_omeganode_MDS");
						Thread.sleep(log.slp_2);
						
						//enter sap name
						in.enterinputVlaueInterchange("input_interchange_sapName_omega", "input_interchange_sapName_value_mds_Test");
						Thread.sleep(log.slp_2);
						
						
							//scroll upto element
							in.scrollToanElementMehod("select_intrchng_tls_sts");
							Thread.sleep(log.slp_2);
						
						
						//select sap connection type
						in.selectFieldInterchange("select_intrchng_conct_typ_omega");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange("option_intrchng_conct_typ_omega_client");
						Thread.sleep(log.slp_2);
						
																				
						//select sap protocol
						in.selectFieldInterchange("select_intrchng_sap_protocol_omega");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange("option_intrchng_sap_protocol_omega_tcp");
						Thread.sleep(log.slp_2);
						
						//enter sap ip
						in.enterinputVlaueInterchange("input_interchange_sapIp_omega", "input_interchange_sapIp_omega_value");
						Thread.sleep(log.slp_2);
						
						//enter sap port
						in.enterinputVlaueInterchange("input_interchange_sapPort_omega", "input_interchange_sapPort_omega_value_Test");
						Thread.sleep(log.slp_2);
					
											
					
					//select tls state
					in.selectFieldInterchange("select_intrchng_tls_sts");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange("option_intrchng_tls_sts_disable");
					Thread.sleep(log.slp_2);
					
					
					//save the conf btn
					in.saveAddNewInterchngbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
											
				}
				
				
				
				
				// Eidit/View Interchange:-  Update and delete Interchange for regrshn testing purpose
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("intrchng_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);			
				h.clickInterchange();
				Thread.sleep(log.slp_2);
				h.clickviewInterchange();
				Thread.sleep(log.slp_2);
				String pagHeadr1 = in.pageHeader_viewInternchge();
				String actualPageHeader1 = in.actPagHeader_viewInternchge();
				if (pagHeadr1.equals(actualPageHeader1)) {	
					System.out.println("Testing the loop entry page header");
							
					//Edit btn for the test interchange
					in.clickonViewIntrchangeEditbtn("intrchg_param", "intrchg_tr", "intrchg_td", "intrchg_tdbtn");   
					
					//scroll upto element
					in.scrollToanElementMehod("update_btn_IntrchngConf");
					
					//update the interchange conf
					in.updateIntrchngbtn();              Thread.sleep(log.slp_2);			
					popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
					
					
					
					//Edit btn for the test interchange
					in.clickonViewIntrchangeEditbtn("intrchg_param", "intrchg_tr", "intrchg_td", "intrchg_tdbtn");   
					
					//scroll upto element
					in.scrollToanElementMehod("update_btn_IntrchngConf");
					
					//delete the interchange conf
					in.deleteIntrchngbtn();              Thread.sleep(log.slp_2);			
					popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
				}			
								
    }
    
    
    
    
    
  //Configuration adding for the Interchanges
    @Test(priority = 3, groups = "conf", dataProvider = "IntrchngData", dataProviderClass = ArrayDataProvider.class)
    public static void addNodeApp(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Interchange page (class object-instance created and constructor invoked)
				J_Interchanges in = new J_Interchanges();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
	
		        
		        // Add Interchange:-  add new Interchanges
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("intrchng_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				Thread.sleep(log.slp_2);
				h.clickInterchange();
				Thread.sleep(log.slp_2);
				h.clickaddInterchange();
				Thread.sleep(log.slp_2);
				String pagHeadr = in.pageHeader_addInterchange();
				String actualPageHeader = in.actPagHeader_addInterchange();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
															
					
					//select the interface for the interchange
					in.selectFieldInterchange("select_intrchng_interface");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange(a1); //"option_intrchng_interface_ISOAdapter"
					Thread.sleep(log.slp_2);
					
					//enter the interchange name
					in.enterinputVlaueInterchange("input_intrchng_name", a2);  //"input_intrchng_name_value_ISOAdapter"
					Thread.sleep(log.slp_2);	
					
					//enter the user parmeter
					in.enterinputVlaueInterchange("input_intrchng_usrParm", "input_intrchng_usrParm_value");
					Thread.sleep(log.slp_2);	
					
					//select node type
					in.selectFieldInterchange("select_intrchng_nodType");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange(a3); //"option_intrchng_nodType_Alpha"
					Thread.sleep(log.slp_2);
					
					if(a3.equalsIgnoreCase("option_intrchng_nodType_Alpha")) {
						//select alpha node
						in.selectFieldInterchange("select_intrchng_alphanode");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange(a4);  //"option_intrchnge_alphanode_SwitchAlpha"
						Thread.sleep(log.slp_2);
						
						//enter sap name
						in.enterinputVlaueInterchange("input_interchange_sapName_alpha", a5); //"input_interchange_sapName_value_iso"
						Thread.sleep(log.slp_2);
						
						
							//scroll upto element
							in.scrollToanElementMehod("select_intrchng_tls_sts");
							Thread.sleep(log.slp_2);
						
						
						//select sap connection type
						in.selectFieldInterchange("select_intrchng_conct_typ_alpha");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange(a6); //"option_intrchng_conct_typ_srvr"
						Thread.sleep(log.slp_2);
						
																				
						//select sap protocol
						in.selectFieldInterchange("select_intrchng_sap_protocol_alpha");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange("option_intrchng_sap_protocol_alpha_tcp");
						Thread.sleep(log.slp_2);
						
						//enter sap ip
						in.enterinputVlaueInterchange("input_interchange_sapIp_alpha", a7); //"input_interchange_sapIp_value"
						Thread.sleep(log.slp_2);
						
						//enter sap port
						in.enterinputVlaueInterchange("input_interchange_sapPort_alpha", a8); //"input_interchange_sapPort_value"
						Thread.sleep(log.slp_2);					
						
						
							
					}
					
					
					
					if(a3.equalsIgnoreCase("option_intrchng_nodType_Omega")) {
						//select omega node
						in.selectFieldInterchange("select_intrchng_omeganode");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange(a4);  //"option_intrchnge_alphanode_SwitchAlpha"
						Thread.sleep(log.slp_2);
						
						//enter sap name
						in.enterinputVlaueInterchange("input_interchange_sapName_omega", a5); //"input_interchange_sapName_value_iso"
						Thread.sleep(log.slp_2);
						
						
							//scroll upto element
							in.scrollToanElementMehod("select_intrchng_tls_sts");
							Thread.sleep(log.slp_2);
						
						
						//select sap connection type
						in.selectFieldInterchange("select_intrchng_conct_typ_omega");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange(a6); //"option_intrchng_conct_typ_srvr"
						Thread.sleep(log.slp_2);
						
																				
						//select sap protocol
						in.selectFieldInterchange("select_intrchng_sap_protocol_omega");
						Thread.sleep(log.slp_2);					
						in.selectFieldOptionInterchange("option_intrchng_sap_protocol_omega_tcp");
						Thread.sleep(log.slp_2);
						
						//enter sap ip
						in.enterinputVlaueInterchange("input_interchange_sapIp_omega", a7); //"input_interchange_sapIp_value"
						Thread.sleep(log.slp_2);
						
						//enter sap port
						in.enterinputVlaueInterchange("input_interchange_sapPort_omega", a8); //"input_interchange_sapPort_value"
						Thread.sleep(log.slp_2);
					}
					
					
					
					
					//select tls state
					in.selectFieldInterchange("select_intrchng_tls_sts");
					Thread.sleep(log.slp_2);					
					in.selectFieldOptionInterchange("option_intrchng_tls_sts_disable");
					Thread.sleep(log.slp_2);
					
					
					//save the conf btn
					in.saveAddNewInterchngbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
											
				}
											       				   
    }
}

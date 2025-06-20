package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import pages.A_Login;
import pages.B_Home;
import pages.I_NodeApp;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class I_NodeAppTest extends TestBase {

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    
    // regression test for the nodeapp configurations
    @Test(priority = 2, groups = "reggrsn1")
    public static void testingNodeApp() throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Alpha node page (class object-instance created and constructor invoked)
				I_NodeApp na = new I_NodeApp();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	        		        
		
		     // Add Node App:-  add new Node App for testing
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickAddNodeapp();
				Thread.sleep(log.slp_2);
				String pagHeadr = na.pageHeader_addnodeApp();
				String actualPageHeader = na.actPagHeader_addnodeApp();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
															
					
					//select nodeapp name for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_POSApp");
					Thread.sleep(log.slp_2);
					
				   	
					//select alpha node for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp_alphanod");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_POSAlpha");
					Thread.sleep(log.slp_2);
					
					//save the conf btn
					na.saveNewaddNodeApp();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);							
				}
					
				
		        
				
				//add node connections:- add new node connection under the selected node app
				Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickViewNodeConnections();
				Thread.sleep(log.slp_2);
				String pagHeadr1 = na.pageHeader_viewnodeConnction();
				String actualPageHeader1 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr1+" = "+actualPageHeader1);
				if (pagHeadr1.equals(actualPageHeader1)) {	
					System.out.println("Testing the loop entry page header");
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(log.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//click on the add button
					na.clickonaddNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//enter sap name
					na.enterSapNameNodeConnctn("sap_name_nodeConnctn_POSApp");
					Thread.sleep(log.slp_2);
					
					
					//select connection type
					na.selectInputNodeappAddForm("selct_nod_sap_conction_type");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_optn_conctn_typ_Srvr");
					Thread.sleep(log.slp_2);
					
					
					//select protocol
					na.selectInputNodeappAddForm("selct_nod_sap_conction_protocol");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_type_Server");
					Thread.sleep(log.slp_2);										
					
					//ip address
					na.enterSapIPNodeConnctn("sap_ip_nodConnctn_POSApp");
					Thread.sleep(log.slp_2);

					
					      //scroll up to the input 'port'
					      na.scrollToanElementMehod("sap_port_nodConnctn");

					
					
					//port
					na.enterSapPortNodeConnctn("sap_port_nodConnctn_POSApp");
					Thread.sleep(log.slp_2);
									
					
					//max no of connctn
					na.enterSapMaxNoOfNodeConnctn("sap_max_no_of_nodConnctn_POSApp");
					Thread.sleep(log.slp_2);
					
					
					
					//select tls enable/disable
					na.selectInputNodeappAddForm("selct_nod_sap_conction_tls_sts");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_tls_disable");
					Thread.sleep(log.slp_2);
					
					
					//click on save btn
					na.clickonsaveNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
				}
				
				
		        
		        
		        
		      //View/Edit Node Connections:-  Update and delete the node app connections
		        Thread.sleep(log.slp_2);
		        h.clickHome();
				Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("Nodeapp_nav");		        
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickViewNodeConnections();
				Thread.sleep(log.slp_2);
				String pagHeadr2 = na.pageHeader_viewnodeConnction();
				String actualPageHeader2 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr2+" = "+actualPageHeader2);
				if (pagHeadr2.equals(actualPageHeader2)) {	
					System.out.println("Testing the loop entry page header");
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(log.slp_2);					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//edit node app connction conf btn click
					na.eidtNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//update btn click 
					na.updateNodeAppbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);	
					
					
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(log.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//edit node app connction conf btn click
					na.eidtNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//delete btn click
					na.deleteNodeAppbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
				}	
		        
		        
		        
		        
		        
		        
		        
				
				 // View/Edit Node App:-  Update and delete the node app
		        Thread.sleep(log.slp_2);
		        h.clickHome();
				Thread.sleep(log.slp_2);
				h.scrollToanElementInHome("Nodeapp_nav");		        
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickViewEditNodeapp();
				Thread.sleep(log.slp_2);
				String pagHeadr3 = na.pageHeader_viewnodeApp();
				String actualPageHeader3 = na.actPagHeader_viewnodeApp();
				System.out.println(pagHeadr3+" = "+actualPageHeader3);
				if (pagHeadr3.equals(actualPageHeader3)) {	
					System.out.println("Testing the loop entry page header");
					
					//edit node app conf btn click
					na.eidtNodeAppbtn();
					Thread.sleep(log.slp_2);
					
					//update btn click 
					na.updateNodeAppbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);	
					
					//edit node app conf btn click
					na.eidtNodeAppbtn();
					Thread.sleep(log.slp_2);
					
					//delete btn click
					na.deleteNodeAppbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
				}		        	      	        		        	        
		        
				
	 }
    
    
    
    
    
    
	
    //Configuration adding for the nodapps
    @Test(priority = 3, groups = "conf", dataProvider = "NodeAppData", dataProviderClass = ArrayDataProvider.class)
    public static void addNodeApp(String nodApp_name_optn, String nodApp_alpha_optn) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Alpha node page (class object-instance created and constructor invoked)
				I_NodeApp na = new I_NodeApp();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
	
		        
		        // Add Node App:-  add new Node App for testing
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickAddNodeapp();
				Thread.sleep(log.slp_2);
				String pagHeadr = na.pageHeader_addnodeApp();
				String actualPageHeader = na.actPagHeader_addnodeApp();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
															
					
					//select nodeapp name for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm(nodApp_name_optn); //nodApp_form_input_option_POSApp
					Thread.sleep(log.slp_2);
					
				   	
					//select alpha node for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp_alphanod");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm(nodApp_alpha_optn);  //nodApp_form_input_option_POSAlpha
					Thread.sleep(log.slp_2);
					
					//save the conf btn
					na.saveNewaddNodeApp();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);							
				}
											       				   
    }
    
    
    
    
    //cofigurations adding for the nodeapp connections
    @Test(priority = 4, groups = "conf", dataProvider = "NodeAppConctnData", dataProviderClass = ArrayDataProvider.class)
    public static void addNodeAppConnections(String nodCon_optn, String sap_name_nodCon, String sap_ip_nodCon, String sap_port_nodCon, String mx_no_nodCon) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Alpha node page (class object-instance created and constructor invoked)
				I_NodeApp na = new I_NodeApp();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        
		        
		        
		      //add node connections:- add new node connection under the selected node app
				Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);
		        h.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(log.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(log.slp_2);
				h.clickNodeapp();
				Thread.sleep(log.slp_2);
				h.clickViewNodeConnections();
				Thread.sleep(log.slp_2);
				String pagHeadr1 = na.pageHeader_viewnodeConnction();
				String actualPageHeader1 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr1+" = "+actualPageHeader1);
				if (pagHeadr1.equals(actualPageHeader1)) {	
					System.out.println("Testing the loop entry page header");
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm(nodCon_optn);  //nodApp_form_input_option_conectn_POSApp
					Thread.sleep(log.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//click on the add button
					na.clickonaddNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					
					//enter sap name
					na.enterSapNameNodeConnctn(sap_name_nodCon); //sap_name_nodeConnctn_POSApp
					Thread.sleep(log.slp_2);
					
					
					//select connection type
					na.selectInputNodeappAddForm("selct_nod_sap_conction_type");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_optn_conctn_typ_Srvr");
					Thread.sleep(log.slp_2);
					
					
					//select protocol
					na.selectInputNodeappAddForm("selct_nod_sap_conction_protocol");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_type_Server");
					Thread.sleep(log.slp_2);										
					
					//ip address
					na.enterSapIPNodeConnctn(sap_ip_nodCon); //sap_ip_nodConnctn_POSApp
					Thread.sleep(log.slp_2);

					
					      //scroll up to the input 'port'
					      na.scrollToanElementMehod("sap_port_nodConnctn");

					
					
					//port
					na.enterSapPortNodeConnctn(sap_port_nodCon);  //sap_port_nodConnctn_POSApp
					Thread.sleep(log.slp_2);
									
					
					//max no of connctn
					na.enterSapMaxNoOfNodeConnctn(mx_no_nodCon); //sap_max_no_of_nodConnctn_POSApp
					Thread.sleep(log.slp_2);
					
					
					//select tls enable/disable
					na.selectInputNodeappAddForm("selct_nod_sap_conction_tls_sts");
					Thread.sleep(log.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_tls_disable");
					Thread.sleep(log.slp_2);
					
					
					//click on save btn
					na.clickonsaveNodeConnctnbtn();
					Thread.sleep(log.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
				}
		        
    }
 
    
}

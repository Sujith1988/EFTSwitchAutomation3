package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import pages.A_Login;
import pages.A_Home;
import pages.I_NodeApp;
import utils.SqlConnectUtil;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class I_NodeAppTest extends TestBase {
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static I_NodeApp na;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	I_NodeApp na = new I_NodeApp();
    	A_Login login = new A_Login();
    	
    	I_NodeAppTest.home = home;
    	I_NodeAppTest.na = na;
    	I_NodeAppTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/ 

    
    
    
    
    
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    

    
    // regression test for the nodeapp configurations
    @Test(priority = 2, groups = "reggrsn1", enabled = true)
    public static void testingNodeApp() throws IOException, InterruptedException, SQLException {					
		
    	//clean Node App Tables from the database
    	SqlConnectUtil.nodeAppTableevacuate();
    	
    			pomCall();        	        		        
    			
		     // Add Node App:-  add new Node App for testing
		        Thread.sleep(login.slp_2);
		        home.clickHome();
		        Thread.sleep(login.slp_2);
		        home.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(login.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(login.slp_2);
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickAddNodeapp();
				Thread.sleep(login.slp_2);
				String pagHeadr = na.pageHeader_addnodeApp();
				String actualPageHeader = na.actPagHeader_addnodeApp();
				if (pagHeadr.equals(actualPageHeader)) {						
					System.out.println("Entered the Page : " +pagHeadr);										
					
					//select nodeapp name for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_POSApp");
					Thread.sleep(login.slp_2);
					
				   	
					//select alpha node for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp_alphanod");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_POSAlpha");
					Thread.sleep(login.slp_2);
					
					//save the conf btn
					na.saveNewaddNodeApp();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);							
				}
					
				
		        
				
				//add node connections:- add new node connection under the selected node app
				Thread.sleep(login.slp_2);
		        home.clickHome();
		        Thread.sleep(login.slp_2);
		        home.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(login.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickViewNodeConnections();
				Thread.sleep(login.slp_2);
				String pagHeadr1 = na.pageHeader_viewnodeConnction();
				String actualPageHeader1 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr1+" = "+actualPageHeader1);
				if (pagHeadr1.equals(actualPageHeader1)) {
					System.out.println("Entered the Page : " +pagHeadr1);
					
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(login.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//click on the add button
					na.clickonaddNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//enter sap name
					na.enterSapNameNodeConnctn("sap_name_nodeConnctn_POSApp");
					Thread.sleep(login.slp_2);
					
					
					//select connection type
					na.selectInputNodeappAddForm("selct_nod_sap_conction_type");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_optn_conctn_typ_Srvr");
					Thread.sleep(login.slp_2);
					
					
					//select protocol
					na.selectInputNodeappAddForm("selct_nod_sap_conction_protocol");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_type_Server");
					Thread.sleep(login.slp_2);										
					
					//ip address
					na.enterSapIPNodeConnctn("sap_ip_nodConnctn_POSApp");
					Thread.sleep(login.slp_2);

					
					      //scroll up to the input 'port'
					      na.scrollToanElementMehod("sap_port_nodConnctn");

					
					
					//port
					na.enterSapPortNodeConnctn("sap_port_nodConnctn_POSApp");
					Thread.sleep(login.slp_2);
									
					
					//max no of connctn
					na.enterSapMaxNoOfNodeConnctn("sap_max_no_of_nodConnctn_POSApp");
					Thread.sleep(login.slp_2);
					
					
					
					//select tls enable/disable
					na.selectInputNodeappAddForm("selct_nod_sap_conction_tls_sts");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_tls_disable");
					Thread.sleep(login.slp_2);
					
					
					//click on save btn
					na.clickonsaveNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
				}
				
				
			
		        
		        
		      //View/Edit Node Connections:-  Update and delete the node app connections
		        Thread.sleep(login.slp_2);
		        home.clickHome();
				Thread.sleep(login.slp_2);
		        home.scrollToanElementInHome("Nodeapp_nav");		        
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickViewNodeConnections();
				Thread.sleep(login.slp_2);
				String pagHeadr2 = na.pageHeader_viewnodeConnction();
				String actualPageHeader2 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr2+" = "+actualPageHeader2);
				if (pagHeadr2.equals(actualPageHeader2)) {	
					System.out.println("Testing the loop entry page header");
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(login.slp_2);					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//edit node app connction conf btn click
					na.eidtNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//update btn click 
					na.updateNodeAppbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);	
					
					
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("nodApp_form_input_option_conectn_POSApp");
					Thread.sleep(login.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//edit node app connction conf btn click
					na.eidtNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//delete btn click
					na.deleteNodeAppbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
				}	
		        
		        
		        
		        
		        
		        
		        
				
				 // View/Edit Node App:-  Update and delete the node app
		        Thread.sleep(login.slp_2);
		        home.clickHome();
				Thread.sleep(login.slp_2);
				home.scrollToanElementInHome("Nodeapp_nav");		        
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickViewEditNodeapp();
				Thread.sleep(login.slp_2);
				String pagHeadr3 = na.pageHeader_viewnodeApp();
				String actualPageHeader3 = na.actPagHeader_viewnodeApp();
				System.out.println(pagHeadr3+" = "+actualPageHeader3);
				if (pagHeadr3.equals(actualPageHeader3)) {	
					System.out.println("Testing the loop entry page header");
					
					//edit node app conf btn click
					na.eidtNodeAppbtn();
					Thread.sleep(login.slp_2);
					
					//update btn click 
					na.updateNodeAppbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);	
					
					//edit node app conf btn click
					na.eidtNodeAppbtn();
					Thread.sleep(login.slp_2);
					
					//delete btn click
					na.deleteNodeAppbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
				}		        	      	        		        	        
		        
				
	 }
    
    
    
    
    
    
	
    //Configuration adding for the nodapps
    @Test(priority = 3, groups = {"conf", "reggrsn1"}, dataProvider = "NodeAppData", dataProviderClass = ArrayDataProvider.class, enabled = true)
    public static void addNodeApp(String nodApp_name_optn, String nodApp_alpha_optn) throws IOException, InterruptedException {					
		
		        pomCall();
	
		        
		        // Add Node App:-  add new Node App for testing
		        Thread.sleep(login.slp_2);
		        home.clickHome();
		        Thread.sleep(login.slp_2);
		        home.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(login.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(login.slp_2);
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickAddNodeapp();
				Thread.sleep(login.slp_2);
				String pagHeadr = na.pageHeader_addnodeApp();
				String actualPageHeader = na.actPagHeader_addnodeApp();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
															
					
					//select nodeapp name for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm(nodApp_name_optn); //nodApp_form_input_option_POSApp
					Thread.sleep(login.slp_2);
					
				   	
					//select alpha node for the node app
					na.selectInputNodeappAddForm("node_form_input_selct_nodapp_alphanod");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm(nodApp_alpha_optn);  //nodApp_form_input_option_POSAlpha
					Thread.sleep(login.slp_2);
					
					//save the conf btn
					na.saveNewaddNodeApp();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);							
				}
											       				   
    }
    
    
    
    
    //cofigurations adding for the nodeapp connections
    @Test(priority = 4, groups = {"conf", "reggrsn1"}, dataProvider = "NodeAppConctnData", dataProviderClass = ArrayDataProvider.class, enabled = true)
    public static void addNodeAppConnections(String nodCon_optn, String sap_name_nodCon, String sap_ip_nodCon, String sap_port_nodCon, String mx_no_nodCon) throws IOException, InterruptedException {					
		
		        		        		        
		        
		      //add node connections:- add new node connection under the selected node app
				Thread.sleep(login.slp_2);
		        home.clickHome();
		        Thread.sleep(login.slp_2);
		        home.scrollToanElementInHome("Nodeapp_nav");
		        Thread.sleep(login.slp_2);
				driver.manage().window().maximize();
				Thread.sleep(login.slp_2);
				home.clickNodeapp();
				Thread.sleep(login.slp_2);
				home.clickViewNodeConnections();
				Thread.sleep(login.slp_2);
				String pagHeadr1 = na.pageHeader_viewnodeConnction();
				String actualPageHeader1 = na.actPagHeader_viewnodeConnction();
				System.out.println(pagHeadr1+" = "+actualPageHeader1);
				if (pagHeadr1.equals(actualPageHeader1)) {	
					System.out.println("Testing the loop entry page header");
					
					
					//select the nodeApp for connection creation
					na.selectInputNodeappAddForm("node_form_input_selct_nod_conction");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm(nodCon_optn);  //nodApp_form_input_option_conectn_POSApp
					Thread.sleep(login.slp_2);
					
					
					//click on the view button
					na.viewNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//click on the add button
					na.clickonaddNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					
					//enter sap name
					na.enterSapNameNodeConnctn(sap_name_nodCon); //sap_name_nodeConnctn_POSApp
					Thread.sleep(login.slp_2);
					
					
					//select connection type
					na.selectInputNodeappAddForm("selct_nod_sap_conction_type");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_optn_conctn_typ_Srvr");
					Thread.sleep(login.slp_2);
					
					
					//select protocol
					na.selectInputNodeappAddForm("selct_nod_sap_conction_protocol");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_type_Server");
					Thread.sleep(login.slp_2);										
					
					//ip address
					na.enterSapIPNodeConnctn(sap_ip_nodCon); //sap_ip_nodConnctn_POSApp
					Thread.sleep(login.slp_2);

					
					      //scroll up to the input 'port'
					      na.scrollToanElementMehod("sap_port_nodConnctn");

					
					
					//port
					na.enterSapPortNodeConnctn(sap_port_nodCon);  //sap_port_nodConnctn_POSApp
					Thread.sleep(login.slp_2);
									
					
					//max no of connctn
					na.enterSapMaxNoOfNodeConnctn(mx_no_nodCon); //sap_max_no_of_nodConnctn_POSApp
					Thread.sleep(login.slp_2);
					
					
					//select tls enable/disable
					na.selectInputNodeappAddForm("selct_nod_sap_conction_tls_sts");
					Thread.sleep(login.slp_2);
					na.optionInputNodAppAddForm("selct_option_sap_conction_tls_disable");
					Thread.sleep(login.slp_2);
					
					
					//click on save btn
					na.clickonsaveNodeConnctnbtn();
					Thread.sleep(login.slp_2);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
				}
		        
    }
 
    
}
package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.B_Home;
import pages.G_AlphaNode;
import utils.SqlConnectUtil;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class G_AlphaNodeTest extends TestBase {

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    
    @Test(priority = 2, groups = "reggrsn1")
    public static void addAlphaNode() throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Alpha node page (class object-instance created and constructor invoked)
				G_AlphaNode alp = new G_AlphaNode();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	        		        
		
		     // Add Alpha node:-  add new Alpha node for testing
				h.clickHome();
				Thread.sleep(log.slp_2);
				h.clickAlphaConf();
				Thread.sleep(log.slp_2);
				h.clickAddAlphaNod();
				Thread.sleep(log.slp_2);
				String pagHeadr = alp.pageHeader_addAlphaNode();
				String actualPageHeader = alp.actPagHeader_addAlphaNode();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
					
					//enter alpha node name
					alp.enterAlphaNodeinputValues("alphaNode_name_input", "alphaNode_name");
					Thread.sleep(log.slp_2);
					
					//select channel type 
					alp.selectInputAlphaAddForm("alph_chnel_typ_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_chnel_typ_option_POS");
					
					//select connection type
					alp.selectInputAlphaAddForm("alph_conect_typ_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_conect_typ_option_tcp");
					
					//enter alpha node ip
					alp.enterAlphaNodeinputValues("alphaNode_ip_input", "alphaNode_ip");
					Thread.sleep(log.slp_2);
					
					//enter alpha node port
					alp.enterAlphaNodeinputValues("alphaNode_port_input", "alphaNode_port");
					Thread.sleep(log.slp_2);
					
					//enter alpha node advice time
					alp.enterAlphaNodeinputValues("alphaNode_adv_timout_input", "alphaNode_adv_timout");
					Thread.sleep(log.slp_2);
					
					
					//scroll upto the element
					alp.scrollToElement("alph_routper_selct");					
					Thread.sleep(2000);
					
					
					//select Route per
					alp.selectInputAlphaAddForm("alph_routper_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_routper_option_node");
																												
					//select Busns Calndr
					alp.selectInputAlphaAddForm("alph_busi_clndr_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_busi_clndr_option_default");
					
					//select Extnl Cuover Enable
					alp.selectInputAlphaAddForm("alph_ext_cut_ovr_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_ext_cut_ovr_option_disable");					
					
					//select TLS enable
					alp.selectInputAlphaAddForm("alph_tls_sts_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_tls_sts_option_disable");
					
					
					//scroll upto the element
					alp.scrollToElement("alph_curncy_selct");					
					Thread.sleep(2000);
					
					
					//select Currency
					alp.selectInputAlphaAddForm("alph_curncy_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_curncy_option_INR");
					
					//select CardGroup
					alp.selectInputAlphaAddForm("alph_card_grup_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_card_grup_option_mds");
					
					//select Dest group
					alp.selectInputAlphaAddForm("alph_dest_grup_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_dest_grup_option_posdg");
					
					//select PIN key
					alp.selectInputAlphaAddForm("alph_pin_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_pin_option_Pravega_KWP");
					
					
					
					alp.saveNewaddAlphaNode();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
			
				}
				
				
			// Edit ->update and Delete Alpha node for testing	
//		        Thread.sleep(log.slp_2);
//				h.clickHome();
//				Thread.sleep(log.slp_2);
//				h.clickAlphaConf();
//				Thread.sleep(log.slp_2);
//				h.clickViewEditAlphaNod();
				Thread.sleep(log.slp_2);
				String pagHeadr1 = alp.pag_header_viewAlphaNode();
				String actualPageHeader1 = alp.actPagHeader_viewAlphaNode();
				if (pagHeadr1.equals(actualPageHeader1)) {	
					System.out.println("Testing the loop entry page header");
										
					//zoomout and scroll to right
					alp.zoomOutAndScrollRight();					
					Thread.sleep(2000);
					
							
					//cick on the edit btn of the selected alpha node
					alp.editAlphabtn("sample_alp","tr111","td111","alp_td_Edit_btn");
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
					//scroll upto the element
					alp.scrollToElement("alp_update_btn");					
					Thread.sleep(2000);
					
					//update after edit
					alp.clickonUpdatbtnAlphaEdit();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
					//zoomout and scroll to right
					alp.zoomOutAndScrollRight();					
					Thread.sleep(2000);
					
							
					//cick on the edit btn of the selected alpha node
					alp.editAlphabtn("sample_alp","tr111","td111","alp_td_Edit_btn");
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
					//scroll upto the element
					alp.scrollToElement("alp_delete_btn");					
					Thread.sleep(2000);
					
					//clickon delete btn after edit
					alp.clickonDelbtnAlphaEdit();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
					
					
			   }
				
    }
    
    
    
    
       
    
  //Complete Alpha Node settings Removal from the database tables
  	@Test(priority = 3)
  	public static void truncateDBTablesOfAlphaNode() throws SQLException {
  		//utils	-> SqlConnectUtil -> to remove all the dependend tables and alpha table(sap connections,node app, interchange, alpha node) form the DB 
  		SqlConnectUtil.alphaNodeTableevacuate();
  	}
  	 	  
    
      
    
    
    // Complete Alpha Node setting 
    @Test(priority = 4, dataProvider = "alphaData", dataProviderClass = ExcelDataProvider.class, groups = "ConfigurationRegression")
    public static void addAlphaNodes(String alphaName, String alphaPort) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Alpha node page (class object-instance created and constructor invoked)
				G_AlphaNode alp = new G_AlphaNode();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
		        	        		        
		
		     // Add Alpha node:-  add new Alpha node Configurations
				h.clickHome();
				Thread.sleep(log.slp_2);
				h.clickAlphaConf();
				Thread.sleep(log.slp_2);
				h.clickAddAlphaNod();
				Thread.sleep(log.slp_2);
				String pagHeadr = alp.pageHeader_addAlphaNode();
				String actualPageHeader = alp.actPagHeader_addAlphaNode();
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Testing the loop entry page header");
					
					//enter alpha node name
					alp.enterAlphaNodeinputValues("alphaNode_name_input", alphaName);
					Thread.sleep(log.slp_2);
					
					//select channel type 
					alp.selectInputAlphaAddForm("alph_chnel_typ_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_chnel_typ_option_POS");
					
					//select connection type
					alp.selectInputAlphaAddForm("alph_conect_typ_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_conect_typ_option_tcp");
					
					//enter alpha node ip
					alp.enterAlphaNodeinputValues("alphaNode_ip_input", "alphaNode_ip");
					Thread.sleep(log.slp_2);
					
					//enter alpha node port
					alp.enterAlphaNodeinputValues("alphaNode_port_input", alphaPort);
					Thread.sleep(log.slp_2);
					
					//enter alpha node advice time
					alp.enterAlphaNodeinputValues("alphaNode_adv_timout_input", "alphaNode_adv_timout");
					Thread.sleep(log.slp_2);
					
					
					//scroll upto the element
					alp.scrollToElement("alph_routper_selct");					
					Thread.sleep(2000);
					
					
					//select Route per
					alp.selectInputAlphaAddForm("alph_routper_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_routper_option_node");
																												
					//select Busns Calndr
					alp.selectInputAlphaAddForm("alph_busi_clndr_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_busi_clndr_option_default");
					
					//select Extnl Cuover Enable
					alp.selectInputAlphaAddForm("alph_ext_cut_ovr_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_ext_cut_ovr_option_disable");					
					
					//select TLS enable
					alp.selectInputAlphaAddForm("alph_tls_sts_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_tls_sts_option_disable");
					
					
					//scroll upto the element
					alp.scrollToElement("alph_curncy_selct");					
					Thread.sleep(2000);
					
					
					//select Currency
					alp.selectInputAlphaAddForm("alph_curncy_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_curncy_option_INR");
					
					//select CardGroup
					alp.selectInputAlphaAddForm("alph_card_grup_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_card_grup_option_mds");
					
					//select Dest group
					alp.selectInputAlphaAddForm("alph_dest_grup_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_dest_grup_option_posdg");
					
					//select PIN key
					alp.selectInputAlphaAddForm("alph_pin_selct");
					Thread.sleep(log.slp_2);
					alp.optionInputAlphaAddForm("alph_pin_option_Pravega_KWP");
					
					
					
					alp.saveNewaddAlphaNode();
					Thread.sleep(2000);
					popupWindwHandlr.alertHandler();
					Thread.sleep(2000);
			
				}
    
    }
    
    
}

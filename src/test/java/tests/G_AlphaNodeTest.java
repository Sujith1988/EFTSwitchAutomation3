package tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ExcelDataProvider;
import pages.A_Login;
import pages.A_Home;
import pages.G_AlphaNode;
import utils.SqlConnectUtil;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class G_AlphaNodeTest extends TestBase {
	 	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static G_AlphaNode alphaNode;
    public static A_Login login;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	G_AlphaNode alphaNode = new G_AlphaNode();
    	A_Login login = new A_Login();
    	
    	G_AlphaNodeTest.home = home;
    	G_AlphaNodeTest.alphaNode = alphaNode;
    	G_AlphaNodeTest.login = login;
    }  
  /*--------------------------------------------------------------------------*/  
    
    
    
    
    
    
    /*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1, enabled = true)
    public static void adminlogin() throws IOException, InterruptedException {   	
    	pomCall();
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    }
    
    
    /*------Add alpha node for testing purpose--------*/
    @Test(priority = 2, groups = "reggrsn1", enabled = true)
    public static void addTestAlphaNode() throws IOException, InterruptedException {
    	addAlphaNode("alphaNode_name", "alph_chnel_typ_option_POS", "alphaNode_ip", "alphaNode_port", "alphaNode_adv_timout", "alph_ext_cut_ovr_option_disable", "alph_tls_sts_option_disable", "alph_curncy_option_INR", "alph_card_grup_option_mds", "alph_dest_grup_option_posdg", "alph_pin_option_Pravega_KWP");
    }
    	
    
    /*------Edit and update,delete alpha node for testing purpose--------*/
    @Test(priority = 3, groups = "reggrsn1", enabled = true)
    public static void editTestAlphaNode() throws IOException, InterruptedException {
    	editAlphaNode("POSAlpha_tst");
    }
    
   
                                  	    	      
       
    
  //Complete Alpha Node settings Removal from the database tables
  	@Test(groups = "conf", priority = 4, enabled = true)
  	public static void truncateDBTablesOfAlphaNode() throws SQLException {
  		//utils	-> SqlConnectUtil -> to remove all the dependend tables and alpha table(sap connections,node app, interchange, alpha node) form the DB 
  		SqlConnectUtil.alphaNodeTableevacuate();
  	}
  	 
 
  	
     	
 // Complete Alpha Node setting 
    @Test(groups = "conf", priority = 5, dataProvider = "alphaData", dataProviderClass = ExcelDataProvider.class, enabled = true)
    public static void addAlphaNodes(String alphaName, String alphaPort) throws IOException, InterruptedException {					
	
  	 addAlphaNode(alphaName, "alph_chnel_typ_option_POS", "alphaNode_ip", alphaPort, "alphaNode_adv_timout", "alph_ext_cut_ovr_option_disable", "alph_tls_sts_option_disable", "alph_curncy_option_INR", "alph_card_grup_option_mds", "alph_dest_grup_option_posdg", "alph_pin_option_Pravega_KWP");
    }
    
    
    
    
             
    
    
    
    
    /*---------------Genaral Function for alpha node creation-----------------*/
    public static void addAlphaNode(String alphaName, String chnl_typ_alpha, String alpha_IP, String alpha_port, String alpha_ad_tmout, String ext_cutovr_sts, String tls_sts, String alph_crncy_optn, String alph_CG_optn, String alph_DG_optn, String alph_pin_key) throws IOException, InterruptedException {							
	        
    		pomCall();     		        	        		        
	
	     // Add Alpha node:-
			home.clickHome();
			Thread.sleep(login.slp_2);
			home.clickAlphaConf();
			Thread.sleep(login.slp_2);
			home.clickAddAlphaNod();
			Thread.sleep(login.slp_2);
			String pagHeadr = alphaNode.pageHeader_addAlphaNode();
			String actualPageHeader = alphaNode.actPagHeader_addAlphaNode();
			if (pagHeadr.equals(actualPageHeader)) {	
				System.out.println("Entered the Page : " +pagHeadr);
				
				/*----------Form for Alpha Node Creation---------*/
				
				//enter alpha node name
				alphaNode.enterAlphaNodeinputValues("alphaNode_name_input", alphaName);//alphaNode_name  a
				Thread.sleep(login.slp_2);
				
				//select channel type 
				alphaNode.selectInputAlphaAddForm("alph_chnel_typ_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(chnl_typ_alpha);//alphaNodeh_chnel_typ_option_POS  b
				
				
				//select connection type
				alphaNode.selectInputAlphaAddForm("alph_conect_typ_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm("alph_conect_typ_option_tcp");
				
				//enter alpha node ip
				alphaNode.enterAlphaNodeinputValues("alphaNode_ip_input", alpha_IP);//alphaNode_ip  c
				Thread.sleep(login.slp_2);
				
				
				//enter alpha node port
				alphaNode.enterAlphaNodeinputValues("alphaNode_port_input", alpha_port);//alphaNode_port  d
				Thread.sleep(login.slp_2);
				
				//enter alpha node advice time
				alphaNode.enterAlphaNodeinputValues("alphaNode_adv_timout_input", alpha_ad_tmout);//alphaNode_adv_timout  e
				Thread.sleep(login.slp_2);
				
				
					//scroll upto the element
					alphaNode.scrollToElement("alph_routper_selct");					
					Thread.sleep(2000);
				
				
				//select Route per
				alphaNode.selectInputAlphaAddForm("alph_routper_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm("alph_routper_option_node");
																											
				//select Busns Calndr
				alphaNode.selectInputAlphaAddForm("alph_busi_clndr_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm("alph_busi_clndr_option_default");
				
				//select Extnl Cuover Enable
				alphaNode.selectInputAlphaAddForm("alph_ext_cut_ovr_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(ext_cutovr_sts);//alph_ext_cut_ovr_option_disable  f			
				
				//select TLS enable
				alphaNode.selectInputAlphaAddForm("alph_tls_sts_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(tls_sts);//alph_tls_sts_option_disable  g
				
				
					//scroll upto the element
					alphaNode.scrollToElement("alph_curncy_selct");					
					Thread.sleep(2000);
				
				
				//select Currency
				alphaNode.selectInputAlphaAddForm("alph_curncy_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(alph_crncy_optn);//alph_curncy_option_INR  h
				
				//select CardGroup
				alphaNode.selectInputAlphaAddForm("alph_card_grup_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(alph_CG_optn);//alph_card_grup_option_mds i
				
				//select Dest group
				alphaNode.selectInputAlphaAddForm("alph_dest_grup_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(alph_DG_optn);//alph_dest_grup_option_posdg  j
				
				//select PIN key
				alphaNode.selectInputAlphaAddForm("alph_pin_selct");
				Thread.sleep(login.slp_2);
				alphaNode.optionInputAlphaAddForm(alph_pin_key);//alph_pin_option_Pravega_KWP  k
				
				
				//save button add alpha node configuration
				alphaNode.saveNewaddAlphaNode();
				Thread.sleep(2000);
				popupWindwHandlr.alertHandler();
				Thread.sleep(2000);
		
			}
									
			
}
/*--------------------------------------------------------------------*/
    
    
    
    
    
/*---------------Genaral Function for alpha node editting-----------------*/
    public static void editAlphaNode(String alphaNodeName) throws IOException, InterruptedException {
    	
        pomCall();
        
        
    	// Edit ->update and Delete Alpha node
        Thread.sleep(login.slp_2);
        home.clickHome();
		Thread.sleep(login.slp_2);
		home.clickAlphaConf();
		Thread.sleep(login.slp_2);
		home.clickViewEditAlphaNod();
		Thread.sleep(login.slp_2);
		String pagHeadr1 = alphaNode.pag_header_viewAlphaNode();
		String actualPageHeader1 = alphaNode.actPagHeader_viewAlphaNode();
		if (pagHeadr1.equals(actualPageHeader1)) {	
			System.out.println("Entered the Page : " +pagHeadr1);
									
				
			//maximize window
			driver.manage().window().maximize();
			
				//zoomout to 70%
				alphaNode.zoomOutAndScrollRightE();					
				Thread.sleep(2000);
												
					
			//cick on the edit btn of the selected alpha node
			alphaNode.editAlphabtn(alphaNodeName,"tr111","td111","alp_td_Edit_btn");//sample_alp
			Thread.sleep(2000);			
			
			//scroll upto the element
			alphaNode.scrollToElement("alp_update_btn");					
			Thread.sleep(2000);
			
			//update after edit
			alphaNode.clickonUpdatbtnAlphaEdit();
			Thread.sleep(2000);
			popupWindwHandlr.alertHandler();
			Thread.sleep(2000);
			
				//zoomout and scroll to right
				alphaNode.zoomOutAndScrollRightW();					
				Thread.sleep(2000);
			
					
			//cick on the edit btn of the selected alpha node
			alphaNode.editAlphabtn(alphaNodeName,"tr111","td111","alp_td_Edit_btn");
			Thread.sleep(2000);
			
			//scroll upto the element
			alphaNode.scrollToElement("alp_delete_btn");					
			Thread.sleep(2000);
			
			//clickon delete btn after edit
			alphaNode.clickonDelbtnAlphaEdit();
			Thread.sleep(2000);
			popupWindwHandlr.alertHandler();
			Thread.sleep(2000);
			
			
			
	   }
   	}
    /*--------------------------------------------------------------------*/
                   

    
  
    
}
package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;
import utils.SortingRowOfTable;

public class G_AlphaNode extends TestBase{
	
	public G_AlphaNode() throws IOException {
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
	  

	
	  
	  		//-----------Add alpha node page actions---------------
			public String pageHeader_addAlphaNode() {
				return getElement("pag_header_addAlphaNode").getText();
			}	
			public String actPagHeader_addAlphaNode() {
				return getLocator("actPagHeader_addAlphaNode");
			}
			
			
			//----------------------------------form-----------------------------------------------------
			
			//---------General Method for all the enter-inputs-----------
			//Enter AlphaNode inputs			
			public void enterAlphaNodeinputValues(String alphaNode_input, String alphaNode_input_value){
				getElement(alphaNode_input).sendKeys(getLocator(alphaNode_input_value));
			}//-----------------------------------------------------------
			
						
			
			//---------General Method for all the select-options-----------
			//input-selects of the form alphanode add			
			public void selectInputAlphaAddForm(String alph_form_input_selct){
				getElement(alph_form_input_selct).click();
			}
			//input-options of the  form alphanode select	
			public void optionInputAlphaAddForm(String alph_form_input_option){
				getElement(alph_form_input_option).click();
			}//-----------------------------------------------------------
			
			
					
			//Save the new CG Name		
			public void saveNewaddAlphaNode(){
				getElement("sav_btn_alphaConf").click();
			}
			//----------------------------------form--------------------------------------------------------
			
			
		 // scroll upto the element 
			public  void scrollToElement(String element_tag) {
				ScrollUtil.scrollToAnElement(driver, getElement(element_tag));
			}
			
		// scroll upto right
			public  void scrollToRightEnd() {
				ScrollUtil.scrollToRight(driver);
			}
				
		// zoom out to 70% and then scroll to the right				
		public  void zoomOutAndScrollRight() {
			ScrollUtil.zoomOutAndScrollRightInElement(driver, driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div")));
		}
			
			
			
			
			
			
			//-----------View alpha node page actions---------------
			public String pag_header_viewAlphaNode() {
				return getElement("pag_header_viewAlphaNode").getText();
			}	
			public String actPagHeader_viewAlphaNode() {
				return getLocator("actPagHeader_viewAlphaNode");
			}
			
			
			
			// Alpha node edit button click
			  
			/*  paramName  : POSAlpha_tes, POSAlpha, SwitchAlpha, ATMAlpha
			  		   tr  : CardGrouop_table_rows
				       td  : CardGroup_table_firstcolumn     
				     tdbtn : CG_view_btn-colmn_on_pickedRow   */ 	
			public void editAlphabtn(String paramName, String tr, String td, String tdbtn) {							
				 SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td, tdbtn);			
			}
			
			
			
			//click on the update button after going to edit mode
			public void clickonUpdatbtnAlphaEdit(){
				getElement("alp_update_btn").click();
			}
			
			
			//click on the delete button after going to edit mode
			public void clickonDelbtnAlphaEdit(){
				getElement("alp_delete_btn").click();
			}
			
			
			
			
			/* ---------seperate methods instead of general method for alpha node adding--------------
			 			 			
//			//select channel type			
//			public void selectChannelTypeAlpha(String alph_chnel_typ_selct){
//				getElement("alph_chnel_typ_selct").click();
//			}			
//			public void optionChannelTypeAlpha(String alph_chnel_typ_option_POS){
//				getElement("alph_chnel_typ_option_POS").click();
//			}
//			
//			
//			//select connection type			
//			public void selectConnectionTypeAlpha(String alph_conect_typ_selct){
//				getElement("alph_conect_typ_selct").click();
//			}			
//			public void optionConnectionTypeAlpha(String alph_conect_typ_option){
//				getElement("alph_conect_typ_option").click();
//			}
//			
//			
//			//Enter IP 			
//			public void enterAlphaNodeIP(String alphaNode_ip){
//				getElement("enter_alphaNode_ip").sendKeys(getLocator(alphaNode_ip));
//			}
//			
//			
//			//Enter port		
//			public void enterAlphaNodePort(String alphaNode_port){
//				getElement("enter_alphaNode_port").sendKeys(getLocator(alphaNode_port));
//			}
//			
//			
//			
//			//Enter advice time out		
//			public void enterAlphaNodeAdviceTimeout(String alphaNode_adv_timout){
//				getElement("enter_alphaNode_adv_timout").sendKeys(getLocator(alphaNode_adv_timout));
//			}
//			
//			
//					
//			//select route-per			
//			public void selectRoutPerAlpha(String alph_routper_selct){
//				getElement("alph_routper_selct").click();
//			}			
//			public void optionRoutePerAlpha(String alph_routper_option){
//				getElement("alph_routper_option").click();
//			}
//			
//			
//			
//			//select business calender		
//			public void selectBusnsCalndrAlpha(String alph_busi_clndr_selct){
//				getElement("alph_busi_clndr_selct").click();
//			}			
//			public void optionBusnsCalndrAlpha(String alph_busi_clndr_option){
//				getElement("alph_busi_clndr_option").click();
//			}
//			
//			
//			
//			//select external cut over enabled/disabled			
//			public void selectExtCutOvrAlpha(String alph_ext_cut_ovr_selct){
//				getElement("alph_ext_cut_ovr_selct").click();
//			}			
//			public void optionExtCutOvrAlpha(String alph_ext_cut_ovr_option){
//				getElement("alph_ext_cut_ovr_option").click();
//			}
//			
//			
//			
//			//select TLS enabled/disabled		
//			public void selectTLSAlpha(String alph_tls_sts_selct){
//				getElement("alph_tls_sts_selct").click();
//			}			
//			public void optionTLSAlpha(String alph_tls_sts_option){
//				getElement("alph_tls_sts_option").click();
//			}
//			
//			
//			//select currency		
//			public void selectCurrencyAlpha(String alph_curncy_selct){
//				getElement("alph_curncy_selct").click();
//			}			
//			public void optionCurrencyAlpha(String alph_curncy_option){
//				getElement("alph_curncy_option").click();
//			}
//			
//			
//			
//			//select card group		
//			public void selectCardGroupAlpha(String alph_card_grup_selct){
//				getElement("alph_card_grup_selct").click();
//			}			
//			public void optionCardGroupAlpha(String alph_card_grup_option){
//				getElement("alph_card_grup_option").click();
//			}
//			
//			
//			
//			//select destination group		
//			public void selectdestinationGrupAlpha(String alph_dest_grup_selct){
//				getElement("alph_dest_grup_selct").click();
//			}			
//			public void optiondestinationGrupAlpha(String alph_dest_grup_option){
//				getElement("alph_dest_grup_option").click();
//			}
//			
//			
//			
//			//select pin key	
//			public void selectPinAlpha(String alph_pin_selct){
//				getElement("alph_pin_selct").click();
//			}			
//			public void optionPinAlpha(String alph_pin_option){
//				getElement("alph_pin_option").click();
//			}
//							  			  		 
			 *--------------------------------------------------- */
			
}

package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.SortingRowOfTable;

public class a_SystemConfig extends TestBase{
	
	  public a_SystemConfig() throws IOException {
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
		  

	// -----------Add System config page actions---------------
		public String pageHeader_addsysConf() {
			return getElement("pag_header_add_sysconf").getText();
		}	
		public String actPagHeader_addsysConf() {
			return getLocator("actual_pag_header_add_sysconf");
		}
		
		
		
		
		public void clickonSelectParam() {
			getElement("select_param").click();
		}	
		
		
		/*  key : parm_hostName, param_ipaddress, param_tracefilepath,
		 		  param_sslfilelocation, param_apiport, param_html_tracepath,
		 		  param_max_trace_files, param_trace_file_size	 */		 	
		public void selectParam(String paramKey) {
			getElement(paramKey).click();
		}	
		
			
		/* key : The value of the parameters selected above */
		public void selectparamValue(String paramValue) {
			getElement("select_param_value").sendKeys(paramValue);
		}
		
					
		public void clickonparamStatus() {
			getElement("select_param_status").click();
		}
		
		
		/*  key : param_status_1, param_status_0 */	
		public void selectParamStatus(String key) {
			getElement(key).click();
		}
				
		
		public void saveSysConf() {
			getElement("sys_conf_param_sav_btn").click();
		}

		
		
		
		
		
		
		
		// ----------View System config page actions---------------
		
			public String pageHeader_viewsysConf() {
				return getElement("pag_header_view_sysconf").getText();
			}	
			public String actPagHeader_viewsysConf() {
				return getLocator("actual_pag_header_view_sysconf");
			}
		

			   
			   
			   //Edit or Delete button in the View Sys Conf screen
			   /*  paramName : Comes directly from the excelsheet-sysConfDetails,  column-paramName		 		                	 
		 		         tr  : sysconf_table_rows
		 		         td  : sysconf_table_firstcolumn     
		 		       tdbtn : sysconf_edit_btn-colmn_on_pickedRow, sysconf_del_btn-colmn_on_pickedRow   */ 		        	
			   public void clickonViewSysConfEditbtn(String paramName, String tr, String td, String tdbtn) {				
					SortingRowOfTable.editDeleteTableRowElements(paramName, tr,  td,  tdbtn);
				}
			   
			   //Update button
			   public void clickonUpdatebtn() {
					getElement("view_conf_update_btn").click();
				}	
			   		   		   			  
			   				   		   						
		
}

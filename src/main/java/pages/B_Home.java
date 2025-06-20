package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import utils.LocatorReader;
import utils.ScrollUtil;

public class B_Home extends TestBase{			
	  public B_Home() throws IOException {
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
	  	  
	  
	  
	//-------------------Scrolls-----------------
		
	  // scroll upto the element of the page
	public void scrollToanElementInHome(String var) {
		ScrollUtil.scrollToAnElement(driver,getElement(var));
	}
	//----------------------------------------------
	
		
	
	  
/* --------Logout button text verification--------- */
	public String actualText() {
		return getLocator("btn_txt_logout_actual");
	}
	public String getButtonText() {
        return getElement("logout_btn").getText();
    }
	
	
	
	
/*- - - - - - - - -Logout and Home button click action -  - - - - -  - - -*/  
	public void clickButton() {
		getElement("logout_btn").click();
    }
	public void clickHome() {
		getElement("home_btn").click();
    }
	
	
	
/* -------------Side Nav Bar click and expansion actions----------- */
	//---User----
	public void clickUserLink() {
		getElement("user_link").click();
    }	
	public void clickAddUserLink() {	
		getElement("add_user_link").click();
    }	
	public void clickViewUserLink() {
		getElement("view_user_link").click();
    }
	
	
	
	//----Basic Configuration----
	public void clickonBasicConf() {
		getElement("basic_conf").click();
    }
	
	/*System Configuration*/
	public void clickonSysConf() {
		getElement("sys_conf").click();
    }
	public void clickonAddSysConf() {
		getElement("add_sys_conf").click();
    }
	public void clickonViewSysConf() {
		getElement("view_sys_conf").click();
    }
	
	/* Command Center*/
	public void cickonCommandCenter() {
		getElement("cmnd_cntr").click();
	}
	public void cickonApplicationCommands() {
		getElement("application_cmnd").click();
	}
	
	
	//----Routing Catagory----
	public void clickonRoutingCatagory() {
		getElement("routing_catgory").click();
    }
	public void clickonAddRoutingCatagory() {
		getElement("routing_catgory_add").click();
    }
	public void clickonViewRoutingCatagory() {
		getElement("routing_catgory_view").click();
    }
	
	
	
	
	
	//----card Group and Bin----
	public void clickonCardGrpAndBin() {
		getElement("card_grp&bin").click();
    }
	public void clickonAddCardGrp() {
		getElement("add_card_grp").click();
    }
	public void clickonViewCardGrpAndBin() {
		getElement("view_card_grp&bin").click();
    }
	
	
	
	
	//----Destination Group----
	public void clickonDestinationGrp() {
		getElement("destination_group").click();
	}	
	public void clickonViewDestinationGrp() {
		getElement("destination_group_view").click();
	}	
	public void clickonAddDestinationGrp() {
		getElement("destination_group_add").click();
	}
	
	
	
	
	//----Alpha Node----
	public void clickAlphaConf() {
		getElement("alfa_conf").click();
    }	
	public void clickAddAlphaNod() {
		getElement("add_alfa_nod").click();
    }
	public void clickViewEditAlphaNod() {
		getElement("view_edit_alfa_nod").click();
    }
	
	
	
	//----Routes----
		public void clickRouting() {
			getElement("routing_conf").click();
	    }	
		public void clickAddRoute() {
			getElement("add_routing_conf").click();
	    }
		public void clickViewEditRoute() {
			getElement("view_routing_conf").click();
	    }
		
		
		
		//----Node app----
		public void clickNodeapp() {
			getElement("Nodeapp_nav").click();
	    }	
		public void clickAddNodeapp() {
			getElement("add_Nodeapp_nav").click();
	    }
		public void clickViewEditNodeapp() {
			getElement("view_Nodeapp_nav").click();
	    }
		public void clickViewNodeConnections() {
			getElement("view_NodeConnection_nav").click();
	    }
		
		
		
		
		//----Interchange----
		public void clickInterchange() {
			getElement("intrchng_nav").click();
		}
		public void clickaddInterchange() {
			getElement("addintrchng_nav").click();
		}
		public void clickviewInterchange() {
			getElement("viewintrchng_nav").click();
		}
	
}

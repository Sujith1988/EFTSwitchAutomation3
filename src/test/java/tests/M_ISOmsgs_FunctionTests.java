package tests;

import java.io.IOException;
import java.net.UnknownHostException;

import org.testng.annotations.Test;

import base.TestBase;
import postilion.realtime.sdk.util.XPostilion;
import utils.MDS_ISOMsgs_ToSendToServerSocket;
import utils.ScrollUtil;

public class M_ISOmsgs_FunctionTests extends TestBase {
	
	//End to end transaction testing for the module MDS-interface
	 @Test(priority = 1, groups = "function", enabled = true)
	    public static void mdsInterfaceTest() throws UnknownHostException, IOException, XPostilion, InterruptedException {
	    			    
	    	
		 	//refresh screen and scroll to bottom of the page	    	
	    	scrollToBottomOfPage();
	    			 		    		    	
	    	//-------------------------------------------------------------
		 	//0200  message firing to the ISOAdapter-interchange port 4002
	    	MDS_ISOMsgs_ToSendToServerSocket.sendMsg(4002, 200);
	    	Thread.sleep(5000);  
	    	
	    	//refresh screen and scroll to bottom of the page	    	
	    	scrollToBottomOfPage();
	    	
	    	
	    	//0420 message firing to the ISOAdapter-interchange port 4002
	    	MDS_ISOMsgs_ToSendToServerSocket.sendMsg(4002, 420);
	    	Thread.sleep(5000);
	    	
	    	//refresh screen and scroll to bottom of the page	    	
	    	scrollToBottomOfPage();
	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	//--------------------------------------------------
	    	//0200 message firing to the POS-NodApp port 3001
	    	MDS_ISOMsgs_ToSendToServerSocket.sendMsg(3001, 200);
	    	Thread.sleep(5000);  
	    	
	    	//refresh screen and scroll to bottom of the page	    	
	    	scrollToBottomOfPage();
	    	
	    	
	    	//0420 message firing to the POS-NodApp port 3001
	    	MDS_ISOMsgs_ToSendToServerSocket.sendMsg(3001, 420);
	    	Thread.sleep(5000);
	    		    	
	    	//refresh screen and scroll to bottom of the page	    	
	    	scrollToBottomOfPage();
	    	
	    	
    	
	    	
	    	//---------------------------------------------------------
	    	//0200 and 0420 messages firing to the ATM-NodApp port 3001
	    	          /*byte[] message not yet built*/
	    }
	    
	 
	 
	 
	 	//End to end transaction testing for the module B24-interface
	    @Test(priority = 2, groups = "function", enabled = false)
	    public static void B24InterfaceTest() throws UnknownHostException, IOException, XPostilion, InterruptedException {
	    	//0200 and 0420 messages firing to the ISOAdapter-interchange port 4002    	
	    	
	    	//0200 and 0420 messages firing to the POS-NodApp port 3001
	   	   	
	    	//0200 and 0420 messages firing to the ATM-NodApp port 3001
	    	   /*byte[] message not yet built*/
	    }
	    
	    
	    
	  //-------------------Scrolls-----------------
		
		  // scroll upto the bottom of the page
		static void scrollToBottomOfPage() throws InterruptedException {
			driver.navigate().refresh();
	    	Thread.sleep(2000);
	    	
			ScrollUtil.scrollToBottom(driver);
			Thread.sleep(2000);
		}
		//----------------------------------------------
		
		
}

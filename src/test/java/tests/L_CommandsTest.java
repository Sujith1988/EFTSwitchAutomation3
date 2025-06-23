package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import base.TestBase;
import pages.A_Login;
import pages.A_Home;
import pages.L_Commands;
import utils.adminLoginCommon;

public class L_CommandsTest extends TestBase {

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1, groups = "functionTesting")
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
        
   
    
  //Commands sending Regression Testing
    @Test(priority = 2, groups = "reggrsn1", enabled = true)
    public static void commandsTests() throws IOException, InterruptedException {
    	
    	/*---LoggerOn cmnd sening-------*/ 	
    	sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    	sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_all", "option_cmd_interchange_all");
    	
    	/* Connect interchange cmnd sending*/
    	sendCommands("option_cmd_cmd_connect", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    	   	
    	/* Signon cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_signOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    	/* Signoff cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_signOff", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    	/* EchoReq cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_ecoReq", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    	/* Keychange cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_keyChange", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    	/* Traceon cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_traceOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    	/* Traceoff cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_traceOff", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
       	
    	/* Resync cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_resync", "option_cmd_interface_pravega", "option_cmd_interchange_pravega");
        	
    	/* Disconnect interchange cmnd sending*/
    	sendCommands("option_cmd_cmd_disconnect", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
      	
    	/*---LoggerOff cmnd sening-------*/
    	sendCommands("option_cmd_cmd_loggerOff", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    	
    	/* TraceClean cmnd sending to an interchange*/
    	sendCommands("option_cmd_cmd_traceClean", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
    
    }
    
              
  
    
    
    
    
  //Commands sending Testing - Function Testing
    @Test(priority = 3, groups = "functionTesting", enabled = true)
    public static void commandsFunTests() throws IOException, InterruptedException {
    	String txt = "";
    	
    	/*---LoggerOn cmnd sening-------*/
    	sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_all", "option_cmd_interchange_all");
    	String txt1 = sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");  	
    	txt = txt1;
    	if(txt.equalsIgnoreCase("MDS :: LOGGERON IS OK")) {
    		/* Traceon interchange cmnd sending*/
        	txt1 = sendCommands("option_cmd_cmd_traceOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
        	txt = txt1;
    	}
    	
    	if(txt.equalsIgnoreCase("MDS :: TRACEON IS OK")) {
    		/* Connect interchange cmnd sending*/
        	txt1 = sendCommands("option_cmd_cmd_connect", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
        	txt = txt1;
    	}
    	   	   	
    }
    
    
    
    
   
    
    
   /*--------Common function for both the regression and function testing-------*/
    static String sendCommands(String cmdOption, String intrfaceOption, String intrchngOption) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				A_Home h = new A_Home();
		// POM -- Application Commands page (class object-instance created and constructor invoked)
				L_Commands cm = new L_Commands();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		        
	
		        
		        // Send Commands:-  
		        Thread.sleep(log.slp_2);
		        h.clickHome();
		        Thread.sleep(log.slp_2);		   								
				h.clickonBasicConf();
				Thread.sleep(log.slp_2);
				h.cickonCommandCenter();
				Thread.sleep(log.slp_2);
				h.cickonApplicationCommands();
				Thread.sleep(log.slp_2);
				String pagHeadr = cm.pageHeader_applicationCommands();
				String actualPageHeader = cm.actPagHeader_applicationCommands();
				String txt = "cmnd page not accessible";
				if (pagHeadr.equals(actualPageHeader)) {	
					System.out.println("Entered the Page : " +pagHeadr);
					
					
					//select command
					cm.selectFieldCommand("select_cmd_cmd");
					Thread.sleep(log.slp_2);
					cm.selectFieldOptionCommand(cmdOption);//
					Thread.sleep(log.slp_2);
					
					//select interface
					cm.selectFieldCommand("select_cmd_interface");
					Thread.sleep(log.slp_2);
					cm.selectFieldOptionCommand(intrfaceOption);//
					Thread.sleep(log.slp_2);
					
					//select interchange
					cm.selectFieldCommand("select_cmd_interchange");
					Thread.sleep(log.slp_2);
					cm.selectFieldOptionCommand(intrchngOption);//
					Thread.sleep(log.slp_2);
					
					//send command button
					cm.sendCommandbtn();
					Thread.sleep(log.slp_2);
					
					//console the cmd status
					txt = cm.successTxtmsg();
					Thread.sleep(log.slp_2);
					System.out.println("cmd sts :" +txt);
					Thread.sleep(log.slp_2);	
//					return txt;
					
				}return txt;
    }
    
    //----------------------------------------------------------------------------
                                                       
                        
    
}
package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.A_Login;
import pages.A_Home;
import pages.L_Commands;
import pages.M_TraceViewer;
import utils.adminLoginCommon;

public class L_CommandsTest extends TestBase {
	/*---log4j object creation*/
	public static Logger loger = LogManager.getLogger(L_CommandsTest.class.getName());
	
	
	/*------page objcts creating from POM-class using function call-----------*/
    public static A_Home home;
    public static L_Commands cmd;
    public static A_Login login;
    public static M_TraceViewer trace;

    // Function to call in your method:
    public static void pomCall() throws IOException {
    	A_Home home = new A_Home();
    	L_Commands cmd = new L_Commands();
    	A_Login login = new A_Login();
    	M_TraceViewer trace = new M_TraceViewer();
    	
    	L_CommandsTest.home = home;
    	L_CommandsTest.cmd = cmd;
    	L_CommandsTest.login = login;
    	L_CommandsTest.trace = trace;
    }  
  /*--------------------------------------------------------------------------*/  
    
   
    
    
    
    

	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1, groups = {"function-C", "function-P"})
    public static void adminlogin() throws IOException, InterruptedException {
    	pomCall();	
    	adminLoginCommon.adminLogin(login.admnUser, login.admnPass, login);
    	
    	loger.info("Login success using admin credentials for function-C/P test");
    }
    
    
               
   
    
  //Commands sending Regression Testing
    @Test(priority = 2, groups = "function-C", enabled = true)
    public static void commandsTests() throws IOException, InterruptedException {
    	
    	try {
					
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
    	
    	} catch (Exception e) {
			// TODO: handle exception
    		loger.error("The server is not active, pls verify", e);
    		Assert.assertEquals(true,false);
		}
    }
    
              
  
    
    
    
    
  //Commands sending Testing - Function Testing
    @Test(priority = 3, groups = "function-P", enabled = true)
    public static void commandsFunTests() throws IOException, InterruptedException {
    	String txt = "";
    	
    	/*---LoggerOn cmnd sening-------*/
    	sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_all", "option_cmd_interchange_all");
    	String txt1 = sendCommands("option_cmd_cmd_loggerOn", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");  	
    	txt = txt1;
    	
    	if(txt.equalsIgnoreCase("MDS :: LOGGERON IS OK")) {
    		/* Connect interchange cmnd sending*/
        	txt1 = sendCommands("option_cmd_cmd_connect", "option_cmd_interface_mds", "option_cmd_interchange_mdsInterchange");
        	txt = txt1;
    	}else {
    		loger.info("The server is not active, pls verify");
    		Assert.assertEquals(txt,"MDS :: LOGGERON IS OK");
    	}
    	   	
    	   	   	
    }
    
    
    
    
    
    
    /*------Navigate to pravega logger page-------*/
    @Test(priority = 4, groups = "function-P")
    public static void navtoTraceViewer() throws IOException, InterruptedException  {   		
    	
    		traceViewer();
    				  	   	
    }
    
    
    
    
    
    
   
    
    
   /*--------Common function for both the regression and function testing-------*/
    
    
    static String sendCommands(String cmdOption, String intrfaceOption, String intrchngOption) throws IOException, InterruptedException {					
		
    			pomCall();
			        
		        // Send Commands:-  		        
		        home.clickHome();
		        loger.info("clicked on Home button, success");
		        
				home.clickonBasicConf();
				 loger.info("clicked on Basic conf link, success");
				 
				home.cickonCommandCenter();	
				 loger.info("clicked on CommandCenter link, success");
				 
				home.cickonApplicationCommands();
				 loger.info("clicked on ApplicationCommand link, success");
				 
				String pagHeadr = cmd.pageHeader_applicationCommands();
				String actualPageHeader = cmd.actPagHeader_applicationCommands();
				String txt = "cmnd page not accessible";
				if (pagHeadr.equals(actualPageHeader)) {
					 loger.info("Page verification success, Entered the Page : " +pagHeadr);					
					
					
					 try {
						 
					//select command
					cmd.selectFieldCommand("select_cmd_cmd");					
					cmd.selectFieldOptionCommand(cmdOption);//					
					
					//select interface
					cmd.selectFieldCommand("select_cmd_interface");					
					cmd.selectFieldOptionCommand(intrfaceOption);//					
					
					//select interchange
					cmd.selectFieldCommand("select_cmd_interchange");					
					cmd.selectFieldOptionCommand(intrchngOption);//					
										
						//send command button
						cmd.sendCommandbtn();
						loger.info("command sent to server");
						
					} catch (Exception e) {
						// TODO: handle exception						
						loger.error(e);
					}
										
					
					//console the cmd status
					txt = cmd.successTxtmsg();		
					loger.info("cmd sts :" +txt);				
//					return txt;
					
				}return txt;
    }
    
    //----------------------------------------------------------------------------
                                                       
            
    
    
    /*--------Navigate to the Logger page to see the request, response messages------*/
    static void traceViewer() throws IOException, InterruptedException {					
		
    			pomCall();
    			
    			// Send Commands:-  		       
		        home.clickHome();
		        loger.info("clicked on Home button, success");
		        
				home.clickTraceViewer();	
				 loger.info("clicked on Trace Viewer link, success");
				 
				home.clickViewTrace();
				loger.info("clicked on View Trace link, success");
				
				String pagHeadr = trace.pageHeader_traceViewer();
				String actualPageHeader = trace.actPagHeader_traceViewer();
				
				if (pagHeadr.equals(actualPageHeader)) {	
					loger.info("Page verification success, Entered the Page : " +pagHeadr);				
					
					try {
						trace.clickonPravegaLogger();					
						loger.info("Navigate to page Pravega logger, success");
					} catch (Exception e) {
						// TODO: handle exception
						loger.error("Navigate to page Pravega logger, failed", e);
						Assert.assertEquals(true, false);
					}
					
					//maximize window
				 	driver.manage().window().maximize();				 	
				}
    }
    
}
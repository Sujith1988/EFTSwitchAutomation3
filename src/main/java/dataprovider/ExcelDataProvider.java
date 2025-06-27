package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import pages.B_UserRegistration;
import utils.ExcelUtils;
import utils.LocatorReader;

public class ExcelDataProvider {
	public  String path = "";
	public  String sheet1 = "";
	public  String sheet2 = "";
	public  String sheet3 = "";
	public  String sheet4 = "";
	public  String sheet5 = "";
	public  String sheet6 = "";
	public  String sheet7 = "";
	public  String sheet8 = "";
	public  String sheet9 = "";
	public ExcelDataProvider() throws IOException {
		B_UserRegistration u =new B_UserRegistration();
		String path1 = u.getLocator("xcellFilePath");
		String sht1 = u.getLocator("xcellSheetTabName1");
		String sht2 = u.getLocator("xcellSheetTabName2");
		String sht3 = u.getLocator("xcellSheetTabName3");
		String sht4 = u.getLocator("xcellSheetTabName4");
		String sht5 = u.getLocator("xcellSheetTabName5");
		String sht6 = u.getLocator("xcellSheetTabName6");
		String sht7 = u.getLocator("xcellSheetTabName7");
		String sht8 = u.getLocator("xcellSheetTabName8");
		String sht9 = u.getLocator("xcellSheetTabName9");
		this.path = System.getProperty("user.dir")+path1;
		this.sheet1 = sht1;
		this.sheet2 = sht2;
		this.sheet3 = sht3;
		this.sheet4 = sht4;
		this.sheet5 = sht5;
		this.sheet6 = sht6;
		this.sheet7 = sht7;
		this.sheet8 = sht8;
		this.sheet9 = sht9;
	   }
	

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
   System.out.println("xcelFileLocation : "+path +" & shtName :"+sheet1);
        ExcelUtils excel = new ExcelUtils(path, sheet1);
        int rows = excel.getRowCount();
        System.out.println(rows);
        Object[][] data = new Object[rows][2]; // Skipping header

        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // Username
            data[i - 1][1] = excel.getCellData(i, 1); // Password
        }
        excel.closeExcel();
        return data;
    }
    
    
    
    @DataProvider(name = "usersData")
    public Object[][] getusersDetails() {
    	System.out.println(path);
    	System.out.println(sheet2);
        ExcelUtils excel = new ExcelUtils(path, sheet2);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][9]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // first name
            data[i - 1][1] = excel.getCellData(i, 1); // last name
            data[i - 1][2] = excel.getCellData(i, 2); // emaol id.
            data[i - 1][3] = excel.getCellData(i, 3); // ph. no.
            data[i - 1][4] = excel.getCellData(i, 4); // usr name
            data[i - 1][5] = excel.getCellData(i, 5); // paswd
            data[i - 1][6] = excel.getCellData(i, 6); // confirm paswd
            data[i - 1][7] = excel.getCellData(i, 7); // Login usr name
            data[i - 1][8] = excel.getCellData(i, 8); // Login paswd
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    @DataProvider(name = "sysConfData")
    public Object[][] getsysConfDetails() {
    	System.out.println(path);
    	System.out.println(sheet3);
        ExcelUtils excel = new ExcelUtils(path, sheet3);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][8]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName
            data[i - 1][1] = excel.getCellData(i, 1); // tr
            data[i - 1][2] = excel.getCellData(i, 2); // td
            data[i - 1][3] = excel.getCellData(i, 3); // tdEditbtn
            data[i - 1][4] = excel.getCellData(i, 4); // tdDelbtn
            data[i - 1][5] = excel.getCellData(i, 5); // paramKey
            data[i - 1][6] = excel.getCellData(i, 6); // paramValue  
            data[i - 1][7] = excel.getCellData(i, 7); // paramStatus
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    
    
    
    @DataProvider(name = "RCData")
    public Object[][] getRCDetails() {
    	System.out.println(path);
    	System.out.println(sheet4);
        ExcelUtils excel = new ExcelUtils(path, sheet4);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][4]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName
            data[i - 1][1] = excel.getCellData(i, 1); // tr
            data[i - 1][2] = excel.getCellData(i, 2); // td
            data[i - 1][3] = excel.getCellData(i, 3); // tdEditbtn
            
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    @DataProvider(name = "DGData")
    public Object[][] getDGDetails() {
    	System.out.println(path);
    	System.out.println(sheet5);
        ExcelUtils excel = new ExcelUtils(path, sheet5);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][5]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName
            data[i - 1][1] = excel.getCellData(i, 1); // tr
            data[i - 1][2] = excel.getCellData(i, 2); // td
            data[i - 1][3] = excel.getCellData(i, 3); // tdEditbtn
            data[i - 1][4] = excel.getCellData(i, 4); // DGName
            
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    
//    @DataProvider(name = "CGData")
//    public Object[][] getCGDetails() {
//    	System.out.println(path);
//    	System.out.println(sheet6);
//        ExcelUtils excel = new ExcelUtils(path, sheet6);
//        int rows = excel.getRowCount();
//        Object[][] data = new Object[rows][11]; // Skipping header
//System.out.println(rows);
//        if (rows != 0) {        	        
//        for (int i = 1; i <= rows; i++) {
//            data[i - 1][0] = excel.getCellData(i, 0); // paramName1
//            data[i - 1][1] = excel.getCellData(i, 1); // tr1
//            data[i - 1][2] = excel.getCellData(i, 2); // td2
//            data[i - 1][3] = excel.getCellData(i, 3); // tdViewbtnCG  
//            data[i - 1][4] = excel.getCellData(i, 4); // paramName2
//            data[i - 1][5] = excel.getCellData(i, 5); // tr2
//            data[i - 1][6] = excel.getCellData(i, 6); // td2
//            data[i - 1][7] = excel.getCellData(i, 7); // tdEditbtnBIN 
//            data[i - 1][8] = excel.getCellData(i, 8); // tdDeletebtnBIN
//            data[i - 1][9] = excel.getCellData(i, 9); // tdEditbtnCG
//            data[i - 1][10] = excel.getCellData(i, 10); // RC
//        }                	
//        }
//        excel.closeExcel();
//        return data; 
//    }
    
    
    
    @DataProvider(name = "CGBinData")
    public Object[][] getCGDetails() {
    	System.out.println(path);
    	System.out.println(sheet6);
        ExcelUtils excel = new ExcelUtils(path, sheet6);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][14]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName1
            data[i - 1][1] = excel.getCellData(i, 1); // tr1
            data[i - 1][2] = excel.getCellData(i, 2); // td2
            data[i - 1][3] = excel.getCellData(i, 3); // tdViewbtnCG  
            data[i - 1][4] = excel.getCellData(i, 4); // paramName2
            data[i - 1][5] = excel.getCellData(i, 5); // tr2
            data[i - 1][6] = excel.getCellData(i, 6); // td2
            data[i - 1][7] = excel.getCellData(i, 7); // tdEditbtnBIN 
            data[i - 1][8] = excel.getCellData(i, 8); // tdDeletebtnBIN
            data[i - 1][9] = excel.getCellData(i, 9); // bin
            data[i - 1][10] = excel.getCellData(i, 10); // bin_descr
            data[i - 1][11] = excel.getCellData(i, 11); // pan_len
            data[i - 1][12] = excel.getCellData(i, 12); // bin_len
            data[i - 1][13] = excel.getCellData(i, 13); // RC
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    
    
    @DataProvider(name = "BINData")
    public Object[][] getBINDetails() {
    	System.out.println(path);
    	System.out.println(sheet7);
        ExcelUtils excel = new ExcelUtils(path, sheet7);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][9]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName1
            data[i - 1][1] = excel.getCellData(i, 1); // tr1
            data[i - 1][2] = excel.getCellData(i, 2); // td1
            data[i - 1][3] = excel.getCellData(i, 3); // tdViewbtnCG
            data[i - 1][4] = excel.getCellData(i, 4); // bin
            data[i - 1][5] = excel.getCellData(i, 5); // bin_descr
            data[i - 1][6] = excel.getCellData(i, 6); // pan_len
            data[i - 1][7] = excel.getCellData(i, 7); // bin_len
            data[i - 1][8] = excel.getCellData(i, 8); // RC
            
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
    
    
    @DataProvider(name = "RouteData")
    public Object[][] getRouteDetails() {
    	System.out.println(path);
    	System.out.println(sheet8);
        ExcelUtils excel = new ExcelUtils(path, sheet8);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][8]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // paramName1
            data[i - 1][1] = excel.getCellData(i, 1); // tr1
            data[i - 1][2] = excel.getCellData(i, 2); // td1
            data[i - 1][3] = excel.getCellData(i, 3); // tdEidtbtnCG
            data[i - 1][4] = excel.getCellData(i, 4); //option_routes_dg
            data[i - 1][5] = excel.getCellData(i, 5); //option_routes_cg
            data[i - 1][6] = excel.getCellData(i, 6); //option_routes_omega
            data[i - 1][7] = excel.getCellData(i, 7); //option_routes_rc
           
        }                	
        }
        excel.closeExcel();
        return data; 
    }

    
    @DataProvider(name = "alphaData")
    public Object[][] getAlphaDetails() {
    	System.out.println(path);
    	System.out.println(sheet9);
        ExcelUtils excel = new ExcelUtils(path, sheet9);
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows][2]; // Skipping header
System.out.println(rows);
        if (rows != 0) {        	        
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // alphanode name
            data[i - 1][1] = excel.getCellData(i, 1); // alphanode port
            
           
        }                	
        }
        excel.closeExcel();
        return data; 
    }
    
    
}

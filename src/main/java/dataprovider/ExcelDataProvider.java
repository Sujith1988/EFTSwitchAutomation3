package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import pages.UserRegistration;
import utils.ExcelUtils;
import utils.LocatorReader;

public class ExcelDataProvider {
	public  String path = "";
	public  String sheet1 = "";
	public  String sheet2 = "";
	public ExcelDataProvider() throws IOException {
		UserRegistration u =new UserRegistration();
		String path1 = u.getLocator("xcellFilePath");
		String sht1 = u.getLocator("xcellSheetTabName1");
		String sht2 = u.getLocator("xcellSheetTabName2");
		this.path = System.getProperty("user.dir")+path1;
		this.sheet1 = sht1;
		this.sheet2 = sht2;
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
}

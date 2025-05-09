package dataprovider;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ExcelDataProvider {
 String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\LoginTestData.xlsx";

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        ExcelUtils excel = new ExcelUtils(path, "LoginFunc");
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows - 1][2]; // Skipping header

        for (int i = 1; i < rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // Username
            data[i - 1][1] = excel.getCellData(i, 1); // Password
        }

        return data;
    }
}

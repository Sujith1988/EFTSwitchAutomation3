package templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class ExcelUtils_template2 {
	private Sheet sheet;

	public ExcelUtils_template2(String excelPath, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
//		return sheet.getPhysicalNumberOfRows();
		return sheet.getLastRowNum();
	}

	public String getCellData(int row, int col) {
		//return sheet.getRow(row).getCell(col).toString();
		Row rowData = sheet.getRow(row);
	    if (rowData == null || rowData.getCell(col) == null) {
	        return ""; // or return some default value
	    }
	    Cell cell = rowData.getCell(col);
	    return cell.toString();
	}

	// Add other utility methods as needed
}

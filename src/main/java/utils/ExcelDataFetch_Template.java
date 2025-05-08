package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataFetch_Template {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Constructor to call the function getData() at the object init.
		ExcelDataFetch_Template read = new ExcelDataFetch_Template();
		read.getData("devTestLogin");
	}

	
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
		
		//excel sheet loading fron the excel work book into a sheet object as input file stream data(bit data) to format further into string -
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\LoginTestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		// pick the last row and column numbers of the excel sheet from the sheet object
		int total_rows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);  //gets the 0th row(with all cells) as an object.
		int total_cols = rowCells.getLastCellNum();
		
		System.out.println("The total number of row and columns of the sheet are :" +total_rows +"and " +total_cols);
	
		// formatting into string data format from the bit buffer data of the fileInputStream obj.
		DataFormatter dataFormat = new DataFormatter();
		
		//2D sheet data buffer ->storing into 2D string aray object
		String testData[][] = new String[total_rows][total_cols];
		for(int i=1; i<=total_rows; i++) {
			for(int j=0; j<total_cols; j++) {
				testData[i-1][j] = dataFormat.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
	
		
	return testData;	
    };
}

package utils;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private Sheet sheet;
    private Workbook workbook;
    private FileInputStream fis;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum(); // Or getPhysicalNumberOfRows()
    }

    public String getCellData(int row, int col) {
        Row rowData = sheet.getRow(row);
        if (rowData == null || rowData.getCell(col) == null) {
            return "";
        }
        Cell cell = rowData.getCell(col);
        return cell.toString();
    }

    public void closeExcel() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

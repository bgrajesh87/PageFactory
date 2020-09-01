package SeleniumLatest.LatestSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelTest {
	
	@Test
	public void readExcel() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\bgraj\\workspace\\LatestSelenium\\TestData\\TestData.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet("Sheet1");
		int rCount = sh.getLastRowNum();
		//int cCount = row.getLastCellNum();
		for(int i=0; i<=rCount; i++) {
			Row row = sh.getRow(i);
			
			for(int j=0; j<row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}
		}
		
	}
}

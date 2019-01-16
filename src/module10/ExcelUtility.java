package module10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static void setExcel(String path, int sheetnum) throws IOException 
	{
		
		File src = new File (path);
		
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		
		sh = wb.getSheetAt(sheetnum);	
		
	}
	
	public static String getData(int rownum, int cellnum) 
	{
		String data = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
		
	}
	
}

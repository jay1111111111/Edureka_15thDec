package module9;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingFromExcelFile {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		
	FileInputStream fis = new FileInputStream("D:\\Training\\EdurekaPrograms\\Edureka_27Aug\\src\\module9\\TestData.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheetAt(0);
	Row r = sh.getRow(1);
	Cell c = r.getCell(1);
	
	String value = c.getStringCellValue();
	System.out.println(value);
	
	
	}

}

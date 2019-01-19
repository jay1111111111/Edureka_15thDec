package tests;

import commonLibs.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) {
		
		String sFilename = 
				"D:\\Training\\Programs\\"
				+ "EdurekaFramework04032017\\inputFolder\\TestExcel.xlsx";
		String sSheetName = "TestSuite";
		
		ExcelDriver excel = new ExcelDriver();
		
		excel.createExcelWorkbook(sFilename);
		
		excel.openExcelWorkbook(sFilename);
		
		excel.createSheet(sSheetName);
		
		excel.setCellData(sSheetName, 1, 1, "Abhresh");
		excel.setCellData(sSheetName, 1, 2, "Dipesh");
		excel.setCellData(sSheetName, 1, 3, "Rekha");
		excel.setCellData(sSheetName, 2, 1, "Mayur");
		excel.setCellData(sSheetName, 2, 2, "Pushkar");
		
		excel.save();
		
		excel.close();

	}

}

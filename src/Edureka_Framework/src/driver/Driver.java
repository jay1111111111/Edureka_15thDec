package driver;

import java.util.Properties;

import org.openqa.selenium.By;

import commonLibs.ExcelDriver;
import commonLibs.KeywordUtility;
import utils.Utility;


public class Driver {

	
	private static KeywordUtility oKwDriver;
	private static String sDriverPropertyFile = "D:\\Training\\Programs\\EdurekaFramework04032017\\config\\config.properties";	
	private static Properties oDriverProperties;
	private static String sInputFileFolder;
	private static String sResultFolder;
	private static String sMainDriverInputFile;
	private static ExcelDriver oExcelDriver;
	private static String sCurrentTestCaseStatus;

	public static void main(String[] args) {
		
		oDriverProperties = Utility.getProperties(sDriverPropertyFile);
		
		sInputFileFolder = oDriverProperties.getProperty("inputFolder").trim();
		sMainDriverInputFile= oDriverProperties.getProperty("inputFile").trim();
		sResultFolder = oDriverProperties.getProperty("outputFile").trim();
		
		
		TestSuiteDriver();
		
	
		
		exportToExcel();

	}
	
	private static void TestSuiteDriver(){
		
		String sTestCaseSheetName, sRunFlag, sRunStatus, sComment;
		String sDriverExcelFile;
		int iRow, iRowCount;
		
		sDriverExcelFile = sInputFileFolder + "\\" + sMainDriverInputFile;
		oExcelDriver = new ExcelDriver();
		oExcelDriver.openExcelWorkbook(sDriverExcelFile);
		
		//Getting number of rows from Test Suite
		iRowCount = oExcelDriver.getRowCountoFSheet("TestSuite");
		
		
		for(iRow=2;iRow <=iRowCount+1;iRow++){
			sTestCaseSheetName="";
			sRunFlag="";
			sRunStatus="";
			sComment="";
			sCurrentTestCaseStatus = "Pass";
			
			sTestCaseSheetName= oExcelDriver.getCellData("TestSuite", iRow, 2).trim();
			sRunFlag=oExcelDriver.getCellData("TestSuite", iRow, 3).trim();
			
		
			
			if(sRunFlag.equalsIgnoreCase("yes")){
				oKwDriver = null;
				sRunStatus = TestCaseDriver(sTestCaseSheetName);
				
				if (sRunStatus == "") {
					if(sCurrentTestCaseStatus == "Pass"){
						sRunStatus = "Pass";
					} else {
						sRunStatus = "Fail";
						sComment = "One or more steps got Failed";
					}
					
				} else {
					sComment = sRunStatus;
					sRunStatus = "Fail";
				}
				
			} else{
				sRunStatus = "Skipped";
				sComment = "Because, Run Flag was set to " + sRunFlag;
			}
			
			oExcelDriver.setCellData("testSuite", iRow, 4, sRunStatus);
			oExcelDriver.setCellData("testSuite", iRow, 5, sComment);
		}
		
	}

private static String TestCaseDriver(String sSheetName){
	int iRow, iRowCount;
	
	String sTestCaseDriverreturnvalue="";
	
	String sActionKeyword;
	String sObjectLocator;
	String sArgumentValue;
	String sRunStatus;
	String sComment;
	String sReturnValue;
	By oBy;
	
	try {
			
			oKwDriver = new KeywordUtility();
			iRowCount = oExcelDriver.getRowCountoFSheet(sSheetName);
			
			for(iRow=2;iRow <= iRowCount + 1;iRow++){
				sActionKeyword = "";
				sObjectLocator ="";
				sArgumentValue ="";
				sRunStatus = "";
				sComment = "";
				sReturnValue ="";
				oBy = null;
				
				sActionKeyword = oExcelDriver.getCellData(sSheetName, iRow, 2).trim();
				sObjectLocator =oExcelDriver.getCellData(sSheetName, iRow, 3).trim();
				sArgumentValue =oExcelDriver.getCellData(sSheetName, iRow, 4).trim();
				
				if(sObjectLocator != "" && !sObjectLocator.equals("")){
					oBy = Utility.getLocatorBy(sObjectLocator);
				}
				
				if(sActionKeyword == ""){
					sRunStatus = "Skipped";
					sComment = "No Action Keyword";
				} else {
					try {
						
					sReturnValue =	oKwDriver.performAction(sActionKeyword, oBy, sArgumentValue);
					
						if(sReturnValue.toLowerCase().contains("error")){
							sRunStatus = "Fail";
							sComment = sReturnValue;
							sReturnValue ="";
							sCurrentTestCaseStatus = "Fail";
						} else {
							sRunStatus = "Pass";
						}
						
					} catch (Exception e) {
						sRunStatus = "Exception";
						sComment = e.getMessage();
						sCurrentTestCaseStatus = "Fail";
					}
				}
				
				oExcelDriver.setCellData(sSheetName, iRow, 5, sRunStatus);
				oExcelDriver.setCellData(sSheetName, iRow, 7, sReturnValue);
				oExcelDriver.setCellData(sSheetName, iRow, 6, sComment);
				
			}
			
		
	} catch (Exception e) {
		sTestCaseDriverreturnvalue = e.getMessage();
		sCurrentTestCaseStatus = "Fail";
	}
	
	return sTestCaseDriverreturnvalue ;
}

private static void exportToExcel(){
	String sOutputFileName;
	String sDateTimeStamp;
	
	sDateTimeStamp = Utility.getDateTimeStamp();
	
	sOutputFileName = sResultFolder + "\\Result as on "+ sDateTimeStamp + ".xlsx";
	
	oExcelDriver.saveAs(sOutputFileName);
}
}

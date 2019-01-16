package module9;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DDT1 {

	WebDriver driver;
	Workbook wb;
	Sheet sh;
	int rownum;
	int colnum;
	
	@BeforeTest
	public void OpenApp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");
	}

	
	@Test(dataProvider = "TD")
	public void FillForm(String FName, String LName, String Add) throws InterruptedException {
		
		//Enter in FirstName Field
		driver.findElement(By.id("ts_first_name")).clear();
		driver.findElement(By.id("ts_first_name")).sendKeys(FName);
		
		//Enter in LastName Field
		driver.findElement(By.id("ts_last_name")).clear();
		driver.findElement(By.id("ts_last_name")).sendKeys(LName);
		
		//Enter in Address Field
		driver.findElement(By.id("ts_address")).clear();
		driver.findElement(By.id("ts_address")).sendKeys(Add);
		
		Thread.sleep(5000);
	}
	
	@DataProvider(name = "TD")
	public Object[][] TestDataFeed() throws BiffException, IOException{
		
		//Give the location of the Excell File
		FileInputStream fis = new FileInputStream("E:\\Abhresh\\EdurekaPrograms\\Edureka_15thDec\\src\\module9\\TestData.xls");
	
		//open workbook
		wb = Workbook.getWorkbook(fis);
		
		//Open the sheet
		sh = wb.getSheet(1);
		
		//look at the sheet for row number
		rownum = sh.getRows();
		
		//look at the sheet for Column number		
		colnum = sh.getColumns();		
		
		Object[][] FormData = new Object[rownum][colnum];
		
		for(int i=0; i<rownum; i++) 
		{
			for(int j=0; j<colnum; j++) 
			{
			
				//Fetch the FirstName Value
				FormData[i][j] = sh.getCell(j, i).getContents();
				//Fetch LastName Value
				FormData[i][j] = sh.getCell(j, i).getContents();
				//Fetch Address Value
				FormData[i][j] = sh.getCell(j, i).getContents();
			}
		}
		return FormData;
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
}

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

public class DDT2 {

	WebDriver driver;
	Workbook wb;
	Sheet sh;
	int numrow;
	int numcol;

	@BeforeTest
	public void OpenBrowser() {
	
		//Open Browser
		System.setProperty("webdriver.chrome.driver", "D:\\Training\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		//Open AUT
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");
		
	}
	
	@Test(dataProvider = "TestData")
	public void FormFill(String Fname, String Lname, String Add) throws InterruptedException {
		
		driver.findElement(By.id("ts_first_name")).clear();
		driver.findElement(By.id("ts_first_name")).sendKeys(Fname);
		driver.findElement(By.id("ts_last_name")).clear();
		driver.findElement(By.id("ts_last_name")).sendKeys(Lname);
		driver.findElement(By.id("ts_address")).clear();
		driver.findElement(By.id("ts_address")).sendKeys(Add);
		Thread.sleep(5000);
	}

	@DataProvider(name = "TestData")
	public Object[][] TestDataFeed() throws IOException, BiffException{
		
		FileInputStream fis = new FileInputStream("D:\\Training\\EdurekaPrograms\\Edureka_27Aug\\src\\module9\\TestData.xls");
		
		wb = Workbook.getWorkbook(fis);
		 
		sh = wb.getSheet(1);
		
		numrow = sh.getRows();
		
		numcol = sh.getColumns();
		
		Object[][] formData = new Object[numrow][numcol];
		
		for(int i=0; i<numrow; i++) {
			for(int j=0; j<numcol; j++) {
			//Fetch first row First Name
			formData[i][j]=sh.getCell(j, i).getContents();
			//Fetch first row Last name
			formData[i][j]=sh.getCell(j, i).getContents();
			//Fetch first row Address
			formData[i][j]=sh.getCell(j, i).getContents();
			}
		}
		return formData;
	}
	
	@AfterTest
	public void QuitBrowser() {
		driver.quit();
	}	
}

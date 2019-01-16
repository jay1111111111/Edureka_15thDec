package module9;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DDT {

	WebDriver driver;
	Workbook WB;
	Sheet SH;
	int rownum;
	int colnum;

	@BeforeTest
	public void OpenApp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");

	}

	@Test(dataProvider = "TD")
	public void FormFillup(String FName, String LName, String Add) throws InterruptedException {

		// Enter data in the First Name
		driver.findElement(By.id("ts_first_name")).clear();
		driver.findElement(By.id("ts_first_name")).sendKeys(FName);

		// Enter data in the Last Name
		driver.findElement(By.id("ts_last_name")).clear();
		driver.findElement(By.id("ts_last_name")).sendKeys(LName);

		// Enter data in the Address
		driver.findElement(By.id("ts_address")).clear();
		driver.findElement(By.id("ts_address")).sendKeys(Add);
		
		Thread.sleep(5000);
	}

	@DataProvider(name = "TD")
	public Object[][] TestDataFeed() throws IOException, BiffException {

		// File src = new
		// File("E:\\Abhresh\\EdurekaPrograms\\Edureka_8thOct\\src\\module9\\TestData.xls");

		FileInputStream fis = new FileInputStream(
				"E:\\Abhresh\\EdurekaPrograms\\Edureka_8thOct\\src\\module9\\TestData.xls");

		WB = Workbook.getWorkbook(fis);

		SH = WB.getSheet(1);

		rownum = SH.getRows();

		colnum = SH.getColumns();

		Object[][] FormData = new Object[rownum][colnum];

		for (int i = 0; i < rownum; i++) 
		{
			for (int j = 0; j < colnum; j++) 
			{
				// Fetch the 1st row for First Name field
				FormData[i][j] = SH.getCell(j,i).getContents();
				// Fetch the 2nd row for Last Name field
				FormData[i][j] = SH.getCell(j,i).getContents();
				// Fetch the 3rd row for Address field
				FormData[i][j] = SH.getCell(j,i).getContents();
			}
		}
		return FormData;
	}

	@AfterTest
	public void CloseApp() {
		driver.quit();
	}

}

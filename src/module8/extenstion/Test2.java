package module8.extenstion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://docs.seleniumhq.org");

		SeleniumHomePageObjects page = new SeleniumHomePageObjects(driver);
		
		
		Thread.sleep(5000);
		page.ClickDownload();
		Thread.sleep(5000);
		page.ClickHomeLink();
		Thread.sleep(5000);
		page.ClickDownload();
		
		page.SearchSel("Selenium");


	}

}

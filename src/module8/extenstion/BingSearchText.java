package module8.extenstion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchText {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.bing.com");

		BingHomePageObjects page = new BingHomePageObjects(driver);

		page.SearchBing("Selenium");
		page.LinkSelenium();
		
	
		SeleniumHomePageObjects Selpage = new SeleniumHomePageObjects(driver);
		Thread.sleep(5000);
		Selpage.ClickDownload();
		Thread.sleep(5000);
		Selpage.ClickHomeLink();
		
		
		

	}

}

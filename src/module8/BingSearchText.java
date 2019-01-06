package module8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchText {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.bing.com/");

		BingHomePageObjects page = new BingHomePageObjects(driver);

		// Search Edureka
		page.txtSearch.sendKeys("Edureka");
		page.btnClick.click();

		// Search India
		page.txtSearch.clear();
		page.txtSearch.sendKeys("India");
		page.btnClick.click();

		// Search SeleniumHQ
		page.txtSearch.clear();
		page.txtSearch.sendKeys("SeleniumHQ");
		page.btnClick.submit();

	}

}

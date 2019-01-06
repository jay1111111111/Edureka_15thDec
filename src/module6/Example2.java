package module6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example2 {

	private WebDriver driver;
	String URL = "http://www.gmail.com";

	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", 
						"E:\\Abhresh\\Installation_stuff\\ExeFiles\\geckodriver.exe");
				   driver = new FirefoxDriver();
				
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
				driver = new ChromeDriver();
			
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"E:\\Abhresh\\Installation_stuff\\ExeFiles\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void login_TestCase() {
		driver.navigate().to(URL);
                //do something
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
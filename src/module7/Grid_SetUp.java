package module7;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_SetUp {
	public static WebDriver driver;

	public static void main(String[]  args) throws MalformedURLException, InterruptedException{

 		String URL = "http://www.google.com";
 		String Node = "http://192.168.137.1:5555/wd/hub";
 		
 		DesiredCapabilities cap = DesiredCapabilities.firefox();
 		cap = DesiredCapabilities.firefox(); 
 		cap.setBrowserName("firefox"); 
 		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
 		driver = new RemoteWebDriver(new URL(Node), cap);
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
 	}		
}
package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		//Open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open AUT
		driver.get("http://seleniumautomationpractice.blogspot.com/2017/10/waitcommands.html");


		WebDriverWait wait = new WebDriverWait(driver, 4);
		
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LinkText-4")));
		e.click();
		
		/*WebDriverWait wait1 = new WebDriverWait(driver, 1);

		WebElement a = wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("LinkText-3")));
		a.click();
*/		
	}
}








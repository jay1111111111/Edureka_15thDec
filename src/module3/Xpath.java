package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) {

		// Instantiate the Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open the AUT
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/functionisogramigoogleanalyticsobjectri.html");
		
		driver.findElement(By.xpath("//*[@name='lastname']//preceding::input[1]")).sendKeys("Abhresh");
		
		driver.findElement(By.xpath("//*[@name='lastname']//following::input[9]")).click();
		
		driver.findElement(By.xpath("//*[contains(@name,'profession')]//following::input[5]")).click();
		
		driver.findElement(By.xpath("//*[contains(@id, 'continents')]//following-sibling::option[4]")).click();
	
		
	}

}

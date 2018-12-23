package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingXpaths {

	public static void main(String[] args) {

		// Instantiate the Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open the AUT
		driver.get("https://www.facebook.com/");
		
		//driver.findElement(By.xpath("//*[@name='pass']//preceding::input[1]")).sendKeys("Abhresh");
		
		driver.findElement(By.xpath("//*[@id='month']//preceding::select/option[31]")).click();
		
		driver.findElement(By.xpath("//*[@id='day']//following::select/option[12]")).click();
		
		driver.findElement(By.xpath("//*[@id='month']//following::select/option[10]")).click();
		
		

	}

}

package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		

		//Instantiate the Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		//Open Application under test
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");
		
		driver.findElement(By.id("ts_first_name")).sendKeys("Abhresh");
		
		driver.findElement(By.name("ts_last_name")).sendKeys("Sugandhi");
		
		driver.findElement(By.name("ts_address")).sendKeys("Pune, Maharashtra, India");
		
		driver.findElement(By.name("ts_checkbox1")).click();
		
		driver.findElement(By.name("Submit1")).click();
		
		Thread.sleep(5000);
		
		driver.close();
	}

}

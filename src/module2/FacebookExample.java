package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookExample {

	public static void main(String[] args) throws InterruptedException {
		
		//Instantiate the Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open the AUT
		driver.get("https://www.facebook.com/");
		
		//Locate using ID
		driver.findElement(By.id("u_0_j")).sendKeys("Abhresh");
			
		//Locate using Name
		driver.findElement(By.name("lastname")).sendKeys("Sugandhi");
		
		//Locate using class
		driver.findElement(By.className("inputtext")).sendKeys("Abhresh");
		driver.findElement(By.className("inputtext")).sendKeys("Sugandhi");

		Thread.sleep(5000);

		
		//Locate using Linktext
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		Thread.sleep(5000);
		
		driver.navigate().back();

		Thread.sleep(5000);

		//Locate using Partial Linktext
		driver.findElement(By.partialLinkText("Forgotten")).click();

		Thread.sleep(5000);
				
		//Locate using CSS
		driver.findElement(By.cssSelector("#identify_email")).sendKeys("Abhresh");	
		
		//Using Xpath
		driver.findElement(By.xpath("//*[@type = 'email']")).sendKeys("Abhresh");
		
	}

}

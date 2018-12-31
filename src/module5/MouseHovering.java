package module5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHovering {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Jackets");
		
		driver.findElement(By.xpath("//*[@type='submit' and @class = 'vh79eN']")).click();
		
		Thread.sleep(5000);

		WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/a/div[1]/div/div/div/img"));
		
		Actions act = new Actions(driver);

		act.moveToElement(mouseHover).perform();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package module4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MDBox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2018/04/popups.html");
		
		driver.findElement(By.xpath("//*[@href ='#0']")).click();
		
		driver.findElement(By.xpath("//*[@type ='text']")).sendKeys("Abhresh");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class ='alert']")).click();
		
		Thread.sleep(5000);
		
		Alert a = driver.switchTo().alert();
		
		a.accept();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class ='close']")).click();
		
		
	}

}

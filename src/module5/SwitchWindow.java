package module5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		//Part 1 - Main Window name
		String MW = driver.getWindowHandle();
		System.out.println("Main Window Name is:- "+ MW);
		System.out.println("====================================================================");
		
		Thread.sleep(5000);
		
		//Part 2 - Click on new Msg window and capture names of both the windows
		driver.findElement(By.xpath("//*[@id=\'alert']//preceding::button[2]")).click();
		
		Set<String> AWN = driver.getWindowHandles();
		System.out.println("All Window Name is:- "+ AWN);
		System.out.println("====================================================================");
		
		Thread.sleep(5000);
		
		//Part 3 - Switch between windows
		
		for(String SW : driver.getWindowHandles()) {
			
			Thread.sleep(5000);
			
			driver.switchTo().window(SW);
			
			Thread.sleep(5000);
			
			driver.switchTo().window(SW);
			
		}
		
		driver.close();		
		
		
		
		
		
		
		
		
		
		
		
	}

}

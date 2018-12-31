package module5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseActions {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");

		WebElement FName = driver.findElement(By.name("ts_first_name"));
		
		Actions act = new Actions(driver);
		
		Action newAct = act.moveToElement(FName)
				.keyDown(FName, Keys.SHIFT)
				.sendKeys("a")
				.keyUp(FName, Keys.SHIFT)
				.sendKeys("bhresh")
				.doubleClick(FName)
				.contextClick(FName)
				.build();
		
		newAct.perform();
		
		
		
		
	}

}

package module5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/functionisogramigoogleanalyticsobjectri.html");
		
		//Select Class to focus on the DropDown
		Select oSelect = new Select(driver.findElement(By.id("continents")));
		
		//Select by Index - Africa
		oSelect.selectByIndex(2);
		Thread.sleep(5000);
		
		//Select by Visible text - South America
		oSelect.selectByVisibleText("South America");
		Thread.sleep(5000);
		
		//Select by Value - Antarctica
		oSelect.selectByValue("g");
		

	}

}

package module5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/functionisogramigoogleanalyticsobjectri.html");

		Select mSelect = new Select(driver.findElement(By.id("selenium_commands")));
		//Part 1
		//Select Navigation Commands
		mSelect.selectByIndex(1);
		Thread.sleep(5000);
		
		mSelect.deselectByVisibleText("Navigation Commands");;
		Thread.sleep(5000);
		
		//Run a loop to select, print and then deselect the options
		List<WebElement> mSize = mSelect.getOptions();
		
		int mTotal = mSize.size();
		
		System.out.println(mTotal);
		
		for(int i = 0; i<mTotal; i++) {
			
			String sValue = mSize.get(i).getText();
				
			System.out.println(sValue);
			//Thread.sleep(5000);
			
			mSelect.selectByIndex(i);
			//Thread.sleep(5000);
			
			//mSelect.deselectByIndex(i);
			
		}
		//Deselect all
		mSelect.deselectAll();
		
	}

}

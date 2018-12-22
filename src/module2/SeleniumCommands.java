package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumCommands {

	public static void main(String[] args) {
	
		//Single Line Comments
		/*
		 * Multiline comment
		 */
		
		//Instantiating a Browser
		//Chrome
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver(2).exe");
		WebDriver driver = new ChromeDriver();
	
		//Firefox
		System.setProperty("webdriver.gecko.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\geckodriver.exe");
		WebDriver FF = new FirefoxDriver();
			
		//IE
		System.setProperty("webdriver.ie.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\IEDriverServer.exe");
		WebDriver IE = new InternetExplorerDriver();
			
		//Close and Quit Browser
		driver.close();// this will close the current active window of the current instance
		driver.quit();// this will close all the windows in the current instance
		
		//Get Commands
		driver.get("URL");//Open URL of an AUT
		driver.getTitle(); // This is will help you to fetch the title of the current page
		driver.getCurrentUrl();// This will help you to fetch the URL of the current Page
		driver.getWindowHandle(); //This will help you to handle the multiple windows which is going to be discussed in the 5th module
		driver.getPageSource(); //This is used to get the page source of the current URL and it is displayed in the console panel
		driver.getClass(); // this is used to get the class name of the current Element
		
		//Navigation Commands
		driver.navigate().to("URL");//Navigating to a particular URL and it can be same as driver.get commands
		driver.navigate().back();// to go to previous page
		driver.navigate().forward();// to move to the next page
		driver.navigate().refresh();// to refresh the page
		
		//Element Handling Commands
		//Click
		driver.findElement(By.id("")).click();
		//Type
		driver.findElement(By.id("")).sendKeys("Abhresh");
		//Clear
		driver.findElement(By.id("")).clear();
		
	}

}











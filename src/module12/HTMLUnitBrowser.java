package module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HTMLUnitBrowser {

	public static void main(String[] args) {

/*	System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		*/
	
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.facebook.com/");
				
		System.out.println("Page Title is :- "+ driver.getTitle());
		
		driver.quit();
		
	}

}

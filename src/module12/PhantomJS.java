package module12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJS {

	public static void main(String[] args) {
		

		//WebDriver driver = new HtmlUnitDriver();
		
		System.setProperty("phantomjs.binary.path", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
				
		driver.get("https://www.google.com/");
		
		
		System.out.println("Page Title is :- "+ driver.getTitle());
		
		driver.quit();
		
	}

}

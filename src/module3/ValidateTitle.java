package module3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		String AppTitle = driver.getTitle();

		System.out.println(AppTitle);
			
		boolean result = AppTitle.equals("Google");
		
		System.out.println(result);
		
		
		
	}

}

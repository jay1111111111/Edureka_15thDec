package module4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PAlert {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumautomationpractice.blogspot.com/2018/01/blog-post.html");
		
		driver.findElement(By.id("prompt")).click();
		
		Alert pA = driver.switchTo().alert();
		
		pA.sendKeys("Abhresh Sugandhi");
			
		pA.accept();
		
		String VT = driver.findElement(By.id("msg")).getText();
		
		System.out.println(VT);
		
		boolean Result = VT.equals("Hello Abhresh Sugandhi! How are you today?");
		
		System.out.println(Result);
		
	}

}

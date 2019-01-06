package module5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GOIBIBO {

	public static void main(String[] args) throws InterruptedException {

		// Open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		
		// Open AUT
		driver.get("https://www.goindigo.in");
		
		// Task:1 Getting the current window name
		String CW = driver.getWindowHandle();
		System.out.println("Main window name is:" + CW);
		System.out.println("------------------------");

		// Task:2 Click on onewaytrip
		driver.findElement(By.xpath("//*[@id='oneWayTrip']")).click();
		
		// Task:3 Getting the Departure Destination Details
		driver.findElement(By.name("or-src")).click();
		driver.findElement(By.name("or-src")).sendKeys("Bengaluru");
		WebElement mouseHover = driver
				.findElement(By.xpath("//*[@data-name='Bengaluru' and @data-iata='BLR']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).click().build().perform();

		// Task:4 Getting the Arrival Destination details
		driver.findElement(By.name("or-dest")).click();
		driver.findElement(By.name("or-dest")).sendKeys("Lucknow");
		driver.findElement(By.xpath("//*[@data-name='Lucknow' and @data-iata='LKO']")).click();
		
		//Departure Dates
		driver.findElement(By.xpath("//*[@id='oneWayTrip']")).click();
		
		
		// Task:5 Passenger details
		driver.findElement(By.name("passenger")).click();
		
		// book for three adults
		driver.findElement(By.xpath("//*[@name='passenger']//following::button[2]")).click();
		driver.findElement(By.xpath("//*[@name='passenger']//following::button[2]")).click();
		
		// book for two children
		driver.findElement(By.xpath("//*[@name='passenger']//following::button[4]")).click();
		driver.findElement(By.xpath("//*[@name='passenger']//following::button[4]")).click();
		
		// click on submit/done
		WebElement Done = driver.findElement(By.xpath("//button[@class='btn btn-primary pax-done']"));
	
		act.moveToElement(Done).click().build().perform();

	}

}

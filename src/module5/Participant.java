package module5;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Participant {

	WebDriver driver;

	public void invokeBrowser() {

		// INSTANTIATE THE CHROME BROWSER
		System.setProperty("webdriver.chrome.driver", "E:\\Abhresh\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		// PAGE SYNCHRONIZATION AND OPEN THE AUT
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// open AUT
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		onewaytrip();
		closeBrowser();
	}

	public void onewaytrip() {
		try {

			// Task:1 Getting the current window name
			String CW = driver.getWindowHandle();
			System.out.println("Main window name is:" + CW);
			System.out.println("------------------------");

			// Task:2 Click on onewaytrip
			driver.findElement(By.xpath("//*[@id='oneWayTrip']")).click();
			Thread.sleep(1000);

			// Task:3 Getting the Departure Destination Details
			driver.findElement(By.name("or-src")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("or-src")).sendKeys("Bengaluru");
			Thread.sleep(1000);
			WebElement mouseHover = driver
					.findElement(By.xpath("//*[@data-name='Bengaluru' and @data-iata='BLR']"));
			Actions act = new Actions(driver);
			act.moveToElement(mouseHover).click().build().perform();

			// Task:4 Getting the Arrival Destination details
			driver.findElement(By.name("or-dest")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("or-dest")).sendKeys("Lucknow");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@data-name='Lucknow' and @data-iata='LKO']")).click();
			Thread.sleep(1000);

			//Departure Dates
			driver.findElement(By.xpath("//*[@id='oneWayTrip']")).click();
			Thread.sleep(1000);
			
			
			// Task:5 Passenger details
			driver.findElement(By.name("passenger")).click();
			// book for three adults
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[2]")).click();
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[2]")).click();
			
			// book for two children
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[4]")).click();
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[4]")).click();
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[4]")).click();
			
			// click on submit/done
			driver.findElement(By.xpath("//*[@name='passenger']//following::button[7]")).click();
			Thread.sleep(5000);

			// Task:6 Currency selection from drop down box
			driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[2]/div/div/button/div")).click();
			WebElement element = driver
					.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[2]/div/div/select"));
			Select oSelect = new Select(element);
			oSelect.selectByValue("USD");
			driver.findElement(
					By.xpath("//*[@id=\"bookFlightTab\"]/form/div[5]/div[2]/div/div/div/div/ul/li[2]/a/span[2]"))
					.click();
			Thread.sleep(2000);

			// Task:7 Search the available Flights
			driver.findElement(By.xpath("//*[@id=\"bookFlightTab\"]/form/div[7]/div[6]/button/span[1]")).click();
			Thread.sleep(2000);

			// Add Fluent Wait Commands
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(100, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		// Close the browser
		System.out.println("Closing the browser....");
		driver.close();
	}

	public static void main(String[] args) {

		Participant myObj = new Participant();
		myObj.invokeBrowser();

	}

}

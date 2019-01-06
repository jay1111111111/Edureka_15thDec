package module8.AdditionalExample.withPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_001_SignIn {
	
	@FindBy(tagName="")
	private WebElement id;

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Training\\Installation stuff\\Exe Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		// Creating object of HomePage
		HomePage homePage= new HomePage(driver);
		
		Thread.sleep(10000);
		
		// Click on Sign in button
		homePage.clickOnSignInButton();
		
		// Creating an object of LoginPage
		LoginPage loginPage= new LoginPage(driver);
		
		// Sign in
		loginPage.signIn("Amod", "Password");
		
		//Quit browser
		driver.quit();
		
		
		
	}
}
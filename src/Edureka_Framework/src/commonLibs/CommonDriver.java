package commonLibs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {
	
	private WebDriver Driver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout;
	
	public CommonDriver(){
		pageLoadTimeout = 60l;
		
		elementDetectionTimeout = 10l;
	}
	
	public void setPageLoadTimeout(long pageLoadTimeout){
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(long elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public void invokebrowser(String browserType, String url) throws Exception {
		browserType = browserType.trim();
		url = url.trim();
		
		if(browserType.equalsIgnoreCase("firefox") || browserType.equalsIgnoreCase("mozilla")
			||	browserType.equalsIgnoreCase("ff") || browserType.equalsIgnoreCase("mozilla firefox")){
			System.setProperty("webdriver.gecko.driver",
					"D:\\Training\\Installation stuff\\Exe Files\\geckodriver.exe");
			
			Driver = new FirefoxDriver();
		}
		
		else if (browserType.equalsIgnoreCase("chrome") || browserType.equalsIgnoreCase("google")
				||	browserType.equalsIgnoreCase("google chrome") ){
			System.setProperty("webdriver.chrome.driver", 
					"D:\\Training\\Installation stuff\\Exe Files\\chromedriver.exe");
			
			Driver = new ChromeDriver();

		} else {
			throw new Exception("Invalid Browser Type : "+ browserType);
		}
		
		if(url.isEmpty()){
			url = "about:blank";
		}
		
		Driver.manage().deleteAllCookies();
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		Driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		Driver.get(url);
	}
	
	//-----------------------------------------------------------------------------------------
	public void closeBrowser() throws Exception{
		
		Driver.close();
	}
	
	//-----------------------------------------------------------------------------------------
	public void closeAllBrowser() throws Exception{
		
		Driver.quit();
	}
	//-----------------------------------------------------------------------------------------
	
	public WebDriver getDriver(){
		return Driver;
	}
	
	//-----------------------------------------------------------------------------------------
	
	public String getTitle() throws Exception {
		return Driver.getTitle();
	}
	
	//-----------------------------------------------------------------------------------------
	
	public String getCurrentUrl() throws Exception {
			return Driver.getCurrentUrl();
		}
	
	//----------------------------------------------------------------------------------------
	
	public void navigateToUrl(String url) throws Exception {
		
		Driver.navigate().to(url);
	}
	
	//----------------------------------------------------------------------------------------
	
	public void reloadThePage() throws Exception {
			
			Driver.navigate().refresh();
		}
	//----------------------------------------------------------------------------------------
	
	public void navigateBack() throws Exception {
		
		Driver.navigate().back();
	}
	//----------------------------------------------------------------------------------------
	
	public void navigateForward() throws Exception {
		
		Driver.navigate().forward();
	}
	//----------------------------------------------------------------------------------------
	
	public void click(By oBy) throws Exception{
		
		Driver.findElement(oBy).click();
	}
	
	//----------------------------------------------------------------------------------------
	
	public void clear(By oBy) throws Exception{
		
		Driver.findElement(oBy).clear();
	}
	//----------------------------------------------------------------------------------------
	public void setText(By oBy, String value) throws Exception{
		
		Driver.findElement(oBy).sendKeys(value);
	}
	
	//----------------------------------------------------------------------------------------
	public String getText(By oBy) throws Exception{
		
		return Driver.findElement(oBy).getText();
	}
	//----------------------------------------------------------------------------------------
	
	
	//Added on 21st April 2017
	
	public void selectViaVisibleText(By oBy, String visibleText) throws Exception{
		
		Select dropdown = new Select(Driver.findElement(oBy));
		dropdown.selectByVisibleText(visibleText);
	}
	//----------------------------------------------------------------------------------------
	
	public void selectViaValue(By oBy, String value) throws Exception{
		
		Select dropdown = new Select(Driver.findElement(oBy));
		dropdown.selectByValue(value);
	}
	//----------------------------------------------------------------------------------------
	
	public void selectViaIndex(By oBy, int index) throws Exception{
		
		Select dropdown = new Select(Driver.findElement(oBy));
		dropdown.selectByIndex(index);
	}
	//----------------------------------------------------------------------------------------
	
	public boolean isDisplayed(By oBy) throws Exception{
		return Driver.findElement(oBy).isDisplayed();
		
	}
	//----------------------------------------------------------------------------------------
	public boolean isEnabled(By oBy) throws Exception{
		return Driver.findElement(oBy).isEnabled();
		
	}
	//----------------------------------------------------------------------------------------
	public boolean isSelected(By oBy) throws Exception{
		return Driver.findElement(oBy).isSelected();
		
	}
	//----------------------------------------------------------------------------------------
	
	//acceptAlert()
	//rejectAlert()
	//getMessageFromAnAlert()
	//switchToFrame - 3 ways
	//switchToChildWindow
	//getWindowHandle
	//getWindowHandles()
	//getAttribute
	//mouseHover
	//MoveToElementAndClick
	//DragAndDrop
	//RightClick
	//DoubleClick
	//TakeScreenshot

	
	//----------------------------------------------------------------------------------------
	
	public void waitTillElementVisible(By oBy, long timeOutInSeconds){
		
		WebDriverWait wait = new WebDriverWait(Driver, timeOutInSeconds);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
	}
	//----------------------------------------------------------------------------------------
	
	public void rejectAlert() throws Exception{

		Driver.switchTo().alert().dismiss();
		
	}
	//----------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------

	public void savePageSnapShot(String fileName) throws Exception{
		
		File tmpFile, imgFile;
		
		fileName = fileName.trim();
		
		TakesScreenshot camera;
		
		imgFile = new File(fileName);
		
		if(imgFile.exists()){
			throw new Exception("File already exists..");
		}
		camera = (TakesScreenshot) Driver;
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(tmpFile, imgFile);
		
		
		
	}
	
	//-----------------------------------------------------------------------------------------

	public void acceptAlert() throws Exception{

		Driver.switchTo().alert().accept();
		
	}

	//-----------------------------------------------------------------------------------------
	public void switchToFrame(String value) {
		
		Driver.switchTo().frame(value);
		
	}
	
	
	
	//----------------------------------------------------------------------------------------
}

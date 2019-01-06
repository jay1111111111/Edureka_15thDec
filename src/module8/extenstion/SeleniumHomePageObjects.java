package module8.extenstion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHomePageObjects {

	public SeleniumHomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="q")
	public WebElement SearchTxt;
	
	@FindBy(id="submit")
	public WebElement ClickGO;
	
	@FindBy(linkText = "Download")
	public WebElement linkdownload;

	@FindBy(linkText = "Browser Automation")
	public WebElement linkHome;
	
	
	public void SearchSel(String searchText) {
		SearchTxt.sendKeys(searchText);
		ClickGO.click();
	}
	
	public void ClickDownload() {
		linkdownload.click();
	}
	
	public void ClickHomeLink() {
		linkHome.click();
	}
}

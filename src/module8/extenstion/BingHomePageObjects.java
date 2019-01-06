package module8.extenstion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingHomePageObjects {

	public BingHomePageObjects(WebDriver driver) {
		// there is a PageFactory in Selenium which will initialize these elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement txtSearch;

	@FindBy(id = "sb_form_go")
	public WebElement btnClick;
	
	@FindBy(linkText = "Selenium - Web Browser Automation")
	public WebElement linkClick;
	
	
	public void SearchBing(String searchText) {
		
		txtSearch.clear();
		txtSearch.sendKeys(searchText);
		btnClick.click();

	}
	
	public void LinkSelenium() {
		linkClick.click();
	}
}

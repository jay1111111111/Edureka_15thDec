package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayPOM2Style {
	
	private WebElement searchBox;
	private WebElement searchCategory;
	private Select dropdown;
	private WebElement searchButton;
	
	public EbayPOM2Style(WebDriver Driver){
		searchBox = Driver.findElement(By.id("gh-ac"));
		searchCategory = Driver.findElement(By.id("gh-cat"));
		
		dropdown = new Select(searchCategory);
		
		searchButton = Driver.findElement(By.id("gh-btn"));
		
	}
	
	public void searchProduct(String product, String category){
		searchBox.sendKeys(product);
		
		dropdown.selectByVisibleText(category);
		
		searchButton.click();
	}
	

}

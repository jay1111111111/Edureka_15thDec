package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayPOM1Style {
	
	public WebElement searchBox;
	public WebElement searchCategory;
	public Select dropdown;
	public WebElement searchButton;
	
	public EbayPOM1Style(WebDriver Driver){
		searchBox = Driver.findElement(By.id("gh-ac"));
		searchCategory = Driver.findElement(By.id("gh-cat"));
		
		dropdown = new Select(searchCategory);
		
		searchButton = Driver.findElement(By.id("gh-btn"));
		
	}

}

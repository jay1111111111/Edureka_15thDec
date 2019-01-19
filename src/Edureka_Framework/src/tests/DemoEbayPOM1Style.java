package tests;

import commonLibs.CommonDriver;
import designPatterns.EbayPOM1Style;

public class DemoEbayPOM1Style {

	public static void main(String[] args) {
		CommonDriver cmnDriver = new CommonDriver();
		String url = "http://ebay.in";
			
		try {
			cmnDriver.setPageLoadTimeout(90l);
			
			cmnDriver.setElementDetectionTimeout(10l);
			
			cmnDriver.invokebrowser("chrome", url);
			
			EbayPOM1Style homePage = new EbayPOM1Style(cmnDriver.getDriver());
			
			
			//PageName (.) WebElement (.) Action
			homePage.searchBox.sendKeys("Apple Watches");
			
			homePage.dropdown.selectByVisibleText("Watches");
			
			homePage.searchButton.click();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}

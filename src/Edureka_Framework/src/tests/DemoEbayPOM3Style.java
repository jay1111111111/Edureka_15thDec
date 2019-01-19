package tests;

import commonLibs.CommonDriver;
import designPatterns.EbayPOM3Style;

public class DemoEbayPOM3Style {
	
	public static void main(String[] args) {
		CommonDriver cmnDriver = new CommonDriver();
		String url = "http://www.ebay.in";
		
		try {
			
			cmnDriver.setPageLoadTimeout(90l);
			cmnDriver.setElementDetectionTimeout(10l);
			
			cmnDriver.invokebrowser("chrome", url);
			
			EbayPOM3Style homePage = new EbayPOM3Style(cmnDriver.getDriver());
			
			homePage.searchProduct("Apple Watch", "Watches");
			
			cmnDriver.closeAllBrowser();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

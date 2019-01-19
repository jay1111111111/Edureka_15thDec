package tests;

import commonLibs.CommonDriver;
import designPatterns.EbayPOM2Style;

public class DemoEbayPOM2Style {

	public static void main(String[] args) {
		CommonDriver cmnDriver = new CommonDriver();
		String url = "http://ebay.in";
			
		try {
			cmnDriver.setPageLoadTimeout(90l);
			
			cmnDriver.setElementDetectionTimeout(10l);
			
			cmnDriver.invokebrowser("chrome", url);
			
			EbayPOM2Style homePage = new EbayPOM2Style(cmnDriver.getDriver());
			
			//PageName (.) Action
			homePage.searchProduct("Rado Watch", "Watches");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}

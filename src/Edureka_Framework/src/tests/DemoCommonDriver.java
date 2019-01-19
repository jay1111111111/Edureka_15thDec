package tests;

import org.openqa.selenium.By;


import commonLibs.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {
		CommonDriver cmnDriver;
		String url ="http://www.ebay.in";
		cmnDriver = new CommonDriver();
		try {
			
			
			cmnDriver.setPageLoadTimeout(90l);
			cmnDriver.setElementDetectionTimeout(10l);
			cmnDriver.invokebrowser("chrome", url);
			
			cmnDriver.setText(By.id("gh-ac"), "Apple Watches");
			
			cmnDriver.selectViaVisibleText(By.id("gh-cat"), "Watches");
			
			cmnDriver.click(By.id("gh-btn"));
			
			String result = cmnDriver.getText(By.className("listingscnt"));
			
			
			System.out.println("Result : "+ result);
			
			cmnDriver.savePageSnapShot("D:\\Training\\Programs\\EdurekaFramework04032017\\outputFolder\\test.jpg");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cmnDriver.closeAllBrowser();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
		
	}

}

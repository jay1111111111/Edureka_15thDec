package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;

public class Utility {

	public static void waitForSeconds(long seconds){
		try {
			
			Thread.sleep(seconds*1000L);
		} catch (Throwable t) {
			
		//	log.debug(t.getMessage());
		}
	}
	
	
	public static By getLocatorBy(String sLocatorString){
		try{
			
			String[] aLocator;
			
			sLocatorString = sLocatorString.trim();
			if(sLocatorString.isEmpty() || ! sLocatorString.contains(":=")){
				
				throw new Exception("Invalid Locator String");
			} 
			// id:=gh-ac
			//aLocator[0] = id
			//aLocator[1] = gh-ac
			aLocator = sLocatorString.split(":=");
			
			if(aLocator[0].equalsIgnoreCase("id")){
				return By.id(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("Class")){
				return By.className(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("xPath")){
				return By.xpath(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("css")){
				return By.cssSelector(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("link")){
				return By.linkText(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("partialLink")){
				return By.partialLinkText(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("name")){
				return By.name(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("tagname")){
				return By.tagName(aLocator[1]);
			}
			
			throw new Exception("Invalid locator String...");
			
		} catch(Throwable t){
			System.err.println(t.getMessage());
			
		//	log.debug(t.getMessage());
			return null;
		}
	}
	//----------------------------------------------------------------
	public static Properties getProperties(String propertiesFile){
		
		try {
			InputStream fileReader;
			Properties property;
			
			fileReader = new FileInputStream(propertiesFile);
			property = new Properties();
			
			property.load(fileReader);
			
			return property;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		//	log.debug(e.getMessage());
			return null;
		}
		
		
	}
	
	//---------------------------------------------------------------
	
	public static String getDateTimeStamp(){

		Date date;
		String[] datePart;
		String dateStamp;
		
		date = new Date();
		System.out.println(date.toString());
		//Mon Sep 07 17:28:42 IST 2015

		datePart = date.toString().split(" ");
		
		dateStamp = datePart[5] + "_" +
				datePart[1] + "_" +
				datePart[2] + "_" +
				datePart[3] ;
		
		dateStamp = dateStamp.replace(":",  "_");
		System.out.println(dateStamp);
		
		//2016_Jan_31_10_47_48
		return dateStamp;
	}



}

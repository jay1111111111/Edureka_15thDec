package tests;

import java.util.Properties;

import utils.Utility;

public class DemoConfigProperty {
	
	public static void main(String[] args) {
		
		Properties property = Utility.getProperties("D:\\Training\\Programs\\EdurekaFramework04032017\\config\\config.properties");
		
		System.out.println(property.getProperty("inputFolder"));
		System.out.println(property.getProperty("inputFile"));
		System.out.println(property.getProperty("outputFile"));
		
	}

}

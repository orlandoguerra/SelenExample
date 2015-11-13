package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumProcesor {
	
	public static final String URL_YTB_SIT2 =  "http://ytb-sit2-vip.hhscie.txaccess.net";
	public static final String URL_YTB_DEV1 =  "http://ytb-dev1-vip.hhscie.txaccess.net";	

	
	//Reference for Configuration
	//https://code.google.com/p/selenium/wiki/InternetExplorerDriver#Required_Configuration
	public static WebDriver getIEDriver(){
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
	
	
	public static  WebDriver getChromeDriver(){
		System.setProperty("webdriver.ie.driver", "Drivers\\chromedriver.exe");
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
	
	public static void waitSeconds(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}

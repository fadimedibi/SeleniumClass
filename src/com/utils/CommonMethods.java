package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	public static WebDriver driver;

	/**
	 * Use this method in need of opening browser and target url
	 * 
	 * @param browser The desired browser
	 * @param url     the desired url
	 */

	public static void setUp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
		} else {
			System.err.println("Browser is not supported");
		}

//		public static  setUp(String browser) {
		//
//				if (browser.equalsIgnoreCase("chrome")) {
//					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//					WebDriver driver = new ChromeDriver();
		//
//				} else if (browser.equalsIgnoreCase("firefox")) {
//					System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//					WebDriver driver = new FirefoxDriver();
//				}
//				return driver;
		//
//			}
	}
}
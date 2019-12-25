package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseExample {

	public static void main(String[] args) {
		// Opening Page on Chrome Browser
		//1.Open Chrome Browser
		//2.Navigate to “https://github.com/”
		// Opening Page on Firefox Browser1.Open Firefox browser
		//2.Navigate to “https://www.redfin.com/”
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://github.com/");
	driver.get("https://www.redfin.com/");
	
	driver.close();
	
	
	}

}

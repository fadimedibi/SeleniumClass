package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseAmazon {

	public static void main(String[] args) {
		// TC 1: Amazon Page Title Verification:
		// 1.Open chrome browser
		// 2.Go to “https://www.amazon.com/”
		// 3.Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed}

	System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.amazon.com/");
	String url=driver.getTitle();
	System.out.println(url);
	if(url.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
		System.out.println("Suscessful login");
	}else {
		System.out.println("Page and title are not verifed");
	}
	driver.close();
	
	
	
	}
}

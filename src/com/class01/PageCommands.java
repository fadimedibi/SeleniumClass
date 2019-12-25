package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		
		driver.get("http://google.com");
		
		final String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("I am on the right page");
		}else {
				System.err.println("The actual and expected Title did not match");
		}
		
		System.out.println("***********************");
		
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl="https://www.google.com/?gws_rd=ssl";
	//	System.out.println(expectedUrl);
	
	if(expectedUrl.equals(actualUrl)) {
		System.out.println("Both URL matched");
	}else {
		System.err.println("Actual and expected did not match");
	}
	
	
	driver.close();
	}

}

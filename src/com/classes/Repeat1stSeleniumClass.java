package com.classes;

import org.openqa.selenium.chrome.ChromeDriver;

public class Repeat1stSeleniumClass {

	public static void main(String[] args) throws InterruptedException {

		// System is a class, // set property is static method

		//					Key									Value
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// http----> Hypertext transfer protocol https--->source
	//	to go to a web page
		
	// .get method does not keep the history, but .navigate() method keeps the history and we can go back and forward
		
		driver.get("http://google.com");
	//	driver.get("http://facebook.com");
		
	// 	make to pause the execution to see how is this happening(no need so far
		Thread.sleep(2000);
	
		// browser navigation commands
	//	to navigate to given URL
		driver.navigate().to("http://syntaxtechs.com");
	// 	to navigate to previous page
		driver.navigate().back();
	//  to go forward (next web page	
		driver.navigate().forward();
		
	//	when we are done , to close last chrome page use close!!
		
		driver.navigate().refresh();
		
		// to get the title
		driver.getTitle();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		
		
		
		
		driver.close();
		
	
	}

}

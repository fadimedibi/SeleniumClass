package com.classes;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System is a class, // set property is static method

				//					Key									Value
				System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();

				// http----> Hypertext transfer protocol https--->source
			//	to go to a web page
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
				
				driver.navigate().to("http://facebook.com");
			System.out.println(driver.getTitle());
			
			driver.close();
				
	}

}

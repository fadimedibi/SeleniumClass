package com.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskAmazonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\murat\\eclipse-workspace\\SeleniumClass\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		  final String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	        String actualTitle = driver.getTitle();
	        
	        if(expectedTitle.equals(actualTitle)) {
	            System.out.println("I am on the right page");
	        }
	        else {
	            System.out.println("The titles do not match");
	        }
		
		
		
		
		
		
		
		
		
		
	}

}

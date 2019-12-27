package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskHRMS {
public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {
			//TC 1: HRMS Application Login: 
		//Open chrome browser
//		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//		Enter valid username and password
//		Click on login button

		
		
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get(URL);
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("sohilaryan");
			
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Syntax@12");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			
			//img[contains(@src,'5acde3dbd3adc6.90334155')]
			
		WebElement logo=driver.findElement(By.xpath("//img[contains(@src,'5acde3dbd3adc6.90334155')]"));
		
	System.out.println(logo.isDisplayed());
	driver.close();



//TC 2: HRMS Application Negative Login: 
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username
//Leave password field empty
//Verify error message with text “Password cannot be empty” is displayed.
	WebDriver dr = new ChromeDriver();
	dr.get(URL);
	dr.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("sohilaryan");
	
	dr.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");
	dr.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
		//span id="spanMessage"
	WebElement errorMes = dr.findElement(By.xpath("//span[@id='spanMessage']"));
	
	String error=errorMes.getText();
	if(error.equals("Password cannot be empty")) {
		System.out.println("Correct message is displayed");
	}else {
		System.out.println("Incorrect message is displayed");
	}
	dr.close();
	}
	

}

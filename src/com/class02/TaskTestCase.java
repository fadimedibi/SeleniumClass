package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskTestCase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Fahrettin");
		driver.findElement(By.name("lastName")).sendKeys("Cureklibatur");
		driver.findElement(By.name("phone")).sendKeys("9012345676");
		driver.findElement(By.id("userName")).sendKeys("Fahrettin34");
		driver.findElement(By.name("address1")).sendKeys("101 Yesilcam sk");
		driver.findElement(By.name("city")).sendKeys("Istanbul");
		driver.findElement(By.name("state")).sendKeys("Turkey");
		driver.findElement(By.name("postalCode")).sendKeys("34100");
		driver.findElement(By.id("email")).sendKeys("fahrettin34@gmail.com");
		driver.findElement(By.name("password")).sendKeys("fhr1234");
		driver.findElement(By.name("confirmPassword")).sendKeys("fhr1234");
		driver.findElement(By.name("register")).click();
		
		
		String url=driver.getCurrentUrl();
		if(url.equals("-------")) {
			System.out.println("User successfully registered");
		}else {
			System.out.println("User registration failed");
		}
		
		
	}

}

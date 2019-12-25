package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskFacebookLogIn {

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\murat\\eclipse-workspace\\SeleniumClass\\drivers\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("fadimedibi@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("fadimedibi54");
		driver.findElement(By.id("loginbutton")).click();
		
		
	}

}

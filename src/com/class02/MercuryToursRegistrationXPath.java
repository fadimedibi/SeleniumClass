package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursRegistrationXPath {

	public static void main(String[] args) {
//			Mercury Tours Registration: 
//			1.Open chrome browser2.Go to “”
//			3.Click on Register Link4.Fill out all required info5.
//			Click Submit6.User successfully registered
//		http://newtours.demoaut.com/
		
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://newtours.demoaut.com/");
//		driver.findElement(By.linkText("REGISTER")).click();
		
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Turkan");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Soray");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("123 Abc Ave.");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Memphis");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("TN");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("38125");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("TurkanSoray");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("turkan0987");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("turkan0987");
	
		driver.findElement(By.xpath("//input[@name='register']")).click();
	
		if(driver.equals(driver)) {
			System.out.println("Registered susscessfully");
		}else {
			System.out.println("Registration failed");
		}
		driver.close();
		
	}

}

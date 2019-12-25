package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

//		driver.findElement(By.xpath("//input[@id='text']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("abcd"); 

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hum@nhrm123");
//		
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.linkText("btnLogin")).click();
		driver.close();

	}

}

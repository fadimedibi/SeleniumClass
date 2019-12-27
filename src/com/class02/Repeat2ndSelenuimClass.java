package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Repeat2ndSelenuimClass {

	public static void main(String[] args) throws InterruptedException {
		// ID Locator

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

		WebElement userName = driver.findElement(By.id("txtUsername"));

		userName.sendKeys("Admin");

		// Name Locator

		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");

		// driver.findElement(By.id("btnLogin")).click();

		// Class Locator
		driver.findElement(By.className("button")).click();

		// LinkText Locator

		Thread.sleep(2000);
		// driver.findElement(By.linkText("Welcome Admin")).click();

		// PartialLinkText Locator
		driver.findElement(By.partialLinkText("Welcome")).click();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();

		// PartialLink Locator
		driver.close();

	}

}

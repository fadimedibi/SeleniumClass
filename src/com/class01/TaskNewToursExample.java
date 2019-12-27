package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskNewToursExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Ali");
		driver.findElement(By.name("lastName")).sendKeys("Baba");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.id("userName")).sendKeys("Alibaba@mynet.com");
		driver.findElement(By.name("address1")).sendKeys("Gingko cv");
		driver.findElement(By.name("city")).sendKeys("Dallas");
		driver.findElement(By.name("state")).sendKeys("TX");
		driver.findElement(By.name("postalCode")).sendKeys("44077");
		driver.findElement(By.id("email")).sendKeys("Ali Baba ve 40 Haramiler");
		driver.findElement(By.name("password")).sendKeys("Ali9900");
		driver.findElement(By.name("confirmPassword")).sendKeys("Ali9900");
		driver.findElement(By.name("register")).click();

	}

}

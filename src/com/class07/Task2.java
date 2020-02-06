package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 2: Verify element is clickable
		 * 
		 * Open chrome browser Go to “https://the-internet.herokuapp.com/” Click on
		 * “Click on the “Dynamic Controls” link Select checkbox and click Remove Click
		 * on Add button and verify “It’s back!” text is displayed Close the browser
		 */

		setUp("chrome", "https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Dynamic Controls")).click();

		driver.findElement(By.id("checkbox")).click();

		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
		boolean isDisplayed = driver.findElement(By.id("message")).isDisplayed();

		if (isDisplayed) {
			System.out.println("displayed message: " + driver.findElement(By.id("message")).getText());
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
		boolean isDisplayed1 = driver.findElement(By.id("message")).isDisplayed();
		if (isDisplayed1) {
			System.out.println("displayed message: " + driver.findElement(By.id("message")).getText());
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		Thread.sleep(3000);
		driver.quit();
		
		

	}

}

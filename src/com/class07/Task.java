package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Verify element is present
		 * 
		 * Open chrome browser Go to “https://the-internet.herokuapp.com/” Click on
		 * “Click on the “Dynamic Loading” link Click on “Example 1...” and click on
		 * “Start” Verify element with text “Hello World!” is displayed Close the
		 * browser
		 */

		setUp("chrome", "https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Dynamic Loading")).click();

		driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Hello World!']")));
		boolean isDisplayed = driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();

		if (isDisplayed) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");

			Thread.sleep(3000);
			driver.quit();
		}

	}

}

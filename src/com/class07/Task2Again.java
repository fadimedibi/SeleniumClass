package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task2Again extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 2: Verify element is clickable
		 * 
		 * Open chrome browser Go to “https://the-internet.herokuapp.com/” Click on
		 * “Click on the “Dynamic Controls” link Select checkbox and click Remove Click
		 * on Add button and verify “It’s back!” text is displayed Close the browser
		 */

		// initializing the webdriver and navigating to the page:Opening the chrome browser& navigating to  “https://the-internet.herokuapp.com/”
		setUp("chrome", "https://the-internet.herokuapp.com/");

		// Clicking on “Click on the “Dynamic Controls” link
		driver.findElement(By.linkText("Dynamic Controls")).click();

		// Selecting checkbox
		driver.findElement(By.id("checkbox")).click();

		// clicking Remove button
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

		// Printing the displayed message //It's gone!
		System.out.println("displayed message for remove: " + driver.findElement(By.id("message")).getText());

		// Clicking on Add button
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));

		// verifying “It’s back!” text is displayed
		boolean isDisplayed = driver.findElement(By.id("message")).isDisplayed();
		if (isDisplayed) {
			String displayedMessage = driver.findElement(By.id("message")).getText();
			System.out.println("displayed message for add: " + displayedMessage);
			if (displayedMessage.equals("It's back!")) {
				System.out.println("Passed");
			} else {
				System.out.println("Different message displayed! Failed!!");
			}
		} else {
			System.out.println("Failed");
		}

		Thread.sleep(3000);
		driver.quit();

	}

}

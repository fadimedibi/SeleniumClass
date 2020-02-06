package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task3 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 3: Verify element is enabled Open chrome browser Go to
		 * “https://the-internet.herokuapp.com/” Click on “Click on the “Dynamic
		 * Controls” link Click on enable button Enter “Hello” and verify text is
		 * entered successfully Close the browser
		 */

		// // Opening the chrome browser & navigating to
		// “https://the-internet.herokuapp.com/”
		setUp("chrome", "https://the-internet.herokuapp.com/");

		// Clicking on “Click on the “Dynamic Controls” link
		driver.findElement(By.linkText("Dynamic Controls")).click();

		// clicking on enable button
		driver.findElement(By.xpath("//button[text()='Enable']")).click();

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

		// entering the input
		String textToEnter="Hello";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(textToEnter);
		
		
		String enteredText = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");

		if(enteredText.equals(textToEnter)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
//		// verifying if the text displayed
//		boolean isDisp = driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();
//		if (isDisp) {
//			System.out.println("Passed");
//			// Printing the entered text using getAttribute() method
//			String displayedMessage = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
//			System.out.println("Entered input: " + displayedMessage);
//
//		} else {
//			System.out.println("Failed");
//		}

		
	}

}

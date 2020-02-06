package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class Recap extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "https://google.com");
		driver.findElement(By.name("q")).sendKeys("iphone 11 pro", Keys.ESCAPE);

		Actions act = new Actions(driver);

		// identify an element
		WebElement button = driver.findElement(By.name("btnK"));

		// 1 st way-move to the desired element and perform click
		act.moveToElement(button).click().perform();

		// 2nd way - click and specify the element on which to click
		// act.click(button).perform();

		Thread.sleep(3000);
		driver.quit();
	}

}

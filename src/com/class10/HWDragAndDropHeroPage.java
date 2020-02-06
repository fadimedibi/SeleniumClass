package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class HWDragAndDropHeroPage extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Drag and Drop")).click();

		WebElement from = driver.findElement(By.id("column-a"));
		WebElement to = driver.findElement(By.id("column-b"));

		Actions action = new Actions(driver);
		action.dragAndDrop(to, from).perform();
		
	//	action.dragAndDrop(to, from).build().perform();

	}

}

package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HWDragAndDrop extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);

		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Drag and Drop")).click();

		WebElement sourceElement1 = driver.findElement(By.xpath("//div[@id='todrag']/span[1]"));
		// WebElement sourceElement1 =
		// driver.findElement(By.xpath("//span[@draggable='true'][1]"));

		// WebElement targetElement =
		// driver.findElement(By.xpath("//*[@id='mydropzone']"));
		WebElement targetElement = driver.findElement(By.id("mydropzone"));

		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.clickAndHold(sourceElement1).moveToElement(targetElement).release().build().perform();

//		action.dragAndDrop(sourceElement1, targetElement).build().perform();

//		WebElement sourceElement2 = driver.findElement(By.xpath("//span[text()='Draggable 2']"));
//		Thread.sleep(3000);
//		action.dragAndDrop(sourceElement2, targetElement).perform();

//		WebElement sourceElement3=driver.findElement(By.xpath("//span[text()='Draggable 3']"));
//		WebElement sourceElement4=driver.findElement(By.xpath("//span[text()='Draggable 4']"));

//	dragAndDrop(sourceElement1, targetElement).perform();

//		action.dragAndDrop(sourceElement2, targetElement).perform();
//		Thread.sleep(3000);
//		action.dragAndDrop(sourceElement3, targetElement).perform();
//		Thread.sleep(3000);
//		action.dragAndDrop(sourceElement4, targetElement).perform();
//		Thread.sleep(3000);

	}

}

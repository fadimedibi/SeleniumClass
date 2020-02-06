package com.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HWDragAndDropActionClass extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://uitestpractice.com/Students/Actions");
		Actions action = new Actions(driver);
		// click
		WebElement clickMe = driver.findElement(By.xpath("//button[@name='click']"));
		action.moveToElement(clickMe).click().perform();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println("Displayed alert is " + alert.getText());
		alert.accept();
		Thread.sleep(3000);

		// double click
		WebElement doubleClick = driver.findElement(By.name("dblClick"));
		action.moveToElement(doubleClick).doubleClick().perform();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Displayed alert is " + alert1.getText());
		alert1.accept();
		Thread.sleep(3000);

		// drag and drop
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		action.dragAndDrop(from, to).perform();
		
		if (to.getText().equals("Dropped!")) {
			System.out.println("Drag and Drop action is PASSED");
		} else {
			System.out.println("Drag and Drop action is PASSED");
		}
		// hoverOver blue square
		WebElement hoverSquare = driver.findElement(By.xpath("//div[@id='div2']"));
		String colorBefore=hoverSquare.getAttribute("style");
		System.out.println("Before hovering, Color of the square: "+colorBefore);
		action.moveToElement(hoverSquare).perform(); // green square is expected
		Thread.sleep(3000);
		String colorAfter=hoverSquare.getAttribute("style");
		System.out.println("After hovering, Color of the square: "+colorAfter);
		Thread.sleep(3000);
		
		// clickAndHold 6-12
		WebElement startNum = driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"));
		WebElement endNum = driver.findElement(By.xpath("//ol[@id='selectable']/li[12]"));
		Thread.sleep(3000);
		action.clickAndHold(startNum).release(endNum).perform();
		Thread.sleep(3000);

		// taking screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/Random/ActionExamples4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
		driver.quit();

	}

}

package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TaskFrame extends CommonMethods {
	/*TC 1: Syntax Frame verification
	Open chrome browser
	Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	Click on “Others” link
	Click on “Iframe” link
	Click on the “Home” link inside the 1 frame
	Verify “Syntax logo” is displayed in another frame
	Quit browser
	*/
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {
		// The method is opening Syntax Practice Website using chrome browser
		
		CommonMethods.setUp("chrome",SYNTAX_PRACTICE_URL);
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Others")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Iframe")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("FrameOne");
		driver.findElement(By.linkText("Home")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("FrameTwo");
		
		WebElement logo=driver.findElement(By.xpath("//img[@class='custom-logo']"));
		
		boolean display=logo.isDisplayed();
		System.out.println("Logo displayed??: "+display);
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		
		
		
		
	}
}

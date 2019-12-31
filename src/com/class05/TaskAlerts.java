package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;
/*TC 1: JavaScript alert text verification
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Alerts & Modals” links
Click on “Javascript Alerts” links
Click on button in “Java Script Alert Box” section
Verify alert box with text “I am an alert box!” is present
Click on button in “Java Script Confirm Box” section
Verify alert box with text “Press a button!” is present
Click on button in “Java Script Alert Box” section
Enter text in the alert box
Quit browser
*/

public class TaskAlerts extends CommonMethods{

	public static final String JIRAVM_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		// The method is opening Syntax Practice Website using chrome browser
		CommonMethods.setUp("chrome", JIRAVM_URL);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Alert alert=driver.switchTo().alert();
		
		String text=alert.getText();
		if(text.equals("I am an alert box!")) {
			System.out.println("Correct message is displayed "+alert.getText());
		}else {
			System.out.println("Something is wrong");
		}
		alert.accept();
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert2=driver.switchTo().alert();
		
		String text2=alert2.getText();
		if(text2.equals("Press a button!")) {
			System.out.println("Correct message is displayed "+alert2.getText());
		}else {
			System.out.println("Something is wrong");
		}
		alert2.dismiss();
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Java Script Alert Box")).click();
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Alert alert3=driver.switchTo().alert();
		alert3.sendKeys("Finally, I am at the end");
		alert3.accept();
		boolean isDisplayed=driver.findElement(By.id("prompt-demo")).isDisplayed();
		System.out.println(isDisplayed);
		
		
		
	}
}

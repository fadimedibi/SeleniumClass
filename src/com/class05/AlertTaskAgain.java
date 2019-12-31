package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertTaskAgain extends CommonMethods {
	/*
	 * TC 1: JavaScript alert text verification Open chrome browser Go to
	 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” Click on “Alerts
	 * & Modals” links Click on “Javascript Alerts” links Click on button in “Java
	 * Script Alert Box” section Verify alert box with text “I am an alert box!” is
	 * present Click on button in “Java Script Confirm Box” section Verify alert box
	 * with text “Press a button!” is present Click on button in “Java Script Alert
	 * Box” section Enter text in the alert box Quit browser
	 */
	public static void main(String[] args) {

		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.xpath("//a[@href='#' and  text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		System.out.println("Java Script Alert box message: " + text);
		alert.accept();

		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert2 = driver.switchTo().alert();

		String text2 = alert2.getText();
		System.out.println("Java Script Confirm Box message: " + text2);
		alert2.accept();

		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Alert alert3 = driver.switchTo().alert();

		alert.sendKeys("I am on the final question, finally!!");
		alert3.accept();
		System.out.println(driver.findElement(By.id("prompt-demo")).isDisplayed());
		
		driver.quit();

	}

}

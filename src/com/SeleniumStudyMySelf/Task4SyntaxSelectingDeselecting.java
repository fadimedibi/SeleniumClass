package com.SeleniumStudyMySelf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class Task4SyntaxSelectingDeselecting extends CommonMethods {

	public static void main(String[] args) {
		/*
		 * Open chrome browser 6.Go to
		 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” 7.Click on
		 * “Input Forms” links 8.Click on “Select Dropdown List” links 9.Select value
		 * from “Select List Demo” section 10.Verify value has been selected 11.Select 4
		 * options from “Multi Select List Demo” 12.Deselect 1 of the option from the dd
		 * 13.Quit browser
		 */

		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement selDemoDD = driver.findElement(By.id("select-demo"));
		

		Select select = new Select(selDemoDD);
		select.selectByVisibleText("Friday");

		if (selDemoDD.getAttribute("value").equals("Friday")) {
			System.out.println("Correct day selected");
		} else {
			System.out.println("Incorrect day selected, please try again!");
		}

		WebElement multiSelDD = driver.findElement(By.id("multi-select"));

		Select select2 = new Select(multiSelDD);
		select2.selectByVisibleText("Texas");
		select2.selectByVisibleText("Ohio");
		select2.selectByVisibleText("Florida");
		select2.selectByVisibleText("Pennsylvania");

		select2.deselectByVisibleText("Ohio");

		driver.quit();

	}

}

package com.SeleniumStudyMySelf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class Task3AmazonDepartmentVerification extends CommonMethods {

	public static void main(String[] args) {
		/*
		 * TC 1: Amazon Department List Verification 1.Open chrome browser 2.Go to
		 * “http://amazon.com/” 3.Verify how many department options available. ●Print
		 * each department ●Select Computers 4.Quit browser
		 */

		CommonMethods.setUp("chrome", "http://amazon.com/");
		WebElement department = driver.findElement(By.id("searchDropdownBox"));

		Select options = new Select(department);
		List<WebElement> depOptions = options.getOptions();
		System.out.println("Number of Departments in amazon's page: " + depOptions.size());
		depOptions.add(department);
		for (WebElement deps : depOptions) {
			System.out.println(deps.getText());
		}
		options.selectByVisibleText("Computer");

		String depValue = department.getAttribute("value");
		// System.out.println(depValue);
		if (depValue.equals("search-alias=computers")) {
			System.out.println("Correct  department selected");
		} else {
			System.out.println("Incorrect department selected");
		}

		driver.quit();
	}

}

package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods {
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
//	 3 ways to get values from Select class 
//		select.selectByIndex(index);
//		select.selectByValue(value);
//		select.selectByVisibleText(text);

		// CommonMethods.setUp("ie","");//Browser is not supported

		// The method is opening Syntax Practice website using chrome browser
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);

		// find the element input form and click on it
		driver.findElement(By.linkText("Input Forms")).click();

		// find the element select drop down list and click on it
		driver.findElement(By.linkText("Select Dropdown List")).click();

		// find the element with id select demo and store it and a variable
		WebElement dd = driver.findElement(By.id("select-demo"));// since it has a select tag in DOM, we can use Select
																	// class and methods.

		// to work with id, if the tag name starts with select, then we have to create
		// an object of select class
		Select select = new Select(dd); // or Select select=new Select(driver.findElement(By.id("select-demo")));

		// select index 3
		select.selectByIndex(3);
		// selecting value by visible text
		select.selectByVisibleText("Friday");
		// selecting an item from dd using value attribute
		select.selectByValue("Saturday");

		
		//how to get the count of a drop down items
		List<WebElement> option = select.getOptions();
		System.out.println(option.size());
		
		for (WebElement element : option) {
			element.click();
			System.out.println(element.getText());
		}
		/* storing the list of option in iterator so we can loop through
		Iterator<WebElement> it=option.iterator();
		while(it.hasNext()) {
			it.next().click();
			Thread.sleep(1000);
		}
		*/
		System.out.println("Does this dropdown multiselect? "+select.isMultiple());
		
		driver.close();
	}

}

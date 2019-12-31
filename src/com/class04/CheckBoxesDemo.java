package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class CheckBoxesDemo extends CommonMethods{
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";


	public static void main(String[] args) {

		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		driver.manage().window().fullscreen();
		
		driver.findElement(By.linkText("Input Forms")).click();
		
		driver.findElement(By.linkText("Checkbox Demo")).click();
		WebElement ageCheckBox=driver.findElement(By.id("isAgeSelected"));
		ageCheckBox.click();
		System.out.println(ageCheckBox.isSelected());
		if(!ageCheckBox.isSelected()) {
			ageCheckBox.click();
		}
		ageCheckBox.click();
		driver.close();
		
	}
}

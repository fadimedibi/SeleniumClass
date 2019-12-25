package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("sohilaryan");

		// css=input[name='txtUsername']

		// input#txtUsername only if you have id attribute

		// input.button dot (.) used only for class if there is space in class value

		// input[name^='txt'] starts with CSS Selector
		
		// input[names$='name'] $ represents ends with
		
		// input[id*='nL'] * keyword represents contains
		
		// 

	}

}

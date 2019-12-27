package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SyntaxPracticeWebPagePractice {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://166.62.36.207/syntaxpractice/index.html");
	
	driver.findElement(By.id("btn_basic_example")).click();
	
	driver.findElement(By.linkText("<a href=\"basic-first-form-demo.html\" class=\"list-group-item\">Simple Form Demo</a>")).click();
	

	}

}

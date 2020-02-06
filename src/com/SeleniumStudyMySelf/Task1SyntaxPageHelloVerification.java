package com.SeleniumStudyMySelf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1SyntaxPageHelloVerification {

	public static void main(String[] args) {
		/*
		 * TC 1: Syntax Demo input boxes count:
		 *  1.Open chrome browser 
		 *  2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” 
		 *  3.Click on “Input Forms” links
		 *  4.Click on “Simple Form Demo” links 
		 *  5.Get all input boxes from the page 
		 *  6.Enter “Hello” to each text box 
		 *  7.Close browser
		 */

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.id("user-message")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();
		String msg=driver.findElement(By.xpath("//button[text()='Show Message']")).getText();
		
		System.out.println(msg);
		
		driver.findElement(By.id("sum1")).sendKeys("3");
		driver.findElement(By.id("sum2")).sendKeys("5");
		driver.findElement(By.xpath("//button[text()='Get Total']")).click();
		String msg2=driver.findElement(By.xpath("//button[text()='Get Total']")).getText();
		System.out.println(msg2);
		
		driver.close();
		
		
	}

}

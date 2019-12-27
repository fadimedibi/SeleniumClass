package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommandDemo3 {

	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		
		//Storing WebElement in a variable:
		WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		//entering user name:
		userName.sendKeys("Admin");
		
		//to get to hidden text from a textBox/text area
		//We use get Attribute(); method. Hidden text will always get stored in "value" attribute
		String userN = userName.getAttribute("value");
		
		//Printing the value of "value" attribute
		System.out.println(userN);

		//Sending password to password field
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		
		//getAttribute() will give us the value of the attribute we provide. Could be any attribute
		String attribute = driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("class");

		System.out.println(attribute);
		
		//submit() works smilar as click();
		//if this causes the current page to change, it will wait for new page to load.
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.close();
	}

}

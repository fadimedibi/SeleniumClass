package com.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class PageLoadAndImplicitWait extends CommonMethods {

	public static void main(String[] args) {
	

		setUp("chrome","https://google.com");
		//page load waits until all elements on the page gets fully loaded
		//if element won't load within 30 sec you will get TimeOutException.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//tell driver to wait for the element before throwing NoSuchElementException
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("wrongName")).sendKeys("iphone");
		driver.quit();
	}

}

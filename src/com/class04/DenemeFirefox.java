package com.class04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DenemeFirefox {

	public static void main(String[] args) {
		// Do a quick test to make sure you are able to open the firefox browser and able to go to google.
		//See below for how to invoke/open firefox.
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com/");
		driver.close();
		
//recap:
		// if you need to get the value of any attribute 
		//you can use method .getAttribute(“attributeName”);
		//getAttribute(String att);
		// <div id=“logInPanelHeading”>LOGIN Panel</div>
		
//		lets say you want to get the value of id attribute
//		so you you will say .getAttribute(“id”);
//		you will get logInPanelHeading
		
		
		//findElements();
		//this method will return list of elements
	}

}

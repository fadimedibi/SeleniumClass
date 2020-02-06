package com.SeleniumStudyMySelf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesGuru99Example {

	public static void main(String[] args) {
		System.setProperty("chrome", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().fullscreen();
		
		
		
	}

}

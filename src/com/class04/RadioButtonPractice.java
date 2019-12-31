package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RadioButtonPractice extends CommonMethods {
	public static void main(String[] args) {
		
	

	//TC 2: Radio Buttons Practice  
//	Open chrome browser
//	Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
//	Click on “Input Forms” links
//	Click on “Radio Buttons Demo” links
//	Click on any radio button in “Radio Button Demo” section.
//	Verify correct checkbox is clicked
//	Click on any radio button in “Group Radio Buttons Demo” section.
//	Verify correct checkbox is clicked
//	Quit browser

	
	// Opening the browser with url
//	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
	// Opening the browser with url
	CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
	driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
	driver.findElement(By.linkText("Radio Buttons Demo")).click();
	WebElement malebtn=driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));
	malebtn.click();
	System.out.println(malebtn.isSelected());
	WebElement age15_50=driver.findElement(By.xpath("//input[@name='ageGroup' and @value='15 - 50']"));
	age15_50.click();
	System.out.println(age15_50.isSelected());
	
	driver.close();
	}
}

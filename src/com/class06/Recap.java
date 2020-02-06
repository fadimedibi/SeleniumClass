package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Recap extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
	setUp("chrome" , "http://www.toolsqa.com/automation-practice-form/");
	driver.manage().window().fullscreen();
	Thread.sleep(3000);
	
	//handle 1 radio or checkbox
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	
	
	//handle group of radio or check boxes
	List<WebElement> allChBoxes=driver.findElements(By.xpath("//input[@name='tool']"));
	
	//if we want to click all the elements:
			for (WebElement el:allChBoxes) {
				String text=el.getAttribute("value");
				System.out.println("Text from a checkbox----"+ text);
				el.click();
				Thread.sleep(1000);
			}
	
			
			////if we want to click only one of the elements:
//	for(WebElement el:allChBoxes) {
//
//		String text=el.getAttribute("value");
//		if(text.equals("Selenium IDE")) {
//			el.click();
//			break;
//		}
//	}
//
//	Thread.sleep(3000);
//	driver.quit();
	
	}

}

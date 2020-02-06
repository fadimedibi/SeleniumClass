package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TaskScreenshotAndCalender extends CommonMethods {
/*
 * TC 1: Table headers and rows verification
Open chrome browser
Go to “https://www.aa.com/homePage.do”
Enter From and To
Select departure as May 14 of 2020
Select arrival as November 8 of 2020
Verify “Choose flights” text is displayed
Take s screenshot of the results
Close browser
 */
	public static void main(String[] args) {

		setUp("chrome", "https://www.aa.com/homePage.do");
		

		
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("MEM");
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("VPS");

		driver.findElement(By.id("aa-leavingOn")).click();
	//	driver.findElement(By.className("ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left"));
		
			String depDate="May 2020";
		
		boolean found=false;
		while(!found) {
			WebElement title= driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//div"));
			String titleText=title.getAttribute("value");
			if(titleText.contains(depDate)) {
				found=true;
			//	title.click();
				driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//div"));
				break;
			}
			
		}
	driver.findElement(By.xpath("//a[@title='Next']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		

	}

}

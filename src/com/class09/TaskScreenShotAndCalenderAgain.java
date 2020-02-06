package com.class09;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TaskScreenShotAndCalenderAgain extends CommonMethods {
	/*
	 * TC 1: Table headers and rows verification Open chrome browser Go to
	 * “https://www.aa.com/homePage.do” Enter From and To Select departure as May 14
	 * of 2020 Select arrival as November 8 of 2020 Verify “Choose flights” text is
	 * displayed Take s screenshot of the results Close browser
	 */
	public static void main(String[] args) {

		setUp("chrome", "https://www.aa.com/homePage.do");

		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("MEM");
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("VPS");

		driver.findElement(By.id("aa-leavingOn")).click();
//selecting deperature date

		boolean foundDep = false;
		while (!foundDep) {
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println(month);
			if (month.equals("May")) {

				List<WebElement> days = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

				for (WebElement cell : days) {
					if (cell.getText().equals("14")) {
						cell.click();
						foundDep = true;
						break;
					}
				}

			} else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}

		}

		// selecting returning date

		driver.findElement(By.id("aa-returningFrom")).click();
		boolean foundRet = false;
		while (!foundRet) {
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if (month.equals("November")) {

				List<WebElement> days = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

				for (WebElement cell : days) {
					if (cell.getText().equals("8")) {
						cell.click();
						foundRet = true;
						break;
					}
				}

			} else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}

		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/AA/HeadersRowsVerifiying2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// submitting search button
		driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

//		// verifying Choose Flights Text
//		boolean isDisplay = driver.findElement(By.id("chooseFlightsHeader")).isDisplayed();
//
//		if (isDisplay) {
//			String DisplayedText = driver.findElement(By.id("aa-pageTitle")).getAttribute("value");
//			System.out.println(DisplayedText + " is displayed");
//		} else {
//			System.out.println("Something went wrong!");
//		}

		driver.quit();

	}
}

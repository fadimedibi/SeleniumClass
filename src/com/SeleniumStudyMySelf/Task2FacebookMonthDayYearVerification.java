package com.SeleniumStudyMySelf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class Task2FacebookMonthDayYearVerification extends CommonMethods {

	public static void main(String[] args) {
		/*
		 * TC 1: Facebook dropdown verification 1.Open chrome browser 2.Go to
		 * “https://www.facebook.com” 3.Verify:●month dd has 12 month options●day dd has
		 * 31 day options●year dd has 115 year options 4.Select your date of birth
		 * 5.Quit browser
		 */
		// Open chrome browser Go to “https://www.facebook.com”
		CommonMethods.setUp("chrome", "https://www.facebook.com");
		WebElement months = driver.findElement(By.id("month"));

		// Verify:●month dd has 12 month options
		Select select = new Select(months);

		List<WebElement> optionMonth = select.getOptions();
		System.out.println("Number of Months options= " + optionMonth.size());

		for (WebElement monthOfFace : optionMonth) {
			System.out.println(monthOfFace.getText());
		}

		// day dd has 31 day options
		WebElement days = driver.findElement(By.id("day"));

		Select select1 = new Select(days);
		List<WebElement> optionDays = select1.getOptions();
		System.out.println("Number of days options= " + optionDays.size());

		for (WebElement dayOfFace : optionDays) {
			System.out.println(dayOfFace.getText());
		}
		// year dd has 115 year options
		WebElement years = driver.findElement(By.id("year"));
		Select select2 = new Select(years);

		List<WebElement> optionYears = select2.getOptions();
		System.out.println("Number of Years= " + optionYears.size());

		for (WebElement yearsOfFace : optionYears) {
			System.out.println(yearsOfFace.getText());
		}

		// Select your date of birth
		select.selectByVisibleText("Mar");
		select1.selectByVisibleText("3");
		select2.selectByVisibleText("1981");

		// verifying the entered birth date
		if (months.getAttribute("value").equals("3") && days.getAttribute("value").equals("3")
				&& years.getAttribute("value").equals("1981")) {
			System.out.println("Correct Birth date entered");

		} else {
			System.out.println("Incorrect Birth date entered ");
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/Facebook/MonthDayYearVerification.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}

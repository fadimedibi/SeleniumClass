package com.class08;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class CalenderTask extends CommonMethods {
	/*
	 * TC 1: Leave List Search Validation
	 * 
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” Login into
	 * the application Select Leave List Select from December 1, 2019 until January
	 * 31, 2020 Check only Pending approval Click on Search Validate “No Records
	 * Found” is displayed Quit the browser
	 */
	public static void main(String[] args) throws InterruptedException {
		// initializing webdriver, and navigating to the web page by Using setUp method
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");

		// entering username by using id locator
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		// entering password by using id locator
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		// clicking login button with using id locator
		driver.findElement(By.id("btnLogin")).click();

		// Select Leave
		Thread.sleep(4000);
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		// Select Leave List
		Thread.sleep(4000);
		driver.findElement(By.id("menu_leave_viewLeaveList")).click();

		// FROM calender table
		driver.findElement(By.id("calFromDate")).click();
		// driver.findElement(By.className("ui-datepicker-calendar")).click();

		// Selecting Month of Dec
		Select select = new Select(driver.findElement(By.className("ui-datepicker-month")));
		select.selectByVisibleText("Dec");

		// Selecting Year 2019
		Select select1 = new Select(driver.findElement(By.className("ui-datepicker-year")));
		select1.selectByVisibleText("2019");

		// selecting day 1
		// table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7] //xpath for day 1

		List<WebElement> cellsOfFromDays = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell : cellsOfFromDays) {
			if (cell.getText().equals("1")) {
				cell.click();
				break;
			}
		}
		// TO calender table
		driver.findElement(By.id("calToDate")).click();

		// Selecting Month of Jan
		Select select2 = new Select(driver.findElement(By.className("ui-datepicker-month")));
		select2.selectByVisibleText("Jan");

		// Selecting Year 2020
		Select select3 = new Select(driver.findElement(By.className("ui-datepicker-year")));
		select3.selectByVisibleText("2020");

		// selecting day 31
		// //table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[5] //day of 31
		List<WebElement> cellsOfToDays = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for (WebElement cell : cellsOfToDays) {
			if (cell.getText().equals("31")) {
				cell.click();
				break;
			}
		}
		// Checking only Pending approval
		boolean isSelectedPending = driver.findElement(By.id("leaveList_chkSearchFilter_1")).isSelected();
		if (isSelectedPending) {
			System.out.println("Pending approval selected by default");
		} else {
			driver.findElement(By.xpath("//label[text()='Pending Approval']")).click();
			System.out.println("Pending approval selected");
		}
			// Clicking on Search button
		driver.findElement(By.id("btnSearch")).click();

		// Validating “No Records Found” is displayed
		// //td[text()='No Records Found']
		// //table[@id='resultTable']/tbody/tr/td

		WebElement result = driver.findElement(By.xpath("//td[text()='No Records Found']"));
		String resultText = result.getText();
		if (resultText.equals("No Records Found")) {
			System.out.println("No results found displayed");
		} else {
			System.out.println(resultText + " is displayed");
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/HMRS/CalenderNoRecordsFound.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}

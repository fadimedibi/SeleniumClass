package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task extends CommonMethods {
	/*
	 * TC 1: Table headers and rows verification
	 * 
	 * Open chrome browser Go to “http://166.62.36.207/syntaxpractice/” Click on
	 * “Table” link Click on “ITable Data Search” link Verify second table consist
	 * of 4 rows and 5 columns Print name of all column headers Print data of all
	 * rows Quit Browser
	 */
	public static void main(String[] args) {

		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);

		// navigate to the table we need

		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		driver.findElement(By.className("table")).click();
		// get number of columns from the table
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));

		System.out.println("Number of columns" + cols.size());
		System.out.println("Printing column headers");
		for (WebElement col : cols) {
			System.out.println(col.getText());
		}
		// get number of rows from the table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));

		System.out.println("number of rows " + rows.size());
		System.out.println("printing rows data");
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

		System.out.println("Printing data cell by cell with advanced loop----------------------");

		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));

		for (WebElement cell : cells) {
			String cellData = cell.getText();
			System.out.println(cellData);
		}

		System.out.println("Printing data cell by cell with for loop----------------------");

		for (int i = 1; i <= rows.size(); i++) {// controlling rows
			for (int j = 1; j <= cols.size(); j++) {// controlling cols
				String cellText = driver
						.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[" + j + "]")).getText();
				System.out.println(cellText);

			}
		}

		driver.quit();
	}
}

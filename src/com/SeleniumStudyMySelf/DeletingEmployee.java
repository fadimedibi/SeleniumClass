package com.SeleniumStudyMySelf;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class DeletingEmployee extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(5000);

//	      WebDriverWait wait1 = new WebDriverWait(driver, 30);
//			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));

		// clicking PIM button to access Add Employee Option
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		// clicking Add Employee button
		driver.findElement(By.id("menu_pim_addEmployee")).click();

		// instantiating web elements and clicking (entering inputs)
		driver.findElement(By.id("firstName")).sendKeys("Beni Bu Havalar");
		driver.findElement(By.id("lastName")).sendKeys("Mahvetti");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);

		// Verify Employee has been added
		// storing entered values
		String enteredFName = "Beni Bu Havalar";
		String enteredLName = "Mahvetti";
		Thread.sleep(5000);
		String actualFName = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
		String actualLName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
		String employeeId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");

		if (actualFName.equals(enteredFName) && (actualLName.equals(enteredLName))) {
			System.out.println("Employeee with id # " + employeeId + " " + enteredFName + " " + enteredLName
					+ " has been added successfuly");
		} else {
			System.out.println("Add Employee Failed");
		}

		// navigating to Employee List
		driver.findElement(By.linkText("Employee List")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i = 1; i < rows.size(); i++) {
			String rowsText = rows.get(i - 1).getText();
			if (rowsText.contains(employeeId)) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
				Thread.sleep(4000);
				driver.findElement(By.id("btnDelete")).click();
				driver.findElement(By.id("dialogDeleteBtn")).click();
				System.out.println("Employeee with id # " + employeeId + " has been sucessfully deleted");
				break;
				
			} else {
				if (i == rows.size() - 1) {
					driver.findElement(By.xpath("//a[text()='Next']")).click();
					i = 1;
					rows.clear();
					rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

				}

			}
		}

	
		
		Thread.sleep(3000);
		driver.quit();

//				// Reaching Welcome Button by using PartialLinkText
//					driver.findElement(By.partialLinkText("Welcome")).click();
////					//Just in Case....
//				WebDriverWait wait2=new WebDriverWait(driver,20);
//					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
//					
//				
//					
//					// Logging out
//					 driver.findElement(By.linkText("Logout")).click();

	}
}

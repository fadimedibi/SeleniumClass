package com.class08;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TaskDeleteEmployee extends CommonMethods{
	/*
	 * TC 1: Delete Employee
	 * 
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” Login into
	 * the application Add Employee Verify Employee has been added Go to Employee
	 * List Delete added Employee Quit the browser
	 */
	public static void main(String[] args) throws InterruptedException {

	//  declaration and instantiation of objects/variables
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// navigating to the web page
			driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
			// entering username by using id locator
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			// entering password by using id locator
			driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
			// clicking login button with using id locator
			driver.findElement(By.id("btnLogin")).click();
			
			WebDriverWait wait1=new WebDriverWait(driver,20);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
			
			// clicking PIM button to access Add Employee Option
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			// clicking Add Employee button
			driver.findElement(By.id("menu_pim_addEmployee")).click();
			//instantiating web elements and clicking (entering inputs)
			driver.findElement(By.id("firstName")).sendKeys("Off");
			driver.findElement(By.id("lastName")).sendKeys("Be");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
			//Verify Employee has been added
			
			//storing entered values
			String enteredFName="Off";
			String enteredLName="Be";
			Thread.sleep(5000);
			String actualFName=driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
			String actualLName=driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
			String employeeId=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
			
			
			if(actualFName.equals(enteredFName)&& (actualLName.equals(enteredLName))){
				System.out.println("Employeee with id # "+employeeId+ " "+ enteredFName+ " "+enteredLName+ " has been added successfuly");
			}else {
				System.out.println("Add Employee Failed");
			}
			
			//navigating to Employee List
			driver.findElement(By.linkText("Employee List")).click();
			
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for(int i=1; i<rows.size();i++) {
			String rowsText=rows.get(i-1).getText();
			if(rowsText.contains(employeeId)) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		System.out.println("Employeee with id # "+employeeId+ " has been sucessfully deleted");
		

		
		// Reaching Welcome Button by using PartialLinkText
			driver.findElement(By.partialLinkText("Welcome")).click();
//			//Just in Case....
		WebDriverWait wait2=new WebDriverWait(driver,20);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
			
		
			
			// Logging out
			 driver.findElement(By.linkText("Logout")).click();
			
		
		
	}

}

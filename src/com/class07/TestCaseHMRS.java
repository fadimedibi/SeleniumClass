package com.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseHMRS {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Add Employee Open chrome browser Go to
		 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” Login into
		 * the application Add Employee Log out Quit the browser
		 */
		
	
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
		driver.findElement(By.id("firstName")).sendKeys("Canima");
		driver.findElement(By.id("lastName")).sendKeys("TakEttiArtik)");
		driver.findElement(By.id("btnSave")).click();
		//Just in Case....
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Personal Details")));
		// Reaching Welcome Button by using PartialLinkText
		driver.findElement(By.partialLinkText("Welcome")).click();
		//Just in Case....
		WebDriverWait wait2=new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		// Logging out
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(2000);
		//Quitting the browser
		driver.quit();
	}

}

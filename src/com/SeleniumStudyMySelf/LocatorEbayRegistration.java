package com.SeleniumStudyMySelf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorEbayRegistration {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");

		driver.findElement(By.name("firstname")).sendKeys("Captain");
		driver.findElement(By.id("lastname")).sendKeys("America");
		driver.findElement(By.id("address1")).sendKeys("123 White House");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Memphis");

		WebElement elementState = driver.findElement(By.id("state"));
		Select select = new Select(elementState);
		select.selectByVisibleText("Tennessee");

		driver.findElement(By.cssSelector("#zip")).sendKeys("38125");
		driver.findElement(By.id("dayphone1")).sendKeys("901");
		driver.findElement(By.id("dayphone2")).sendKeys("610");
		driver.findElement(By.id("dayphone3")).sendKeys("7089");
		driver.findElement(By.id("dayphone4")).sendKeys("109");
		driver.findElement(By.id("email")).sendKeys("captainameric@hotmail.com");
		driver.findElement(By.xpath("//input[@name='retype_email' and @id='retype_email']"))
				.sendKeys("captainameric@hotmail.com");
		driver.findElement(By.id("userid")).sendKeys("capamer2020");
		driver.findElement(By.cssSelector("#PASSWORD")).sendKeys("cap@7890");
		driver.findElement(By.cssSelector("#rpass")).sendKeys("cap@7890");

		WebElement elementScrQ = driver.findElement(By.id("SECRET_QUESTION"));
		Select select1 = new Select(elementScrQ);
		select1.selectByValue("3");

		driver.findElement(By.xpath("//input[@id='SECRET_ANSWER']")).sendKeys("Sirintepe");
		WebElement elementBrtMonth = driver.findElement(By.id("birthdate2"));
		Select select2 = new Select(elementBrtMonth);
		select2.selectByVisibleText("July");

		WebElement elementBrtDay = driver.findElement(By.id("birthdate1"));
		Select select3 = new Select(elementBrtDay);
		select3.selectByVisibleText("04");

		WebElement elementBrtYear = driver.findElement(By.id("birthdate3"));
		Select select4 = new Select(elementBrtYear);
		select4.selectByVisibleText("1990");

		driver.findElement(By.cssSelector("#acceptq1")).click();
		driver.findElement(By.xpath("//span[text()='Continue']")).click();

		driver.quit();
	}

}

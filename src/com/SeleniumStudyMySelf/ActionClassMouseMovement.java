package com.SeleniumStudyMySelf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class ActionClassMouseMovement extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("menulink"))).build().perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Articles']")).click();
		// driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Articles']")).click();
	//	driver.close();
		driver.navigate().to("https://www.makemytrip.com/");
		
		Actions action1=new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//li[@data-cy='menu_More']"))).build().perform();
		driver.findElement(By.xpath("//li[@data-cy='menu_More']//div//a[@data-cy='submenu_InternationalHotels']")).click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/Random/MouseMovement.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
		driver.quit();

	}

}

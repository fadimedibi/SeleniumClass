package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;

public class HwFileUpload extends CommonMethods {
	/*
	 * 
	 * TC 1: Upload file and Take Screenshot
	 * 
	 * Navigate to
	 * “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
	 * Upload file Verify file got successfully uploaded and take screenshot
	 * 
	 */
	public static void main(String[] args) {

		setUp("chrome", "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");

		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys("C:\\Users\\murat\\Desktop/foto1.jpg");

		driver.findElement(By.xpath("//button[text()='Upload File']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/Random/foto.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		driver.quit();

	}

}

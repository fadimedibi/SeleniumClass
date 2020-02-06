package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*
 * 
 */
public class FileUpload extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "https://the-internet.herokuapp.com/upload");

//		for MAC use /
//		for Windows use\\ or /
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\murat\\Desktop/FileForPractice.docx");

		//		clicking upload button
		Thread.sleep(3000);
		driver.findElement(By.id("file-submit")).click();
		
		Thread.sleep(3000);
		WebElement uploaded = driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		
		if (uploaded.isDisplayed()) {
			System.out.println("File successfully uploaded");
		} else {
			System.out.println("File is not uploaded");
		}

		driver.quit();
	}

}

package com.SeleniumStudyMySelf;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultiWindowsHandleAutomationDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://demo.automationtesting.in/Windows.html");

		driver.manage().window().fullscreen();

		String parent = driver.getWindowHandle();
		System.out.println("Title of the parent window= " + driver.getTitle());

		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();

		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();

		Set<String> allIds = driver.getWindowHandles();
		System.out.println("Size of the windows " + allIds.size());

			//with Iterator
//		Iterator<String> it = allIds.iterator();
//		while (it.hasNext()) {
//
//			String child = it.next();
//
//			if (!child.equals(parent)) {
//				driver.switchTo().window(child);
//				Thread.sleep(2000);
//				System.out.println("Child id " + driver.getTitle());
//				driver.close();
//				driver.switchTo().window(parent);
//
//			}
//
//		}

		//with for loop
		for (String ids : allIds) {
			driver.switchTo().window(ids);
			System.out.println(driver.getTitle());
		}
		Thread.sleep(2000);
		driver.quit();
	}
}

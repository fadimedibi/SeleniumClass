package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultiWindowDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// The method is opening Syntax Practice Website using chrome browser
		CommonMethods.setUp("chrome", "https://accounts.google.com/signup");
		
		Thread.sleep(2000);
		System.out.println("Title of the main Window: " + driver.getTitle());

		driver.findElement(By.linkText("Help")).click();

		// to get ID s of each windows, we use getWindowHandles();
		Set<String> allWindowsID= driver.getWindowHandles();
		System.out.println("How many windows currently opened: "+allWindowsID.size());
		
	Iterator<String>	it= allWindowsID.iterator();
	String parentW=it.next();
	String childW= it.next();
	
	System.out.println("Parent Id"+parentW);
	System.out.println("Child Id"+childW);
	
	driver.switchTo().window(childW);
	System.out.println("Title of the child Window: "+driver.getTitle());
//	driver.findElement(By.xpath("))
	
	
	
	//	driver.switchTo().window(nameOrHandle);

	}
}

package com.class06;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class RecapMultipleWindows extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");

		driver.findElement(By.linkText("Follow On Instagram")).click();
	
	// 	1st. get Window Handles()
	//	identify parent &child
	//	switch
		
		Set<String> allWindows=driver.getWindowHandles();
	
	Iterator<String> stringIterator= allWindows.iterator();
	String parent=stringIterator.next();
	String child=stringIterator.next();
	
	driver.switchTo().window(child);
	String childTitle=driver.getTitle();
	System.out.println(childTitle);
	
	driver.switchTo().window(parent);
	String parentTitle=driver.getTitle();
	System.out.println(parentTitle);
	
		Thread.sleep(3000);
		driver.quit();
		
	
	}

}

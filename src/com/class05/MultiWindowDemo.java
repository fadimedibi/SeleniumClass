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
	
		//Get the title of parent window
		System.out.println("Title of the main Window: " + driver.getTitle());

		// find the element with link Help and Click on it
		driver.findElement(By.linkText("Help")).click();

		// to get ID s of each windows, we use getWindowHandles();
		Set<String> allWindowsID= driver.getWindowHandles();
		
		//How many windows are opened
		System.out.println("How many windows currently opened: "+allWindowsID.size());
	
		//To get each id from the iterator above, we use iterator
	Iterator<String>	it= allWindowsID.iterator();
	
	//get the first id
	String parentW=it.next();
	
	//get the second id
	String childW= it.next();
	
	//printing parent id
	System.out.println("Parent Id"+parentW);
	
	//printing child id
	System.out.println("Child Id"+childW);
	
	//switch to child window
	driver.switchTo().window(childW);
	
	//get the title of child window and print it
	System.out.println("Title of the child Window: "+driver.getTitle());
	
	//send text to text box in child window
			driver.findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).sendKeys("Window practice");

			
			Thread.sleep(4000);

			//close current window and all other associated windows with it
			driver.quit();
//	driver.findElement(By.xpath(""))
	
	
	
	//	driver.switchTo().window(nameOrHandle);

	}
}

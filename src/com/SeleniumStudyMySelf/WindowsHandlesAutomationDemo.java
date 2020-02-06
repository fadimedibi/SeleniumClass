package com.SeleniumStudyMySelf;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class WindowsHandlesAutomationDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","http://demo.automationtesting.in/Windows.html");
	
	//	driver.manage().window().fullscreen();
		
		System.out.println("Title of the main window= "+driver.getTitle());
		
//	driver.findElement(By.xpath("//a[@href='#Tabbed']")).click();
//	WebElement tabbedWindowButton=driver.findElement(By.xpath("//*[@id='Tabbed']"));
		
		
		
	WebElement tabbedWindowButton=driver.findElement(By.xpath("//*[@id='Tabbed']/a/button"));
	tabbedWindowButton.click();
	
	Thread.sleep(5000);
	
	Set<String> windowIds= driver.getWindowHandles();
	
	Iterator<String> it= windowIds.iterator();
	while(it.hasNext()) {
		String mainWindow=	it.next();
		String child=it.next();
		driver.switchTo().window(child);	
		System.out.println("Title of the child window= "+driver.getTitle());
		driver.switchTo().window(mainWindow);
	System.out.println("current window "+ driver.getTitle());
	}
	
	
	
	
	
//	String mainWindow=	it.next();
//	String childWindow=it.next();
//	
//	driver.switchTo().window(childWindow);
//	System.out.println("Title of the child window= "+driver.getTitle());
//	
//	driver.close();
//	
//	driver.switchTo().window(mainWindow);	
//	System.out.println("Title of the main window= "+driver.getTitle());
	
//	driver.close();
	
	
	
	
	}

}

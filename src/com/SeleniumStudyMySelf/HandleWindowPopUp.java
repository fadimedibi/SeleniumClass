package com.SeleniumStudyMySelf;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://popuptest.com/goodpopups.html");

		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();

		Set<String> handler = driver.getWindowHandles();

		System.out.println("opened windows " + handler.size());

		Iterator<String> it = handler.iterator();
		
		String parentWindowId= it.next(); //This will give us the first id---parent window id
		System.out.println("parent window id: "+ parentWindowId); 
		
		String childWindowId= it.next();
		System.out.println("child window id: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("child window pop up title: "+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window pop up title: "+driver.getTitle());
	}

}

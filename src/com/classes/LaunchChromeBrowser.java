package com.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	

		    public static void main(String[] args) {
		    	System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\murat\\eclipse-workspace\\SeleniumClass\\drivers\\chromedriver.exe");
     ChromeDriver driver = new ChromeDriver();
		        
		        
		        driver.get("https://www.google.com");         // it will not store the history. Can't go back
		        try {
		            Thread.sleep(2000);
		            }catch(InterruptedException e) {
		                System.out.println("interrupted");
		            }
		        
		        driver.navigate().to("https://www.amazon.com");   // it will store the history. Can go back and forward
		        try {
		            Thread.sleep(2000);
		            }catch(InterruptedException e) {
		                System.out.println("interrupted");
		            }
		        
		        
		        driver.navigate().back();
		        try {
		            Thread.sleep(2000);
		            }catch(InterruptedException e) {
		                System.out.println("interrupted");
		            }
		        driver.navigate().forward();
		    
		        driver.navigate().back();
		        
		        final String expectedTitle = "Google";
		        String actualTitle = driver.getTitle();
		        
		        if(expectedTitle.equals(actualTitle)) {
		            System.out.println("I am on the right page");
		        }
		        else {
		            System.out.println("The titles do not match");
		        }
		        
		        driver.findElement(By.name("q")).sendKeys("Elon Musk");
		        try {
		            Thread.sleep(2000);
		            }catch(InterruptedException e) {
		                System.out.println("interrupted");
		            }
		        driver.findElement(By.name("btnK")).click();  
		        try {
		            Thread.sleep(2000);
		            }catch(InterruptedException e) {
		                System.out.println("interrupted");
		            }
		        
		        
		        
		        driver.close();
		        
		    }
		}
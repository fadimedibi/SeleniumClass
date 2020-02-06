package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class CalenderDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
	
		setUp("chrome","http://166.62.36.207/humanresources/symfony/web/index.php/auth");
	    driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	    driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
	    driver.findElement(By.cssSelector("input#btnLogin")).submit();
	
	    
	    driver.findElement(By.linkText("Leave")).click();
	    driver.findElement(By.linkText("Leave List")).click();
	    
	    
	    //Step 1: click on calender
	    driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
	    //step 2: get all cells
	   List<WebElement> cells= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	    
	    for (WebElement cell:cells) {
	    	//retrieve text
	    	if(cell.getText().equals("16")) {
	    		cell.click();
	    		break;
	    	}
	    }
	    Thread.sleep(4000);
	    driver.quit();
	    
	    
	}
	
	
	
}

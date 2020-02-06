package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*/* Navigate to the WebOrders
 * login into WebOrders
 * click checkbox next to Bob Feather
 */
public class DynamicTableDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(2000);
//search for Bob feather

		// driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector")).click();
		// //it's dynamic, when we delete some elements it won't work
		String expectedValue = "Bob Feather";
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for(int i=0; i<rows.size(); i++) {
			String rowText= rows.get(i).getText();
		//	System.out.println(rowText);
			
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+1)+"]/td[1]")).click();
			}
		}

//		// using for loop
//		for (WebElement row : rows) {
//			if (row.getText().contains("Bob Feather")) {
//				row.findElement(By.tagName("input")).click();
//			}
//
//		}
		
		driver.quit();
	}

}

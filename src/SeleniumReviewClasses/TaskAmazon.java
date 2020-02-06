package SeleniumReviewClasses;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TaskAmazon extends CommonMethods{

	public static void main(String[] args) {
		
		setUp("chrome", Constants.AMAZON);
		
		switchToframe(driver.findElement(By.xpath("//div[@id='ape_Gateway_right-2_desktop_placement']/iframe")));
		/*
		 * xpath to locate frame
		 * div[@id='ape_Gateway_right-2_desktop_placement']/iframe
		 */
		driver.findElement(By.className("clickthrough")).click();

	}

}

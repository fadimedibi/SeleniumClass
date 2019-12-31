package SeleniumReviewClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task2 extends CommonMethods {
	/*
	 * On your own, you will do exactly what I did As an analyst, I want to be able
	 * to verify that when clicking on checkboxes, the first link is clickable and
	 * the second checkbox is already checked by default
	 */
	public static void main(String[] args) {
		// getting url with chrome driver
		setUp("chrome", Constants.WelcomeToTheInternetUrl);
		
		// using LinkText
		driver.findElement(By.linkText("Checkboxes")).click();
		
		// clicking 1st checkBox
		WebElement chkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		chkBox1.click();
		
		//controlling if checkbox1 is clickable
		if (chkBox1.isSelected()) {
			System.out.println("CheckBox 1 is clickable");
		} else {
			System.err.println("CheckBox 1 is not clickable");
		}
		
		// controlling if checkbox2 is default clicked
		WebElement chkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		if (chkBox2.isSelected()) {
			System.out.println("CheckBox 2 is clicked by default");
		} else {
			System.err.println("CheckBox 2 IS NOT clicked default");
		}
	}

}

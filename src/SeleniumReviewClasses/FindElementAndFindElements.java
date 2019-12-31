package SeleniumReviewClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class FindElementAndFindElements extends CommonMethods {

	public static void main(String[] args) {
		
		setUp("chrome", Constants.WelcomeToTheInternetUrl);
		
	//	driver.findElement(By.linkText("Checkboxes")).click();
		
	//	driver.findElements(By.linkText("Checkboxe")).click(); //does not give an exception since it is a WebElement list
		
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		
		int numberOfLinks=allLinks.size();
		System.out.println(numberOfLinks);
		
		//next step is to get the text and hiperlinks of all links on the web page
		for (WebElement link : allLinks) {
			System.out.println(link.getText()+" = " + link.getAttribute("href"));
		}
		
		driver.quit();
		
	}

}

	//We started getting url with chrome driver
	//and we created a list of WebElement named allLinks.
	//We used tag name locator to find the elements that has links
	//Then we printed the size of the links. 
	//to iterate to get all the  visible text and the value of attribute(href), we used getAttribute() and getText() methods  

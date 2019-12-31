package SeleniumReviewClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task3 extends CommonMethods {
/*As a BA, I want to be able to confirm that there are 45 links on the “Welcome to the Internet” home page
As a BA, I want to be able to verify that the text to each hyperlink and match each hyperlink with the respective
text
Note for testers: Please write clean code and comment on each line of code what is the function being performed so that
our client side members can read your code and understand what is going on */
	

		public static void main(String[] args) {
			
			setUp("chrome", Constants.WelcomeToTheInternetUrl);
			
			//creating a list of WebElement named allLinks:
			List<WebElement> allLinks= driver.findElements(By.tagName("a"));
			
			//printing the size of the links:
			int numberOfLinks=allLinks.size();
			
			//confirming that there are 45 links:
			if(numberOfLinks==45) {
			System.out.println("System has correct amount of links = "+ numberOfLinks);
			}else {
				System.out.println("Wrong number of links ");
			}
			
			//iterating  to get all the  visible text and the value of attribute(href)
			//printing each hyperlink with associated text
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

	
	

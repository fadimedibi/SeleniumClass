package SeleniumReviewClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task extends CommonMethods{

	public static void main(String[] args) {
		/*locate any link Using partialLinkText only then click on the link, after clicking go back to the home page and locate
another element using PartialLinkText only then click on the link*/
	
		//getting url with chrome driver
		setUp("chrome", Constants.WelcomeToTheInternetUrl);
		
		//using partialLink 
		driver.findElement(By.partialLinkText("Ad")).click();
		driver.navigate().back();
		//storing as WebElemnt with using partialLink 
		WebElement partial=driver.findElement(By.partialLinkText("Forgot Pass"));
		partial.click();
		
		
	}

}

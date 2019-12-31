package SeleniumReviewClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Locating extends CommonMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		setUp("chrome", Constants.WelcomeToTheInternetUrl);
		//PartialLinktext
//		driver.findElement(By.partialLinkText("Check")).click();   OR
		
		//PartialLinktext
//		WebElement partialLink = driver.findElement(By.partialLinkText("Check"));
//		partialLink.click();
		
		//linkText
//		driver.findElement(By.linkText("Dropdown")).click();
		
		driver.findElement(By.linkText("Checkboxes")).click();
		WebElement chkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		chkBox1.click();
		
		if(chkBox1.isSelected()) {
			System.out.println("CheckBox 1 was selected");
		}else {
			System.err.println("CheckBox 1 WAS NOT selected--please re-run");
		}
		
		

	}

}

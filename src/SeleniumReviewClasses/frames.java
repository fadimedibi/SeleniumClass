package SeleniumReviewClasses;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class frames  extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome", Constants.WelcomeToTheInternetUrl);
		
		driver.findElement(By.linkText("Frames")).click();
		
		driver.findElement(By.linkText("iFrame")).click();
		
		switchToframe("mce_0_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("I will get a job in a couple of months");
	}

}

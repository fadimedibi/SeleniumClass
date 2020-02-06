package SeleniumReviewClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Alert extends CommonMethods {

	public static void main(String[] args) {

		setUp("chrome", "https://www.toolsqa.com/automation-practice-switch-windows/");

//		driver.findElement(By.xpath("//button[@id='alert']")).click();
//		acceptAlert();

		driver.findElement(By.id("timingAlert")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		acceptAlert();
		driver.quit();

	}

}

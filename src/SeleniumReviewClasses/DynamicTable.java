package SeleniumReviewClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DynamicTable extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", Constants.HRMS_URL);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		// driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		// driver.findElement(By.xpath("//a[@id =
		// 'menu_recruitment_viewRecruitmentModule']/b")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int numberOfRows = rows.size();
		System.out.println(numberOfRows + " rows present");

		String firstHalfXpath = "//table[@id = 'resultTable']/tbody/tr[";
		String secondHalfXpath = "]/td[3]/a";

		for (int i = 1; i <= rows.size(); i++) {
			String name = driver.findElement(By.xpath(firstHalfXpath + i + secondHalfXpath)).getText();
			//System.out.println(name);

			if (name.contains("muhammad")) {
				driver.findElement(By.xpath(firstHalfXpath + i + secondHalfXpath)).click();
//			editing the candidate
				driver.findElement(By.id("btnSave")).click();
				driver.findElement(By.id("addCandidate_lastName")).clear();
				driver.findElement(By.id("addCandidate_lastName")).sendKeys("Smith");			
				driver.findElement(By.id("btnSave")).click();
				System.out.println("candidate "+ name + " is edited");
				break;
				
			} else {
				System.out.println("Text is not present");
			}
			
		
		}
	}

}

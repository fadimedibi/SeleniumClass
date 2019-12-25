package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class TaskSyntax {

	public static void main(String[] args) {
		/* TC 2: Syntax Page URL Verification: 
		Open chrome browser
		Navigate to “https://www.syntaxtechs.com/”
		Navigate to “https://www.google.com/”
		Navigate back to Syntax Technologies Page
		Refresh current page
		Verify url contains “Syntax”*/
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\murat\\eclipse-workspace\\SeleniumClass\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

driver.get("https://www.syntaxtechs.com/");
driver.navigate().to("https://www.google.com/");
driver.navigate().back();
driver.navigate().refresh();
String currentUrl=driver.getCurrentUrl();
if(currentUrl.contains("syntax")) {
	System.out.println("The URL contains\"syntax\"");
}else {
	System.out.println("The URL does not contains\"syntax\"");
}













        
	}

}

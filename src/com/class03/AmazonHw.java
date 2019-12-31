package com.class03;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHw {

	public static void main(String[] args) {
		// TC 1: Amazon link count:
		// 1.Open Chrome browser
		// 2.Go to “https://www.amazon.com/”
		// 3.Get all links
		// 4.Get number of links that has text
		// 5.Print to console only the links that has text

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("size of the list= " + links.size());
		ArrayList list = new ArrayList();
		for (WebElement amazonLinks : links) {
			String amazonAllLinks = amazonLinks.getText();

			if (!amazonAllLinks.isEmpty()) {
				list.add(amazonAllLinks);
				System.out.println(amazonAllLinks);

			}
		}
		System.out.println("Number of links that has text= " + list.size());
		driver.close();

	}

}

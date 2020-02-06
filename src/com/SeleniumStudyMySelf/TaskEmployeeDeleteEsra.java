package com.SeleniumStudyMySelf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TaskEmployeeDeleteEsra extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		
	
	  setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
      
      driver.findElement(By.id("txtUsername")).sendKeys("Admin");
      driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
      driver.findElement(By.id("btnLogin")).submit();
      
      Thread.sleep(5000);
      
      driver.findElement(By.id("menu_pim_viewPimModule")).click();
      //menu_pim_viewPimModule
      
      WebDriverWait wait = new WebDriverWait(driver,10);
      wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
      //menu_pim_addEmployee
          
      driver.findElement(By.id("menu_pim_addEmployee")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
      
      driver.findElement(By.id("firstName")).sendKeys("Deneme");
      driver.findElement(By.id("lastName")).sendKeys("Deneme12");
      driver.findElement(By.id("employeeId")).clear();
      driver.findElement(By.id("employeeId")).sendKeys("2021");
      driver.findElement(By.id("btnSave")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()= 'Personal Details']")));
      
      String id = "";
      
      if(driver.findElement(By.xpath("//h1[text()= 'Personal Details']")).isDisplayed()) {
          id = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
          System.out.println("The employee with id : " + id + " is added successfully.");
      }
      else {
          System.out.println("Failed to add employee.");
      }
      
      driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
      
      List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
      
      int i = 0;
      
      for(i = 0; i< rows.size(); i++) {
          WebElement row = rows.get(i);
          
          if(row.getText().contains("id")) {
           //   WebElement cb = driver.findElement(By.xpath("/table[@id='resultTable']/tbody/tr[\"+(i+1)+\"]/td[1]"));
              WebElement cb = row.findElement(By.tagName("input"));
              if(!cb.isSelected()) {
                  cb.click();
              }
              WebElement dlt = driver.findElement(By.id("btnDelete"));
              if(dlt.isEnabled()) {
                  dlt.click();
                  Thread.sleep(10000);
//                Alert alert = driver.switchTo().alert();
//                alert.accept();
                  driver.findElement(By.id("dialogDeleteBtn")).click();
                  System.out.println("Employee with id : "+id+" is successfully deleted.");
              }
              else {
                  System.out.println("Can not click on 'Delete' button.");
              }
              break;
          }
          else {
              if(i == rows.size()-1) {
                  driver.findElement(By.xpath("//a[text()='Next']")).click();
                  i = 0;
                  Thread.sleep(3000);
                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
                  //rows.clear();
                  rows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
              }
          }
      }
      
      
      Thread.sleep(3000);
      driver.quit();
      
  }

}

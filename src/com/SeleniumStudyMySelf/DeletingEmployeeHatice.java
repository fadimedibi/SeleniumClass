package com.SeleniumStudyMySelf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DeletingEmployeeHatice extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
	     setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth" );
	        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
	        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
	        driver.findElement(By.xpath("//input[@name='Submit']")).click();
	        WebDriverWait wait=new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
	        driver.findElement(By.id("menu_pim_viewPimModule")).click();
	        
	       
	        driver.findElement(By.linkText("Add Employee")).click();
	        
	        String firstName="Zuleyha";
	        driver.findElement(By.name("firstName")).sendKeys(firstName);
	        String laststName="Saliha";
	        driver.findElement(By.name("lastName")).sendKeys(laststName);
	        driver.findElement(By.xpath("//input[@value='Save']")).click();
	        
	        //find the added employee in the table and delete from the table
	        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	        
	        boolean is=false;
	        while(!is) {
	            List<WebElement> empList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
	            
	            for(int i=1; i<empList.size(); i++) {
	                WebElement employee=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]"));
	                String empName=employee.getText();
	                if(empName.contains(firstName)) {
	                    String empInfo=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]")).getText()+
	                                   driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[4]")).getText();
	                    System.out.println("Employee -->"+empInfo+" is in the table");
	                    //click the button of the added employee
	                    driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
	                    //delete the employee
	                    wait.until(ExpectedConditions.elementToBeClickable(By.id("btnDelete")));
	                    driver.findElement(By.id("btnDelete")).click();
	                    wait.until(ExpectedConditions.elementToBeClickable(By.id("dialogDeleteBtn")));
	                    driver.findElement(By.id("dialogDeleteBtn")).click();
	                    is=true;
	                    break;
	                }
	                
	            }
	            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Next")));
	            driver.findElement(By.linkText("Next")).click();
	        }
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")));
	        List<WebElement> newEmpList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
	        for(WebElement element:newEmpList) {
	            String empl=element.getText();
	            if(!empl.contains(firstName)) {
	                System.out.println("Employee "+firstName+" is deleted from the table");
	                break;
	            }else {
	                System.out.println("Employee "+firstName+" is not deleted from the table");
	            }
	        }
	    }
}

package Hrm.testpages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hrm.testutils.HRMBaseTest;

public class EmployeeListPage extends HRMBaseTest{
	public final static By pimXpath= By.xpath("//span[text()='PIM']");
	public final static By empList=By.linkText("Employee List");
	//public final static By findlist = 
			//By.xpath("//div[text()='First (& Middle) Name']//following::div[@class='data']");
	public final static By results=By.xpath("//span[@class='oxd-text oxd-text--span']");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public EmployeeListPage(WebDriver driver) {
		this.driver=driver;
	}

	public void pimNavigation() {
		driver.findElement(pimXpath).click();
				
	}
	public void navigateToEmpList() {
		wait.until(ExpectedConditions.elementToBeClickable(empList)).click();
	}
	
	public final static By targetDiv = By.xpath("//div[@class='orangehrm-container']");
	
	public final static By findlist = 
			By.xpath(".//div[text()='First (& Middle) Name']/following-sibling::div[@class='data']");
	
	public void getUserList() {
	    WebElement container = driver.findElement(targetDiv);
	    js.executeScript("arguments[0].scrollIntoView();", container);
	  
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner-container")));

	 List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'oxd-table-row')]/div[3]"));
	 System.out.println(rows.size());
	 Set<String> names = new LinkedHashSet<>();
	 for(WebElement e : rows) {
		
		 names.add(e.getText());
		 
	 }
	 System.out.println(names);
	}


	}

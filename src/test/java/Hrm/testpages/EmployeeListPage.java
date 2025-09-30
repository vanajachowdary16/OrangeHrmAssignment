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
	public final static By userDropDown=By.xpath("//p[@class='oxd-userdropdown-name']");
	public final static By logout= By.xpath("//a[text()='Logout']");
	
	
	//public final static By findlist = 
			//By.xpath("//div[text()='First (& Middle) Name']//following::div[@class='data']");
	public final static By results=By.xpath("//span[@class='oxd-text oxd-text--span']");
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public EmployeeListPage(WebDriver driver) {
		this.driver=driver;
	}

	public static void pimNavigation() {
		driver.findElement(pimXpath).click();
				
	}
	public static  void navigateToEmpList() {
		wait.until(ExpectedConditions.elementToBeClickable(empList)).click();
	}
	public static void clickUserDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(userDropDown)).click();
	}
	public static void clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}
	
	public static void logOut() {
		clickUserDropDown();
		clickLogout();
	}
	
	
	public final static By targetDiv = By.xpath("//div[@class='orangehrm-container']");
	
	public final static By findlist = 
			By.xpath(".//div[text()='First (& Middle) Name']/following-sibling::div[@class='data']");
	
	
	
	public static Set<String> getAllEmployeesFromUI() throws InterruptedException {
	    Set<String> employees = new LinkedHashSet<>();
	    boolean hasNextPage = true;

	    while (hasNextPage) {
	        List<WebElement> rows = driver.findElements(
	            By.xpath("//div[contains(@class,'oxd-table-row')]/div[3]")
	        );
	        for (WebElement row : rows) {
	            String name = row.getText().trim();
	            if (!name.equalsIgnoreCase("First (& Middle) Name") && !name.isEmpty()) {
	                employees.add(name);
	            }
	        }

	        // Check next page button
	        List<WebElement> nextBtns = driver.findElements(By.xpath("//button[@class='oxd-pagination-page-item oxd-pagination-next']"));
	        if (!nextBtns.isEmpty() && nextBtns.get(0).isEnabled()) {
	            nextBtns.get(0).click();
	            Thread.sleep(1000); // wait for new page load
	        } else {
	            hasNextPage = false;
	        }
	    }

	    return employees;
	}




	}

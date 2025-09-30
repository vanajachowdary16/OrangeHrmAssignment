package Hrm.testpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import Hrm.testutils.HRMBaseTest;

public class PIMPageObjects extends HRMBaseTest{
	
	public final static By pimXpath= By.xpath("//span[text()='PIM']");
	public final static By addEmp=By.linkText("Add Employee");
	public final static By firstNameLocator=By.name("firstName");
	public final static By middleNameLocator=By.name("middleName");
	public final static By lastNameLocator= By.name("lastName");
	public final static By exmplyeeID=By.xpath("//label[text()='Employee Id']/following::input[1]");
	public final static By saveButton = By.xpath("//button[normalize-space()='Save']");
	public final static By userdetailsPage=By.xpath("//a[text()='Personal Details']");
	
	
	
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public PIMPageObjects(WebDriver driver) {
	this.driver=driver;
	}
	
	public static void pimNavigation() {
		driver.findElement(pimXpath).click();
				
	}
	public static void addemp() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addEmp)).click();
	}
	public static void save() {
		
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();		
	}
	public static void seeDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(userdetailsPage)).click();	
		
	}
	
	public static void addEmployee(String Fname, String Mname, String Lname) {
		pimNavigation();
		addemp();
		driver.findElement(firstNameLocator).sendKeys(Fname);
		driver.findElement(middleNameLocator).sendKeys(Mname);
		driver.findElement(lastNameLocator).sendKeys(Lname);
		save();
		seeDetails();
		
	}
	

}

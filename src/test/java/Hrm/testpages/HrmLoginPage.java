package Hrm.testpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hrm.testutils.HRMBaseTest;

public class HrmLoginPage extends HRMBaseTest{
	
	public final static By userNameLocator = By.name("username");
	public final static By passwordLocator = By.name("password");
	public final static By loginBtn = By.xpath("//button[@type='submit']");
	public final static By pimXpath= By.xpath("//span[text()='PIM']");
	public final static By addEmp=By.linkText("Add Employee");
	public final static By firstNameLocator=By.name("firstName");
	public final static By middleNameLocator=By.name("middleName");
	public final static By lastNameLocator= By.name("lastName");
	public final static By exmplyeeID=By.xpath("//label[text()='Employee Id']/following::input[1]");
	public final static By saveButton = By.xpath("//button[normalize-space()='Save']");
	public final static By userdetailsPage=By.xpath("//a[text()='Personal Details']");
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	public HrmLoginPage(WebDriver driver) {
        this.driver = driver;
    }
	public void login(String uname, String pwd) {
		driver.findElement(userNameLocator).sendKeys(uname);
		 driver.findElement(passwordLocator).sendKeys(pwd);
		 driver.findElement(loginBtn).click();	    

	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public void pimNavigation() {
		driver.findElement(pimXpath).click();
				
	}
	public void addemp() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addEmp)).click();
	}
	public void save() {
		
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();		
	}
	public void seeDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(userdetailsPage)).click();	
		
	}
	public void addEmployee(String Fname, String Mname, String Lname) {
		//addemp();
		driver.findElement(firstNameLocator).sendKeys(Fname);
		driver.findElement(middleNameLocator).sendKeys(Mname);
		driver.findElement(lastNameLocator).sendKeys(Lname);
		driver.findElement(saveButton).click();
		//save();
	}
	

}

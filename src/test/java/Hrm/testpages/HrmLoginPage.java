package Hrm.testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Hrm.testutils.HRMBaseTest;

public class HrmLoginPage extends HRMBaseTest{
	
	public final static By userNameLocator = By.name("username");
	public final static By passwordLocator = By.name("password");
	public final static By loginBtn = By.xpath("//button[@type='submit']");
	
	
	
	public HrmLoginPage(WebDriver driver) {
        this.driver = driver;
    }
	public static void login(String uname, String pwd) {
		driver.findElement(userNameLocator).sendKeys(uname);
		 driver.findElement(passwordLocator).sendKeys(pwd);
		 driver.findElement(loginBtn).click();	    

	}
	public static String getTitle() {
		return driver.getTitle();
	}
	
	
	
	

}

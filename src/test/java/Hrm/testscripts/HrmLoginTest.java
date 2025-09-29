package Hrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Hrm.testpages.HrmLoginPage;
import Hrm.testutils.HRMBaseTest;

public class HrmLoginTest extends HRMBaseTest{
	HrmLoginPage loginpage;
	
	@BeforeClass
	public void setUp() {
		HRMBaseTest.LaunchBrowser();
		driver = HRMBaseTest.getDriver();
		loginpage= new HrmLoginPage(driver);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginPageTest() {
		loginpage.login("Admin", "admin123");
		Assert.assertEquals(loginpage.getTitle(), "OrangeHRM");
		
	}
	

}

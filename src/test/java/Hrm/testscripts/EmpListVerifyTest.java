package Hrm.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Hrm.testpages.EmployeeListPage;
import Hrm.testpages.HrmLoginPage;
import Hrm.testutils.HRMBaseTest;

public class EmpListVerifyTest extends HRMBaseTest{
	
	EmployeeListPage emplist;
	HrmLoginPage loginpage;

	@BeforeClass
	public void setUp() {
		HRMBaseTest.LaunchBrowser();
		driver = HRMBaseTest.getDriver();
		loginpage= new HrmLoginPage(driver);
		emplist= new EmployeeListPage(driver);
	
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyEmpList() {
		loginpage.login("Admin", "admin123");
		emplist.pimNavigation();
		emplist.navigateToEmpList();
		emplist.getUserList();
	}
	

}

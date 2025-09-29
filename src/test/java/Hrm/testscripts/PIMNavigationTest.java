package Hrm.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hrm.testpages.HrmLoginPage;
import Hrm.testutils.HRMBaseTest;

public class PIMNavigationTest extends HRMBaseTest{
	
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
	
	  @DataProvider(name = "employeeData")
	    public Object[][] getEmployeeData() {
	        return new Object[][] {
	            {"Vanu2", "Test3", "Automation"},
	            {"John2", "Doe2", "Developer"},
	            {"Jane2", "Smith2", "Tester2"}
	        };
	  }
	  
	  @Test
	  public void logintest() {
		  loginpage.login("Admin", "admin123");
			loginpage.pimNavigation();
	  }
	
	@Test(dataProvider = "employeeData", dependsOnMethods="logintest")
	public void addEmployee(String firstname, String middlename, String lastname) {	
		loginpage.addemp();
		loginpage.addEmployee(firstname, middlename, lastname);
		loginpage.save();
		loginpage.seeDetails();
	}
	

}

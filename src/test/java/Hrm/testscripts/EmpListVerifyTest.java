package Hrm.testscripts;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hrm.testpages.EmployeeListPage;
import Hrm.testpages.HrmLoginPage;
import Hrm.testpages.PIMPageObjects;
import Hrm.testutils.HRMBaseTest;

public class EmpListVerifyTest extends HRMBaseTest {


    @BeforeClass
    public void setUp() {
        HRMBaseTest.LaunchBrowser();
        driver = HRMBaseTest.getDriver();
        HrmLoginPage.login("Admin", "admin123");
    }
   /* @BeforeMethod
    public void loginSession() {
    	HrmLoginPage.login("Admin", "admin123");
    }
    @AfterMethod
    public void logoutSession() {
    	EmployeeListPage.logOut();
    }*/
    @AfterClass
    public void tearDown() {
    	EmployeeListPage.logOut();
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

    @Test(dataProvider = "employeeData")
    public void addEmployee(String firstname, String middlename, String lastname) {
    	
    	PIMPageObjects.addEmployee(firstname, middlename, lastname);
    	
    }

    @Test(dataProvider = "employeeData", dependsOnMethods = "addEmployee")
    public void validateEmployee(String firstname, String middlename, String lastname) throws InterruptedException {
    	PIMPageObjects.pimNavigation();
    	EmployeeListPage.navigateToEmpList();
        Set<String> employeesInUI = EmployeeListPage.getAllEmployeesFromUI();

        String expectedName = buildDisplayedName(firstname, middlename, lastname); 
        // ⚠ Adjust this method to match UI, e.g., first + middle only if last name is empty in UI

        Assert.assertTrue(
            employeesInUI.contains(expectedName),
            "Employee not found in UI list: " + expectedName + "\nAll Employees: " + employeesInUI
        );
    }

    private String buildDisplayedName(String first, String middle, String last) {
        StringBuilder name = new StringBuilder(first);
        if (middle != null && !middle.trim().isEmpty()) {
            name.append(" ").append(middle);
        }
        // Only append last name if your UI shows it
        // if (last != null && !last.trim().isEmpty()) {
        //     name.append(" ").append(last);
        // }
        return name.toString().trim();
    }

}

package Hrm.testscripts;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
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

    @AfterClass
    public void tearDown() {
        EmployeeListPage.logOut();
        driver.quit();
    }

    @DataProvider(name = "employeeData")
    public Object[][] getEmployeeData() {
        return new Object[][] {
            {"Vanu2", "Test3", "Automation"}
            
        };
    }

    @Test(dataProvider = "employeeData")
    public void addEmployee(String firstname, String middlename, String lastname) {
        PIMPageObjects.addEmployee(firstname, middlename, lastname);
    }

    @Test(dataProvider = "employeeData", dependsOnMethods = "addEmployee")
    public void validateEmployee(String firstname, String middlename, String lastname) throws InterruptedException {
        // Navigate to Employee List
        PIMPageObjects.pimNavigation();
        EmployeeListPage.navigateToEmpList();
        Set<String> employeesInUI = EmployeeListPage.getAllEmployeesFromUI();

        // Build expected display name
        String expectedName = buildDisplayedName(firstname, middlename, lastname);

        // Check and print message
        if (employeesInUI.contains(expectedName)) {
            System.out.println("Name Verified: " + expectedName);
        } else {
            Assert.fail("Employee not found in UI list: " + expectedName 
                       + "\nAll Employees: " + employeesInUI);
        }
    }

    private String buildDisplayedName(String first, String middle, String last) {
        StringBuilder name = new StringBuilder(first);
        if (middle != null && !middle.trim().isEmpty()) {
            name.append(" ").append(middle);
        }
        return name.toString().trim();
    }
}

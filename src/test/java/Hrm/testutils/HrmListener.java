package Hrm.testutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class HrmListener extends HRMBaseTest implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Test Suite Started =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        ExtentManager.startTest(result.getName());   // start new test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentManager.getTest();
        test.log(Status.PASS, "Test Passed: " + result.getName());
        try {
            if (HRMBaseTest.getDriver() != null) {   // avoid null driver
                String screenshotPath = HRMBaseTest.captureScreenshot(HRMBaseTest.getDriver());
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.WARNING, "Screenshot not available for: " + result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentManager.getTest();
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        try {
            String screenshotPath = HRMBaseTest.captureScreenshot(HRMBaseTest.getDriver());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentManager.getTest();
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== Test Suite Finished =====");
        ExtentManager.endTest();   // flush report
    }
}

package Hrm.testutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HrmListener implements ITestListener{
	
	WebDriver driver;
	public ExtentSparkReporter sparkreporter;//UI of the report
	public ExtentReports extentreports;//populate common info on the report
	public ExtentTest extenttest;//creating test case entries in the report and update status of the methods

	
	  public void onStart(ITestContext context) {
		  System.out.println("all test execution has started");
		  sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/AutomationResultReport.html");
		  sparkreporter.config().setDocumentTitle("extentReport");
		  sparkreporter.config().setReportName("functional testing");
		  sparkreporter.config().setTheme(Theme.STANDARD);
		  
		  extentreports= new ExtentReports();
		  extentreports.attachReporter(sparkreporter);
		  
		  extentreports.setSystemInfo("computername", "local host");
		  extentreports.setSystemInfo("environment", "qa");
		  extentreports.setSystemInfo("Tester name", "My tester");
	  }
	
	public void onTestStart(ITestResult result) {
		System.out.println("test execution has started");
	    
	  }

	 
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("test execution success");
		  extenttest=extentreports.createTest(result.getName());
		  extenttest.log(Status.PASS, "Test case passed is: "+result.getName());
		  
	    
	  }

	 
	  public void onTestFailure(ITestResult result) {
		  System.out.println("test execution failed");
		  extenttest=extentreports.createTest(result.getName());
		  //extenttest.log(Status.FAIL, extenttest.addScreenCaptureFromPath(captureScreen(driver)));
		  extenttest.log(Status.FAIL, "Test case failed is: "+result.getName());
		  extenttest.log(Status.FAIL, "Test case failed cause is: "+result.getThrowable());
		  
	    
	  }

	  
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("test execution skipped");
		  extenttest=extentreports.createTest(result.getName());
		  extenttest.log(Status.SKIP, "Test case failed is: "+result.getName());
	    
	  }



	 
	  public void onFinish(ITestContext context) {
		  System.out.println("test execution has finished");
		  extentreports.flush();
	  }
	  
	  public static String captureScreen(WebDriver driver) throws IOException {
	    	
	    	File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	File destFile = new File("reports/images/" +System.currentTimeMillis()+ ".png");
	    	String absolute_screen =destFile.getAbsolutePath();
	    	System.out.println(absolute_screen);
	    	FileUtils.copyFile(srcFile, destFile);
			return absolute_screen;
	    	
	    }
}

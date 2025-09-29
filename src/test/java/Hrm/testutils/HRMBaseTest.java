package Hrm.testutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMBaseTest {
	
	public static WebDriver driver;
	
	public static void LaunchBrowser() {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-notifications");
	    WebDriverManager.chromedriver().setup(); 
	    driver = new ChromeDriver(chromeoptions);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void tearDown() {
		driver.quit();
	}

}

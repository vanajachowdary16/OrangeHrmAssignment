package Hrm.testutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMBaseTest {
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
	    WebDriverManager.chromedriver().setup(); // auto-manages driver
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

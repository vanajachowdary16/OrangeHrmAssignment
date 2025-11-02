package Hrm.testutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMBaseTest {

    // Keep a protected driver field so page classes that extend BaseTest can use it
    protected static WebDriver driver;

    public static void LaunchBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folderPath = System.getProperty("user.dir") + "/reports/images/";
        File destDir = new File(folderPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + ".png";
        File destFile = new File(folderPath + fileName);
        FileUtils.copyFile(srcFile, destFile);

        // return absolute path
        return destFile.getAbsolutePath();
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

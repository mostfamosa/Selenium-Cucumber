package class1.nbaExe.utilities;

import class1.nbaExe.context.TestContext;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utils.Drivers.getChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver initializeDriver(TestContext testContext) {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", getChromeDriver());
            driver = new ChromeDriver();
            testContext.setDriver(driver); // Set the driver in the Test Context
        }
        return driver;
    }

    public static void takeScreenshot(String scenName) {
        // Capture a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        try {
            // Specify the file path where you want to save the screenshot
            FileUtils.copyFile(screenshot, new File(String.format("screenshot_%s_%s.png", scenName, LocalDateTime.now().format(format))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getTo(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

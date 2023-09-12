package class1.nbaExe.hooks;

import class1.nbaExe.context.TestContext;
import class1.nbaExe.utilities.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static class1.nbaExe.utilities.WebDriverManager.takeScreenshot;

public class MyHooks {
    private static TestContext testContext;

    public MyHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario() {
        WebDriver driver = WebDriverManager.initializeDriver(testContext);
        testContext.setDriver(driver);
    }

    @After
    public static void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario.getName());

        }
        testContext = null;
        // Close the WebDriver (close browser)
        WebDriverManager.quitDriver();

    }
}

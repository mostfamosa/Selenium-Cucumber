package class1.nbaExe.context;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

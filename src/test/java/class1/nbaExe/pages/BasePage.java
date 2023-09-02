package class1.nbaExe.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    private final By POP_UP_CLOSE = By.xpath("//div[@class = 'ot-sdk-row']");

    private WebElement popUp;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    //wait the element to be found
    public WebElement waitToLoad(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {

            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }


    public void closePopUp() {
        popUp = waitToLoad(POP_UP_CLOSE);
        setDisplayNone(popUp);
    }

    private void setDisplayNone(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'none';", element);
    }
}

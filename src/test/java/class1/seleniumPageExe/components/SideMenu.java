package class1.seleniumPageExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends BaseComponent {

    //locators
    private final By OVERVIEW = By.id("m-documentationoverview");
    private final By WEB_DRIVER = By.id("m-documentationwebdriver");
    private final By GRID = By.id("m-documentationgrid");
    private final By IE_DRIVER_SERVER = By.id("m-documentationie_driver_server");
    private final By IDE = By.id("m-documentationide");

    //web elements
    private WebElement overView;
    private WebElement webDriver;
    private WebElement grid;
    private WebElement driverServer;
    private WebElement ide;

    public SideMenu(WebDriver driver) {
        super(driver);
        initComponent();
    }

    private void initComponent() {
        overView = waitToVisible(OVERVIEW);
        webDriver = waitToVisible(WEB_DRIVER);
        grid = waitToVisible(GRID);
        driverServer = waitToVisible(IE_DRIVER_SERVER);
        ide = waitToVisible(IDE);
    }

    public void clickOnOverview() {
        overView.click();
    }
    public void clickOnwebDriver() {
        webDriver.click();
    }
    public void clickOnGrid() {
        grid.click();
    }
    public void clickOnIEDriverServer() {
        driverServer.click();
    }
    public void clickOnIDE() {
        ide.click();
    }


}

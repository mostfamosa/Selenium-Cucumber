package class1.seleniumPageExe.pages;

import class1.seleniumPageExe.components.Bar;
import class1.seleniumPageExe.components.SideMenu;
import org.openqa.selenium.WebDriver;

public class SeleniumDocumentationPage extends BasePage {
    private SideMenu sideMenu;
    private Bar bar;

    public SeleniumDocumentationPage(WebDriver driver) {
        super(driver);
        sideMenu = new SideMenu(driver);
        bar = new Bar(driver);
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public Bar getBar() {
        return bar;
    }
}

package class1.seleniumPageExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bar extends BaseComponent {

    //locators
    private final By DOWNLOADS = By.xpath("//li//a//span[text() = 'Downloads']");
    private final By DOCUMENTATION = By.xpath("//li//a//span[text() = 'Documentation']");
    private final By PROJECTS = By.xpath("//li//a//span[text() = 'Projects']");
    private final By SUPPORT = By.xpath("//li//a//span[text() = 'Support']");
    private final By BLOG = By.xpath("//li//a//span[text() = 'Blog']");

    //web elements
    private WebElement downloadsBar;
    private WebElement documentationBar;
    private WebElement projectsBar;
    private WebElement supportBar;
    private WebElement blogBar;


    public Bar(WebDriver driver) {
        super(driver);
        initComponent();
    }
    private void initComponent() {
        downloadsBar = waitToLoad(DOWNLOADS);
        documentationBar = waitToLoad(DOCUMENTATION);
        projectsBar = waitToLoad(PROJECTS);
        supportBar = waitToLoad(SUPPORT);
        blogBar = waitToLoad(BLOG);
    }

    public void clickOnDownload() {
        downloadsBar.click();
    }
    public void clickOnDocumentation() {
        documentationBar.click();
    }
    public void clickOnProject() {
        projectsBar.click();
    }
    public void clickOnSupport() {
        supportBar.click();
    }
    public void clickOnBlog() {
        blogBar.click();
    }

}

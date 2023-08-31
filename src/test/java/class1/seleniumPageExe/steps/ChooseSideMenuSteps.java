package class1.seleniumPageExe.steps;

import class1.seleniumPageExe.pages.SeleniumDocumentationPage;
import class1.seleniumPageExe.utils.SideBarItems;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static utils.Drivers.getChromeDriver;

public class ChooseSideMenuSteps {
    private WebDriver driver;
    private final String webDriverPath = getChromeDriver();
    private SeleniumDocumentationPage seleniumPage;

    @Given("I’m on the Selenium documentation site")
    public void Im_On_The_Selenium_Documentation_Site2() {
        // Code to set up the web driver and navigate to the homepage
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/");
        seleniumPage = new SeleniumDocumentationPage(driver);
    }

    @When("On the sidebar - I click {string}")
    public void On_The_Sidebar_I_Click(String sideBarItem) {
        SideBarItems newSideBarItem= SideBarItems.valueOf(sideBarItem);
        switch (newSideBarItem){

            case Overview -> {
                seleniumPage.getSideMenu().clickOnOverview();
            }
            case WebDriver -> {
                seleniumPage.getSideMenu().clickOnwebDriver();
            }
            case Grid -> {
                seleniumPage.getSideMenu().clickOnGrid();
            }
            default -> {
                throw new IllegalArgumentException("Illegal Sidebar Item!");
            }
        }
    }

    @Then("I’m on the {string} documentation page")
    public void Im_On_The_Documentation_Page(String pageName) {
        String currentUrl = driver.getCurrentUrl();
        String snakePageName = convertToSnakeCase(pageName);
        Assert.assertEquals(currentUrl,
                "https://www.selenium.dev/documentation/"+snakePageName+"/");
        driver.close();
    }

    private String convertToSnakeCase(String input) {
        // Convert the input string to lowercase
        String lowercaseInput = input.toLowerCase();

        // Replace spaces with underscores
        String snakeCase = lowercaseInput.replace(" ", "_");

        return snakeCase;
    }
}

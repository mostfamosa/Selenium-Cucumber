package class1.nbaExe.steps;

import class1.nbaExe.components.PlayersStats;
import class1.nbaExe.context.TestContext;
import class1.nbaExe.pages.StatsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class PlayersStatSteps {
    private WebDriver driver;
    private StatsPage statsPage;
    private TestContext testContext;

    public PlayersStatSteps(TestContext context) {
        this.testContext = context;
        // Get the WebDriver instance from the Test Context
        driver = testContext.getDriver();
    }

    @Given("I’m on the NBA site")
    public void iMOnTheNBASite() {
        driver.get("https://www.nba.com/stats/leaders");
    }

    @When("On the stat page - I select Players")
    public void onTheStatPageISelectPlayers() {
        statsPage = new StatsPage(driver);
        statsPage.goToPlayersStat();
    }

    @When("On the stat page - I sort them by wins")
    public void onTheStatPageISortThemByWins() {
        statsPage.getPlayersStats().sortByWins();
    }

    @Then("The first player is {string}")
    public void theFirstPlayerIs(String player) {
        PlayersStats playersStats = statsPage.getPlayersStats();
        String firstPlayer = playersStats.getFirstPlayer();
        Assert.assertEquals(player, firstPlayer);
    }

    @When("On the stat page - I sort them by points")
    public void onTheStatPageISortThemByPoints() {
        //by default the players sorted by points
    }

    @When("I set the filters to season {string}")
    public void iSetTheFiltersToSeason(String season) {
        statsPage.selectSeason(season);
    }

}

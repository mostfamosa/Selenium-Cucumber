package class1.nbaExe.steps;

import class1.nbaExe.components.TeamsStats;
import class1.nbaExe.context.TestContext;
import class1.nbaExe.pages.StatsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;


public class TeamsStatSteps {
    private WebDriver driver;
    private StatsPage statsPage;

    public TeamsStatSteps(TestContext testContext) {
        // Get the WebDriver instance from the Test Context
        driver = testContext.getDriver();
    }

    @Given("I’m on the NBA statistics site")
    public void iMOnTheNBASite() {
        driver.get("https://www.nba.com/stats/leaders");
    }

    @When("On the stat page - I select Teams")
    public void onTheStatPageISelectTeams() {
        statsPage = new StatsPage(driver);
        statsPage.goToTeamsStat();
    }

    @When("On the stat page - I sort the teams by wins")
    public void onTheStatPageISortThemByWins() {
        statsPage.getTeamsStats().sortByWins();
    }

    @Then("The first team is {string}")
    public void theFirstTeamIs(String team) {
        TeamsStats teamsStats = statsPage.getTeamsStats();
        String firstTeam = teamsStats.getFirstTeam();
        Assert.assertEquals(team, firstTeam);
    }

    @When("On the stat page - I sort the teams by points")
    public void onTheStatPageISortThemByPoints() {
        statsPage.getTeamsStats().sortByPoints();
    }

    @When("I set the filters on teams to season {string}")
    public void iSetTheFiltersToSeason(String season) {
        statsPage.selectSeason(season);
    }

    @And("I set the filters to the following season:")
    public void iSetTheFiltersToTheFollowingSeason(DataTable dataTable) {
        List<String> seasons = dataTable.asList();
        for (String season : seasons) {
            if (!Objects.equals(season, dataTable.cell(0, 0))){
                statsPage.selectSeason(season);
            }
        }
    }


}



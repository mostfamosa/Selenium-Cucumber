package class1.nbaExe.pages;

import class1.nbaExe.components.PlayersStats;
import class1.nbaExe.components.TeamsStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class StatsPage extends BasePage {

    // Locators
    private final By SELECT_STATS_TO = By.xpath("(//nav//button[@class = 'ArrowToggleButton_arrowButton__9RpIv StatsQuickNavSelector_arrow__EarFF'])[1]");
    private final By SELECT_TRADITIONAL = By.xpath("(//nav//button[@class = 'ArrowToggleButton_arrowButton__9RpIv StatsQuickNavSelector_arrow__EarFF'])[3]");
    private final By SELECT_PLAYERS_STAT = By.xpath("(//a[@class = 'StatsQuickNavSelector_link__yl1f2'])[1]");
    private final By SELECT_TEAMS_STAT = By.xpath("(//a[@class = 'StatsQuickNavSelector_link__yl1f2'])[2]");
    private final By SELECT_SEASON_TYPE = By.xpath("(//select[@class = 'DropDown_select__4pIg9'])[2]");
    private final By SELECT_PER_MODE = By.xpath("(//select[@class = 'DropDown_select__4pIg9'])[3]");
    private final By SELECT_SEASON_SEGMENT = By.xpath("(//select[@class = 'SplitComboDropDown_select__G7wsG'])[1]");

    // Web elements
    private WebElement selectStatsTo;
    private WebElement selectPlayerStats;
    private WebElement selectTeamsStats;
    private WebElement selectSeason;
    private WebElement selectSeasonType;
    private WebElement selectPerMode;
    private WebElement selectSeasonSegment;


    private PlayersStats playersStats;
    private TeamsStats teamsStats;

    public StatsPage(WebDriver driver) {
        super(driver);
        initPage();
    }

    private void initPage() {
        closePopUp();
    }

    public void goToPlayersStat() {
        selectStatsTo = waitToLoad(SELECT_STATS_TO);
        selectStatsTo.click();
        selectPlayerStats = waitToLoad(SELECT_PLAYERS_STAT);
        selectPlayerStats.click();
        waitToLoad(SELECT_TRADITIONAL);
        playersStats = new PlayersStats(driver);
    }

    public void goToTeamsStat() {
        selectStatsTo = waitToLoad(SELECT_STATS_TO);
        selectStatsTo.click();
        selectTeamsStats = waitToLoad(SELECT_TEAMS_STAT);
        selectTeamsStats.click();
        waitToLoad(SELECT_TRADITIONAL);
        teamsStats = new TeamsStats(driver);
    }

    public void selectSeason(String season) {
        By SELECT_SEASON = By.xpath("(//select[@class = 'DropDown_select__4pIg9'])[1]");
        selectSeason = waitToLoad(SELECT_SEASON);
        Select select = new Select(selectSeason);
        select.selectByVisibleText(season);
        driver.navigate().refresh();
        closePopUp();
    }

    public void selectSeasonType(String seasonType) {
        selectSeasonType = waitToLoad(SELECT_SEASON_TYPE);
        Select select = new Select(selectSeasonType);
        select.selectByVisibleText(seasonType);
        driver.navigate().refresh();
        closePopUp();
    }

    public void selectPerMode(String mode) {
        selectPerMode = waitToLoad(SELECT_PER_MODE);
        Select select = new Select(selectPerMode);
        select.selectByVisibleText(mode);
        driver.navigate().refresh();
        closePopUp();
    }

    public void selectSeasonSegment(String seasonSegment) {
        selectSeasonSegment = waitToLoad(SELECT_SEASON_SEGMENT);
        Select select = new Select(selectSeasonSegment);
        select.selectByVisibleText(seasonSegment);
        driver.navigate().refresh();
        closePopUp();
    }

    public PlayersStats getPlayersStats() {
        return playersStats;
    }

    public TeamsStats getTeamsStats() {
        return teamsStats;
    }
}

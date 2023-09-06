package class1.nbaExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamsStats extends BaseComponent{

    // Locators
    private final String FIRST_TEAM_LOCATOR = "(//div[@class = 'StatsTeamsTraditionalTable_teamLogoSpan__1HRTS']//span)[1]";
    private final String TEAM_NAME_BY_POSITION_LOCATOR = "(//div[@class = 'StatsTeamsTraditionalTable_teamLogoSpan__1HRTS']//span)[%d]";
    private final String SORT_BY_WINS_LOCATOR = "//th[@field = 'W']";
    private final String SORT_BY_WIN_RATE_LOCATOR = "//th[@field = 'W_PCT']";
    private final String SORT_BY_POINTS_LOCATOR = "//th[@field = 'PTS']";

    // Web elements
    private WebElement teamName;
    private WebElement teamNameByPosition;
    private WebElement sortByWinsRate;
    private WebElement sortByWins;
    private WebElement sortByPoints;

    public TeamsStats(WebDriver driver) {
        super(driver);
        initComponent();
    }

    private void initComponent() {
    }

    public String getFirstTeam() {
        By TEAM_NAME = By.xpath(FIRST_TEAM_LOCATOR);
        teamName = waitToVisible(TEAM_NAME);
        return teamName.getText();
    }

    public String getTeamNameByPosition(int position) {
        By TEAM_NAME_BY_POSITION = By.xpath(String.format(TEAM_NAME_BY_POSITION_LOCATOR,position));
        teamNameByPosition = waitToVisible(TEAM_NAME_BY_POSITION);
        return teamNameByPosition.getText();
    }

    public void sortByWins(){
        By SORT_BY_WINS = By.xpath(SORT_BY_WINS_LOCATOR);
        sortByWins = waitToVisible(SORT_BY_WINS);
        sortByWins.click();
    }

    public void sortByWinRate(){
        By SORT_BY_WINS_RATE = By.xpath(SORT_BY_WIN_RATE_LOCATOR);
        sortByWinsRate = waitToVisible(SORT_BY_WINS_RATE);
        sortByWinsRate.click();
    }

    public void sortByPoints(){
        By SORT_BY_POINTS = By.xpath(SORT_BY_POINTS_LOCATOR);
        sortByPoints = waitToVisible(SORT_BY_POINTS);
        sortByPoints.click();
    }

}

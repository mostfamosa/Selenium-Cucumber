package class1.nbaExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamsStats extends BaseComponent{


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
        By TEAM_NAME = By.xpath("(//div[@class = 'StatsTeamsTraditionalTable_teamLogoSpan__1HRTS']//span)[1]");
        teamName = waitToLoad(TEAM_NAME);
        return teamName.getText();
    }

    public String getTeamNameByPosition(int position) {
        By TEAM_NAME_BY_POSITION = By.xpath(String.format("(//div[@class = 'StatsTeamsTraditionalTable_teamLogoSpan__1HRTS']//span)[%d]",position));
        teamNameByPosition = waitToLoad(TEAM_NAME_BY_POSITION);
        return teamNameByPosition.getText();
    }

    public void sortByWins(){
        By SORT_BY_WINS = By.xpath("//th[@field = 'W']");
        sortByWins = waitToLoad(SORT_BY_WINS);
        sortByWins.click();
    }

    public void sortByWinRate(){
        By SORT_BY_WINS_RATE = By.xpath("//th[@field = 'W_PCT']");
        sortByWinsRate = waitToLoad(SORT_BY_WINS_RATE);
        sortByWinsRate.click();
    }

    public void sortByPoints(){
        By SORT_BY_POINTS = By.xpath("//th[@field = 'PTS']");
        sortByPoints = waitToLoad(SORT_BY_POINTS);
        sortByPoints.click();
    }

}

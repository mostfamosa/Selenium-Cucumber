package class1.nbaExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayersStats extends BaseComponent {

    // Locators
    private final String PLAYER_NAME_LOCATOR = "(//td[@class = 'Crom_text__NpR1_ Crom_primary__EajZu Crom_stickySecondColumn__29Dwf'])[1]";
    private final String PLAYER_NAME_BY_POSITION_LOCATOR = "(//td[@class = 'Crom_text__NpR1_ Crom_primary__EajZu Crom_stickySecondColumn__29Dwf'])[%d]";
    private final String SORT_BY_WINS_LOCATOR = "//th[@field = 'W']";
    private final String SORT_BY_AGE_LOCATOR = "//th[@field = 'AGE']";
    private final String SORT_BY_POINTS_LOCATOR = "//th[@field = 'PTS']";

    // Web elements
    private WebElement playerName;
    private WebElement playerNameByPosition;
    private WebElement sortByWins;
    private WebElement sortByAge;
    private WebElement sortByPoints;


    public PlayersStats(WebDriver driver) {
        super(driver);
        initComponent();
    }

    private void initComponent() {
    }

    public String getFirstPlayer() {
        By PLAYER_NAME = By.xpath(PLAYER_NAME_LOCATOR);
        playerName = waitToVisible(PLAYER_NAME);
        return playerName.getText();
    }

    public String getPlayerNameByPosition(int position) {
        By PLAYER_NAME_BY_POSITION = By.xpath(String.format(PLAYER_NAME_BY_POSITION_LOCATOR, position));
        playerNameByPosition = waitToVisible(PLAYER_NAME_BY_POSITION);
        return playerNameByPosition.getText();
    }

    public void sortByWins() {
        By SORT_BY_WINS = By.xpath(SORT_BY_WINS_LOCATOR);
        sortByWins = waitToVisible(SORT_BY_WINS);
        sortByWins.click();
    }

    public void sortByAge() {
        By SORT_BY_AGE = By.xpath(SORT_BY_AGE_LOCATOR);
        sortByAge = waitToVisible(SORT_BY_AGE);
        sortByAge.click();
    }

    public void sortByPoints() {
        By SORT_BY_POINTS = By.xpath(SORT_BY_POINTS_LOCATOR);
        sortByPoints = waitToVisible(SORT_BY_POINTS);
        sortByPoints.click();
    }
}

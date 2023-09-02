package class1.nbaExe.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayersStats extends BaseComponent {

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
        By PLAYER_NAME = By.xpath("(//td[@class = 'Crom_text__NpR1_ Crom_primary__EajZu Crom_stickySecondColumn__29Dwf'])[1]");
        playerName = waitToLoad(PLAYER_NAME);
        return playerName.getText();
    }

    public String getPlayerNameByPosition(int position) {
        By PLAYER_NAME_BY_POSITION = By.xpath(String.format("(//td[@class = 'Crom_text__NpR1_ Crom_primary__EajZu Crom_stickySecondColumn__29Dwf'])[%d]", position));
        playerNameByPosition = waitToLoad(PLAYER_NAME_BY_POSITION);
        return playerNameByPosition.getText();
    }

    public void sortByWins() {
        By SORT_BY_WINS = By.xpath("//th[@field = 'W']");
        sortByWins = waitToLoad(SORT_BY_WINS);
        sortByWins.click();
    }

    public void sortByAge() {
        By SORT_BY_AGE = By.xpath("//th[@field = 'AGE']");
        sortByAge = waitToLoad(SORT_BY_AGE);
        sortByAge.click();
    }

    public void sortByPoints() {
        By SORT_BY_POINTS = By.xpath("//th[@field = 'PTS']");
        sortByPoints = waitToLoad(SORT_BY_POINTS);
        sortByPoints.click();
    }
}

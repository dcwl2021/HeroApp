package actions.heroApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.LeaderBoardPage;
import utils.SeleniumDriver;

import java.util.List;

public class LeaderboardPageActions {
    WebDriver driver;
    LeaderBoardPage leaderBoardPage = new LeaderBoardPage();

    public LeaderboardPageActions() {
        driver = SeleniumDriver.getDriver();
    }


    public void verifyScoreForUser(String name, String score) {

        List<WebElement> nameList = driver.findElements(leaderBoardPage.userNameText);
        List<WebElement> scoreList = driver.findElements(leaderBoardPage.scoreText);

        for (int i = 0; i < nameList.size(); i++) {
            String userName = nameList.get(i).getText();
            String userScore;
            if (userName.equals(name)) {
                userScore = scoreList.get(i).getText();
                Assert.assertTrue(userScore.equals(score));
                break;
            }
        }
    }
}

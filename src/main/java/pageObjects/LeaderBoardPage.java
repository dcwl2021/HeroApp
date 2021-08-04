package pageObjects;

import org.openqa.selenium.By;

public class LeaderBoardPage {

    public By userIdText = By.cssSelector("table > tbody > tr > td:nth-child(1)");
    public By userNameText = By.cssSelector("table > tbody > tr > td:nth-child(2)");
    public By scoreText = By.cssSelector("table > tbody > tr > td:nth-child(3)");
}

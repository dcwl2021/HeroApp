package pageObjects;

import org.openqa.selenium.By;

public class BattlePage {

    public By answerLinks = By.cssSelector("a[id*=answer_]");
    public By startButton = By.xpath("//button[text()='Start']");
    public By tryAgainButton = By.xpath("//button[text()='Try again']");
    public By nextBattleButton = By.xpath("//button[text()='next battle']");
    public By checkScoreButton = By.xpath("//button[text()='Check your final score']");
    public By tryNextBattleButton = By.xpath("//button[text()='Try the next battle']");

}

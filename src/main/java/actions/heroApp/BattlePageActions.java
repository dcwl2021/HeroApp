package actions.heroApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BusPage;
import utils.SeleniumDriver;

import java.util.List;

public class BattlePageActions {
    WebDriver driver;
    BusPage busPage = new BusPage();

    public BattlePageActions() {
        driver = SeleniumDriver.getDriver();
    }


    public void startBattleBus() {
        driver.findElement(busPage.startButton).click();
    }


    public void clickButtonWithText(String buttonText) {
        if (buttonText.contains("Start")) {
            driver.findElement(busPage.startButton).click();
        } else if (buttonText.contains("Check your final score")) {
            driver.findElement(busPage.checkScoreButton).click();
        } else if (buttonText.contains("Try the next battle")) {
            driver.findElement(busPage.tryNextBattleButton).click();
        } else if (buttonText.contains("Try again")) {
            driver.findElement(busPage.tryAgainButton).click();
        }
    }


    public void selectAnswerWithText(String answer) {
        List<WebElement> answerList = driver.findElements(busPage.answerLinks);
        String buttonText;
        for (WebElement element : answerList) {
            buttonText = element.getText();
            if (buttonText.contains(answer)) {
                element.click();
            }
        }
    }
}

package actions.heroApp;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import utils.SeleniumDriver;
import org.testng.Assert;

public class HomePageActions {

    WebDriver driver;
    HomePage homePage = new HomePage();

    public HomePageActions() {
        driver = SeleniumDriver.getDriver();
    }


    public void enterWarriorName(String name) {
        driver.findElement(homePage.worriorNameInput).sendKeys(name);
        driver.findElement(homePage.worriorLink).click();
    }

    public void verifyWarrior(String name) {
        String linkText = driver.findElement(homePage.startJourneyLink).getText();
        Assert.assertEquals(linkText, "Start your journey " + name);
    }

    public void moveToBattlePage() {
        driver.findElement(homePage.startJourneyLink).click();
    }
}

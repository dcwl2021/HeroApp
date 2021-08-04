package actions.heroApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CovidPage;
import utils.SeleniumDriver;


import java.util.ArrayList;
import java.util.List;

public class CovidPageActions {

    WebDriver driver;
    CovidPage covidPage = new CovidPage();

    public CovidPageActions() {
        driver = SeleniumDriver.getDriver();
    }


    public void verifyCovidPage(String name) {
        String pageHeader = driver.findElement(covidPage.headingText).getText();
        Assert.assertEquals(pageHeader, "COVID-19 THE GAME");
    }


    public void enterBattle(String battleName) {
        if (battleName.toLowerCase().equals("bus")) {
            driver.findElement(covidPage.busLink).click();
        } else if (battleName.toLowerCase().equals("news")) {
            driver.findElement(covidPage.newsLink).click();
        }
    }


    public void verifyTickerItems(String item) {
        List<WebElement> tickerList = driver.findElements(covidPage.tickerList);
        int tries = 0;
        boolean found = false;

        do {
            tickerList = driver.findElements(covidPage.tickerList);
            tries = tries + 1;
        } while (tickerList.size() != 7 || tries > 5);

        for (WebElement element : tickerList) {
            String itemText;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            itemText = element.getText();
            if (itemText.equals(item)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }


}

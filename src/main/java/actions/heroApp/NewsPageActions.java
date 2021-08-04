package actions.heroApp;

import org.openqa.selenium.WebDriver;
import pageObjects.NewsPage;
import utils.SeleniumDriver;

public class NewsPageActions {
    WebDriver driver;
    NewsPage newsPage = new NewsPage();

    public NewsPageActions() {
        driver = SeleniumDriver.getDriver();
    }

}

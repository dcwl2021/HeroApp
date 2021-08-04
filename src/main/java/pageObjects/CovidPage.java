package pageObjects;

import org.openqa.selenium.By;

public class CovidPage {

    public By headingText = By.className("alpha-heading");
    public By tickerList = By.cssSelector("#myHeader > div > div > div > .ticker-item");
    public By newsLink = By.id("news");
    public By busLink = By.id("bus");
    public By restaurantLink = By.id("restaurant");
    public By officeLink = By.id("office");

}

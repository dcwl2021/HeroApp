package stepDefinitions.heroApp;

import actions.heroApp.CovidPageActions;
import actions.heroApp.HomePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ResourcePaths;
import utils.SeleniumDriver;

public class CreateWarriorSteps {
    HomePageActions homePageActions = new HomePageActions();
    CovidPageActions covidPageActions = new CovidPageActions();


    @Given("I am on the Hero App Home Page")
    public void openHeroApp() {
        SeleniumDriver.openPage(ResourcePaths.heroAppUrl);
    }


    @When("^I create new warrior (.*)$")
    public void createWarrior(String name) {
        homePageActions.enterWarriorName(name);
    }


    @Then("^I can see the starting with (.*)$")
    public void verifyWarrior(String name) {
        homePageActions.verifyWarrior(name);
    }


    @Then("^I go to battle page$")
    public void goToBattles() {
        homePageActions.moveToBattlePage();
    }


    @And("^I can see moving text with \"(.*)\"$")
    public void checkTickerItems(String itemText) {
        covidPageActions.verifyTickerItems(itemText);
    }


    @When("^I start the journey with my warrior (.*)$")
    public void startJourney(String name) {
        createWarrior(name);
        goToBattles();
    }

}

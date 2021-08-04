package stepDefinitions.heroApp;

import actions.heroApp.CovidPageActions;
import actions.heroApp.LeaderboardPageActions;
import io.cucumber.java.en.Then;

public class LeaderboardSteps {

    CovidPageActions covidPageActions = new CovidPageActions();
    LeaderboardPageActions LeaderboardPageActions = new LeaderboardPageActions();

    @Then("^verify score for (.*) as (.*)$")
    public void enterBattle(String name, String score) {
        LeaderboardPageActions.verifyScoreForUser(name, score);
    }
}

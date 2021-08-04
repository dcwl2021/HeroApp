package stepDefinitions.heroApp;

import actions.heroApp.BattlePageActions;
import actions.heroApp.CovidPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class BattleSteps {
    CovidPageActions covidPageActions = new CovidPageActions();
    BattlePageActions battlePageActions = new BattlePageActions();


    @When("^I start battle with (.*)$")
    public void enterBattle(String game) {
        covidPageActions.enterBattle(game);
        battlePageActions.startBattle();
    }


    @And("^I select answer \"(.*)\"$")
    public void checkTickerItems(String answerText) {
        battlePageActions.selectAnswerWithText(answerText);
    }


    @And("^select \"(.*)\" from battle ground$")
    public void clickButtonFromBattleGround(String buttonText) {
        battlePageActions.clickButtonWithText(buttonText);
    }

}

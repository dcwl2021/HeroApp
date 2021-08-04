package stepDefinitions.apiSteps;

import actions.api.ApiActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utils.ResourcePaths;

import java.util.Random;

public class ApiSteps {
    ApiActions apiActions = new ApiActions();
    String apiUrl;
    Response response;
    String userName;


    @Given("^I would like to access Hero App API$")
    public void setHeroAppApi() {
        apiUrl = ResourcePaths.baseApiUrl;
    }

    @When("^I retrieve warrior details from api$")
    public void getWarriors() {
        response = apiActions.GetUsers(apiUrl);
    }

    @When("^I create warrior with (.*) and (.*)$")
    public void createWarriorApi(String name, String score) {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        userName = name+ num;
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", userName);
        requestParams.put("score", score);
        response = apiActions.PostUser(apiUrl, requestParams);
    }


    @Then("^I verify api response for (.*)$")
    public void createWarriorApi(String validation) {
        Assert.assertTrue(response.asString().contains(validation));
    }


}

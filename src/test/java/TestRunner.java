import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features"
        , glue = {"stepDefinitions"}
        , plugin = {"pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        tags = "@smoke"
        //tags = "@dc"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

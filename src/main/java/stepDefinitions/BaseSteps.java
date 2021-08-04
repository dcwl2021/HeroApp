package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DefectReporter;
import utils.SeleniumDriver;

public class BaseSteps {
    private static DefectReporter reporter = new DefectReporter();

    @Before("@ui")
    public static void setUp(Scenario scenario) {
        SeleniumDriver.setUpDriver(System.getProperty("browser"));
    }


    @After("@ui")
    public static void addDetails(Scenario scenario) {
        WebDriver driver = SeleniumDriver.getDriver();
        System.out.println(scenario.isFailed());
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "Failure snapshot");
        }
        SeleniumDriver.tearDown();
    }


    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            reporter.reportDefect(scenario.getName());
        }
    }
}

package bdd.stepDefinitions;

import bdd.utils.TestProperties;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import bdd.selenium.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;


public class StepDefinitionsBrowser {
    public StepDefinitionsBrowser() throws IOException {
    }
    TestProperties webProperties = new TestProperties("web.properties");
    private static Driver driver;
    static Scenario scenario;

    @Before
    public void testScenario(Scenario scenario){
        StepDefinitionsBrowser.scenario = scenario;
        System.out.println("Execute test scenario : \"" + StepDefinitionsBrowser.scenario.getName() + "\"");
    }

    @Given("Open browser")
    public void openBrowser() {
        driver = new Driver(webProperties.getProperty("web.browser"));
        scenario.log("Successfully launch browser");
    }

    @When("Access website {string}")
    public void accessWebpage(String website) {
        driver.AccessUrl(website);
    }

    @Then("Verify google.com banner")
    public void verifyGoogleComBanner() {
        driver.getElement("class", "lnXdpd");
    }

    @And("Do google search with text {string}")
    public void doGoogleSearch(String searchText) {
        driver.doSearch( "gLFyf", searchText);
        driver.verifyPageContainText("//div", "Our systems have detected unusual traffic from your computer network.");
    }

    @And("Close browser")
    public void closeBrowser() {
        driver.terminate();
    }

    @After
    public static void tearDown() {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}

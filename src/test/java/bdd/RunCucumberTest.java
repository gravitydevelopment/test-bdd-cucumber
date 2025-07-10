package bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.util.Properties;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
//@RunWith(Cucumber.class)
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber-report/cucumber.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "bdd/stepDefinitions")

@CucumberOptions(
        glue = {"bdd"},
        features = {"src/test/resources/features"}
)

@SpringBootTest
//@TestPropertySource(locations = "classpath:application.properties")
public class RunCucumberTest {}


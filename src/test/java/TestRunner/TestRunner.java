package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Sample.feature",
        glue = {"StepDefinitions"},
        monochrome = true,
        strict = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty"
        }
)
public class TestRunner {

}




package tech_state_cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"tech_state_cucumber"},
        features = "src/test/resources/features",
        tags = "@smoke"
)
public class MyJUnitRunnerTest {
}


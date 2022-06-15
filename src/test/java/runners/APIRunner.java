package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/APIWorkFlow.feature",
        glue = "APISteps",
        dryRun = false,
        tags = "@dynamic",
        plugin = {"pretty"}
)

public class APIRunner {
}

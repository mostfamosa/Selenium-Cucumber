package class1.nbaExe.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/nbaExeFeatures",
        glue = {"class1.nbaExe.steps","class1.nbaExe.hooks"} // Specify the package with your step definitions and hooks
)
public class RunCucumberTest {
}

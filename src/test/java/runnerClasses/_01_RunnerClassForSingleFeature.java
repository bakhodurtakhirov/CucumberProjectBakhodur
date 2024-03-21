package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featureFiles/_01_Login.feature", // The path of the feature file we want to run
        glue = "stepDefinitions" // Where to find step definitions of our scenarios
)
public class _01_RunnerClassForSingleFeature extends AbstractTestNGCucumberTests {
}

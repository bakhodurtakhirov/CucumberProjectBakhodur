package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_01_Login.feature",
                "src/test/java/featureFiles/_02_Country.feature"
        },
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-pretty", "json:target/cucumber.json"} //For Jenkins Cucumber report
//        dryRun = true // only checks if we have all necessary step definitions for our features.
        //dryRun = false // Default value. It runs the scenarios regularly.
)
public class _02_RunnerClassForMultipleFeatures extends AbstractTestNGCucumberTests {
}

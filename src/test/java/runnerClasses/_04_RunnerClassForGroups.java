package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/cucumber-pretty", "json:target/cucumber.json"} //For Jenkins Cucumber report
)
public class _04_RunnerClassForGroups extends AbstractTestNGCucumberTests {


}

package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest"
)
public class _04_RunnerClassForGroups extends AbstractTestNGCucumberTests {


}

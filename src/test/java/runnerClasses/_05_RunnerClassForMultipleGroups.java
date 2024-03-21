package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
//        tags = "@SmokeTest and @FireTest" //Runs only scenarios that have both annotations.
        tags = "@SmokeTest or @FireTest" //Runs only scenarios that have either of annotations.
)
public class _05_RunnerClassForMultipleGroups extends AbstractTestNGCucumberTests {


}

package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = "html:target/site/cucumber-pretty.html" //we can change the path. If we include non-existing package then a package will be created.
)

public class _06_RunnerClassWithPlugin extends AbstractTestNGCucumberTests {
}

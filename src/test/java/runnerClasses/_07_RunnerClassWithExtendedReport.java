package runnerClasses;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class _07_RunnerClassWithExtendedReport extends AbstractTestNGCucumberTests {
    
    @BeforeClass //runs before @CucumberOptions
    public void setUp(){ //any name
        System.out.println("Test is starting");
    }
    
    @AfterClass //runs after @CucumberOptions
    public void terminate(){ //any name
        System.out.println("Test is ended");
        ExtentService.getInstance().setSystemInfo("OS Info", System.getProperty("os.name")); //Adds info about OS to the report
        ExtentService.getInstance().setSystemInfo("Tester Name",System.getProperty("user.name")); //Adds the name of logged in tester
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone")); //Adds the timezone of tester
        ExtentService.getInstance().setSystemInfo("Time Zone","Campus"); //Adds app name, anything we like
        ExtentService.getInstance().setSystemInfo("Department Name","QA"); //Adds app name
        ExtentService.getInstance().setSystemInfo("Team Name","QA Team 1"); //Adds app name
    }
}

package runnerClasses;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.DriverClass;

@CucumberOptions(
        features = "src/test/java/featurefiles",
        glue = "stepDefinitions",
        tags = "@SmokeTest",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class _08_RunnerClassForDifferentBrowsers extends AbstractTestNGCucumberTests {
    
    @BeforeClass //runs before @CucumberOptions
    @Parameters("browser") //Need to add browser name to avoid exception.
    public void setUp(@Optional("chrome") String browserName){ //any name method name
        System.out.println("Test is starting");
        DriverClass.threadBrowserName.set(browserName);
    }
    
    @AfterClass //runs after @CucumberOptions
    public void terminate(){ //any name
        System.out.println("Test is ended");
        ExtentService.getInstance().setSystemInfo("OS Info", System.getProperty("os.name")); //Adds info about OS to the report
        ExtentService.getInstance().setSystemInfo("Tester Name",System.getProperty("user.name")); //Adds the name of logged in tester
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone")); //Adds the timezone of tester
        ExtentService.getInstance().setSystemInfo("Time Zone","Campus"); //Adds app name, anything we like
        ExtentService.getInstance().setSystemInfo("Department Name","QA"); //Adds dept name
        ExtentService.getInstance().setSystemInfo("Team Name","QA Team 1"); //Adds team name
    }
}

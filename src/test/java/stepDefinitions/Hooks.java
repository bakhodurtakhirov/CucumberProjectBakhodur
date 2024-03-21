package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverClass;
import utilities.ExcelUtilities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    
    LocalDateTime startTime;
    
    @Before
    public void beforeScenario() {
//        System.out.println("Scenario is started");
        startTime = LocalDateTime.now();
    }
    
    @After
    public void afterScenario(Scenario scenario) {
//        System.out.println("Scenario is ended");
        
        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot) (DriverClass.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,endTime);
        //Scenario name, scenario status, Start time, End Time, Duration
        ExcelUtilities.writeScenarioInfoToExcel(scenario, startTime, endTime, duration);
        
        DriverClass.quitDriver();
    }

//    @BeforeStep
//    public void beforeStep(){
////        System.out.println("Step is started");
//    }
//
//    @AfterStep
//    public void afterStep(){
////        System.out.println("Step is ended");
//    }
}

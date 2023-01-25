package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
        Hooks is used to run before and after each scenario
     */
    @Before
    public void setUpScenario(){
        // System.out.println("Before Method");
    }

    @After
    public void tearDownScenario(Scenario scenario){
        // System.out.println("After Method");
        if (scenario.isFailed()){// capturing the screenshot when a scenario fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot,"image/png", "failed_scenario" + scenario.getName() + "");
            Driver.closeDriver();
        }
    }


    // This Before hooks only runs for @smoke_tests tagged scenarios
    // @Before(value = "@smoke_tests")
    @Before("@smoke_tests")
    public void setUpSmokeScenarios(){
        System.out.println("Run for only smoke test scenarios");
    }

    // This After hooks only runs for @smoke_tests tagged scenarios
    // @After(value = "@smoke_tests")
    @After("@smoke_tests")
    public void tearDownSmokeScenarios(){
        System.out.println("Run for only smoke test scenarios");
    }
}

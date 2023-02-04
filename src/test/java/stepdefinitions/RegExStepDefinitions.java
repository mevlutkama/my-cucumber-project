package stepdefinitions;

import io.cucumber.java.en.When;
import utilities.Driver;

public class RegExStepDefinitions {

    // {string} --->>> "([^"]*)"
    @When("^[I|i]? open \"([^\"]*)\" page")
    public void iOpenPage(String string) {
        Driver.getDriver().get(string);
    }

    // With regex, we can now make the feature file
    // a little more flexible
    // in this example, our data is parameterized
    // Also the step can start with I ot i
}

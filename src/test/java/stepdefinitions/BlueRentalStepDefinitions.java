package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class BlueRentalStepDefinitions {

    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
    @When("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        blueRentalHomePage.loginButton.click();
    }

    @And("enter {string} for username")
    public void enterForUsername(String username) {
        blueRentalLoginPage.emailInput.sendKeys(username);
    }

    @And("enter {string} for password")
    public void enterForPassword(String password) {
        blueRentalLoginPage.passwordInput.sendKeys(password);
    }
    @When("click on login button")
    public void click_on_login_button() {
        blueRentalLoginPage.loginSubmitButton.click();
    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
        assertTrue(blueRentalHomePage.userIdSection.isDisplayed());
        ReusableMethods.waitFor(5);
    }
}

package stepdefinitions;

import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.ReusableMethods;

public class MedunnaSignInStepDefinitions {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();

    @When("click on user icon")
    public void click_on_user_icon() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.userIcon.click();
    }

    @When("click on Sign In option")
    public void click_on_sign_in_option() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.signInOption.click();
    }

    @When("enter {string} in Username input")
    public void enter_in_username_input(String username) {
        ReusableMethods.waitFor(1);
        medunnaLoginPage.usernameInput.sendKeys(username);
    }

    @When("enter {string} in Password input")
    public void enter_in_password_input(String password) {
        ReusableMethods.waitFor(1);
        medunnaLoginPage.passwordInput.sendKeys(password);
    }

    @When("click on Remember Me checkbox")
    public void click_on_remember_me_checkbox() {
        ReusableMethods.waitFor(1);
        medunnaLoginPage.rememerMeCheckBox.click();
    }

    @When("click on Sign In submit button")
    public void click_on_sign_in_submit_button() {
        ReusableMethods.waitFor(1);
        medunnaLoginPage.signInSubmitButton.click();
    }
}

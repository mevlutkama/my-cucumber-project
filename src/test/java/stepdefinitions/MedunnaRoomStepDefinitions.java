package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class MedunnaRoomStepDefinitions {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    @When("click on Items&Titles")
    public void click_on_items_titles() {
        medunnaHomePage.itemsAndTitles.click();
    }

    @When("click on Room option")
    public void click_on_room_option() {
        medunnaHomePage.roomOption.click();
    }

    @When("click on Create a new room button")
    public void click_on_create_a_new_room_button() {
        medunnaRoomPage.createANewRoomButton.click();
    }

    @When("enter {string} room number input")
    public void enterRoomNumberInput(String roomNumber) {
        medunnaRoomPage.roomNumberInput.sendKeys(roomNumber);
    }

    @When("select Suite option from Room Type dropdown")
    public void select_suite_option_from_room_type_dropdown() {
        new Select(medunnaRoomPage.roomTypeDropDown).selectByVisibleText("SUITE");
    }

    @When("click on Status checkbox")
    public void click_on_status_checkbox() {
        medunnaRoomPage.statusCheckBox.click();

    }

    @When("enter {string} in Price input")
    public void enter_in_price_input(String price) {
        medunnaRoomPage.priceInput.sendKeys(price);
    }

    @When("enter {string}> in Description input")
    public void enter_in_description_input(String description) {
        medunnaRoomPage.descriptionInput.sendKeys(description);
    }

    @When("click on Save button")
    public void click_on_save_button() {
        medunnaRoomPage.saveSubmitButton.click();
    }

    @When("click on Created Date")
    public void click_on_created_date() {
        ReusableMethods.waitFor(3);
        medunnaRoomPage.createdDate.click();
    }

    @Then("assert that room is created via {string}")
    public void assert_that_room_is_created_via(String roomNumber) {
        ReusableMethods.waitFor(5);
        int counter = 0;
        for (WebElement w : medunnaRoomPage.roomNumberList){
            if (w.getText().equals(roomNumber)){
               counter++;
               assertTrue(true);
               break;
           }
        }
        if (counter == 0){
            assertTrue(false);
        }
    }
}

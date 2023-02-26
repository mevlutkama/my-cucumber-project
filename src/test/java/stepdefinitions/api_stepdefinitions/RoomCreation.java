package stepdefinitions.api_stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class RoomCreation {

    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {

        spec.pathParams("first","api","second", "rooms");


    }
    @Then("user gets room data and validates")
    public void user_gets_room_data_and_validates() {

    }
}

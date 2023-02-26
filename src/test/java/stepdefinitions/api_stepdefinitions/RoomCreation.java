package stepdefinitions.api_stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Room;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;


public class RoomCreation {

    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {

        spec.pathParams("first","api","second", "rooms");

        Room room = new Room();
        room.setRoomNumber(Faker.instance().number().numberBetween(1000,100000));
        room.setRoomType("TWIN");
        room.setStatus(true);
        room.setPrice(100);

        Response response = given().
                headers("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbnRlYW0wMiIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc5OTA5NjM3fQ.B7R7ezvwhFV_5siDavUcft1plYmdAgUwhtl07LFRruTKPvNV0V_kwUjyN2xpnsZ5oUW5XjQsIOXDcwNyz8D3iQ",
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                spec(spec).
                contentType(ContentType.JSON).
                body(room).
                post("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("user gets room data and validates")
    public void user_gets_room_data_and_validates() {

    }
}

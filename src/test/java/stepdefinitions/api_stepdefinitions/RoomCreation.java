package stepdefinitions.api_stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Room;
import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateToken;

public class RoomCreation {

    Response response;
    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {

        spec.pathParams("first","api","second", "rooms");

        Room room = new Room();
        room.setRoomNumber(Faker.instance().number().numberBetween(1000,1000000));
        room.setRoomType("TWIN");
        room.setStatus(true);
        room.setPrice(100);
        room.setDescription("This room is created by kama");

        response = given().
                headers("Authorization", "Bearer "+ generateToken(),
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

        assertEquals(201,response.getStatusCode());
    }
}

package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {
    public static String generateToken(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "Team02+");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "AdminTeam02");
        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");
        String token = response.jsonPath().getString("id_token");
        return token;
    }
}

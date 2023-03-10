package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public class MedunnaBaseUrl {
    public static RequestSpecification spec;
    public static void medunnaSetUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
    }
}

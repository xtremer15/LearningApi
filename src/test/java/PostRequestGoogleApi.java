import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestGoogleApi {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://216.10.245.166";

        given().
                queryParam("key", "qaclick123").
                body(Payload.bodyJsonPayload2()).
                when().
                post("/maps/api/place/add/json").
                then().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }
}
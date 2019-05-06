import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestGoogleApi {
    public static void main(String[] args) throws IOException {

        Properties prope = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\mihai.constantin\\Learning\\target\\env.properites");
        prope.load(fis);
        String URL = prope.getProperty("URL");
        String Key = prope.getProperty("KEY");

        RestAssured.baseURI = URL;

        Response response = given().
                queryParam("key", Key).
                body(Payload.bodyJsonPayload()).
                when().
                post(Resoruces.placeADD()).
                then().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).extract().response();

        String responseAsString = response.asString();
        System.out.println(responseAsString);
        JsonPath jsonPath = new JsonPath(responseAsString);
        String placeId = jsonPath.get("place_id");
        System.out.println(placeId);


        given().queryParam("key", "qaclick123").
                body("{" + "\"place_id\":\"" + placeId + "\"" + "}").when()
                .post(Resoruces.placeDELETE()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
                .body("status", equalTo("OK"));
    }
}

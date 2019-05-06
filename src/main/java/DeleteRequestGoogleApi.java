import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        String body = "{\n" +
                "\n" +
                "    \"location\":{\n" +
                "\n" +
                "        \"lat\" : -38.383494,\n" +
                "\n" +
                "        \"lng\" : 33.427362\n" +
                "\n" +
                "    },\n" +
                "\n" +
                "    \"accuracy\":50,\n" +
                "\n" +
                "    \"name\":\"Frontline house\",\n" +
                "\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "\n" +
                "    \"language\" : \"French-IN\"\n" +
                "\n" +
                "}";
        Response response = given().
                queryParam("key", Key).
                body(body).
                when().
                post("/maps/api/place/add/json").
                then().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).extract().response();

        String responseAsString = response.asString();
        System.out.println(responseAsString);
        JsonPath jsonPath = new JsonPath(responseAsString);
        String placeId = jsonPath.get("place_id");
        System.out.println(placeId);


        given().queryParam("key", "qaclick123").
                body("{" + "\"place_id\":\"" + placeId + "\"" + "}").when()
                .post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
                .body("status", equalTo("OK"));
    }
}

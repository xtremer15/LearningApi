import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest {
    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String payLoadXML = GenerateStringFromResource("C:\\Users\\mihai.constantin\\Learning\\target\\postData.xml");
        given().
                queryParam("key", "qaclick123").
                body(payLoadXML).
                when().
                post("/maps/api/place/add/xml ").
                then().statusCode(200).and().contentType(ContentType.XML).extract().response();
    }

    //Converts an XML file to String format by passing the path from the xml file
    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
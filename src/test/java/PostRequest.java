import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest {
    public static void main(String[] args) throws IOException {
        Response response;
        RestAssured.baseURI = "http://216.10.245.166";
        String payLoadXML = GenerateStringFromResource("C:\\Users\\mihai.constantin\\Learning\\target\\postData.xml");
        response = given().
                queryParam("key", "qaclick123").
                body(payLoadXML).
                when().
                post("/maps/api/place/add/xml ").
                then().statusCode(200).and().contentType(ContentType.XML).extract().response();

        String responseAsStringFromXML = response.asString();
        System.out.println(responseAsStringFromXML);
        XmlPath xmlPath = new XmlPath(responseAsStringFromXML);
    }

    //Converts an XML file to String format by passing the path from the xml file
    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
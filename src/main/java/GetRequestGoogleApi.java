import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestGoogleApi {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://maps.googleapis.com";


        given().
                param("key", "AIzaSyBXvxsZKeww6vEkG_lGHToVOfTuWbnn6ns ").
                param("location", "-33.8670522,151.1957362").
                param("radius", "1500").
                param("type", "restaurant").
                param("keyword", "cruise").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("results[1].name", equalTo("Australian Cruise Group")).
                and().body("results[1].id", equalTo("a97f9fb468bcd26b68a23072a55af82d4b325e0d")).and()
                .header("server", "scaffolding on HTTPServer2");

        given().
                param("key", "AIzaSyBXvxsZKeww6vEkG_lGHToVOfTuWbnn6ns ").
                param("location", "-33.8670522,151.1957362").
                param("radius", "1500").
                param("type", "restaurant").
                param("keyword", "cruise").
                when().
                post("/maps/api/place/nearbysearch/json").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("results[1].name", equalTo("Australian Cruise Group")).
                and().body("results[1].id", equalTo("a97f9fb468bcd26b68a23072a55af82d4b325e0d")).and()
                .header("server", "scaffolding on HTTPServer2");


    }
}

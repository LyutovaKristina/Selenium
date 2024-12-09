import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTests {

    private final String BASE_URL = "http://postman-echo.com";

    @Test
    public void testGetRequest() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .when()
                .get(BASE_URL + "/get");

        response.then().statusCode(200);
        response.then().body("args.foo1", equalTo("bar1"));
    }

    @Test
    public void testPostRequest() {
        String jsonBody = "{\"names\":[\"Dorothea\",\"Rose\",\"Blanche\",\"Sophia\"],\"nums\":[1,3,2,4]}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post(BASE_URL + "/post");

        response.then().statusCode(200);
        response.then().body("json.names", equalTo(List.of("Dorothea", "Rose", "Blanche", "Sophia")));
        response.then().body("json.nums", equalTo((List.of(1, 3, 2, 4)));
    }

    @Test
    public void testPutRequest() {
        String jsonBody = "{\"names\":[\"Dorothea\",\"Rose\",\"Blanche\",\"Sophia\"],\"nums\":[1,3,2,4]}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .put(BASE_URL + "/put");

        response.then().statusCode(200);
        response.then().body("json.names", equalTo(List.of("Dorothea", "Rose", "Blanche", "Sophia")));
        response.then().body("json.nums", equalTo((List.of(1, 3, 2, 4)));
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .when()
                .delete(BASE_URL + "/delete");

        response.then().statusCode(200);
        response.then().body("args.foo1", equalTo("bar1"));
    }
}

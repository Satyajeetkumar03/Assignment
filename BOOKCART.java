import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BOOKCART {
    @Test
    void Add()
    {
        baseURI = "https://bookcart.azurewebsites.net/api";

        // Your access token
        String accessToken = "KqcL7s998JrfFHRP";
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/ShoppingCart/AddToCart/1/85")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    void GetCartItem()
    {
        baseURI = "https://bookcart.azurewebsites.net/api";

        // Your access token
        String accessToken = "KqcL7s998JrfFHRP";
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ShoppingCart/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void Delete(){
        baseURI = "https://bookcart.azurewebsites.net/api";

        // Your access token
        String accessToken = "KqcL7s998JrfFHRP";
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete("/ShoppingCart/1")
                .then()
                .statusCode(200)
                .log().all();
    }
}

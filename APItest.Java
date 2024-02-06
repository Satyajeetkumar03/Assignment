import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class APItest {
    @Test
    void testpost() {

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        obj.put("id",1234567);
        obj.put("name", "ABCDEF");
        obj.put("email", "ABCDEF@example.com");
        obj.put("gender", "male");
        obj.put("status", "active");
        given().header("Authorization", "Bearer " + authToken). // Adding the authentication token
                body(obj.toJSONString()).
                when().
                post("/public/v2/users").

                then().
                statusCode(201)
                .log().all();


    }
    @Test
    void testget() {

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .get("/public/v2/users")

                .then()
                .statusCode(200)
                .log().all();


    }
    @Test
    void testpatch() {

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        obj.put("id",6140489);
        obj.put("name", "Devangana Asan");
        obj.put("email", "devangana_asan@mraz.example");
        obj.put("gender", "female");
        obj.put("status", "active");
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .patch("/public/v2/users/6140489")

                .then()
                .statusCode(200)
                .log().all();


    }
    @Test
    void testdelete() {

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        obj.put("id",6140489);
        obj.put("name", "Devangana Asan");
        obj.put("email", "devangana_asan@mraz.example");
        obj.put("gender", "male");
        obj.put("status", "active");
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .delete("/public/v2/users/6140489")

                .then()
                .statusCode(204)
                .log().all();


    }
}
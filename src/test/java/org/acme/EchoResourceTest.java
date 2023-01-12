package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class EchoResourceTest {

    private static String body = "{\"echo\": \"echo\"}";

    @Test
    public void testEchoGet() {
        given()
          .when().get("/echo")
          .then()
             .statusCode(200);
    }

    @Test
    public void testEchoDelete() {
        given()
          .when().delete("/echo")
          .then()
             .statusCode(200);
    }

    @Test
    public void testEchoPost() {
        given()
          .header("Content-type", "application/json")
          .and()
          .body(body)
          .when().post("/echo")
          .then()
             .statusCode(200);
    }

    @Test
    public void testEchoPut() {
        given()
          .header("Content-type", "application/json")
          .and()
          .body(body)
          .when().put("/echo")
          .then()
             .statusCode(200);
    }

}
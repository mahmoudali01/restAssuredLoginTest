package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndPoints {
    public static Response getToken(String payload) {
        RestAssured.baseURI = Routes.base_uri;

        Response response = RestAssured.
                given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .and()
                .body(payload)
                .when()
                .post(Routes.post_uri)
                .then().log().all()
                .extract().response();
        response.jsonPath().getString("token");
        return response;

    }

    public static Response login(String token) {

        RestAssured.baseURI = Routes.base_uri;

        Response response = RestAssured.
                given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .when()
                .get(Routes.get_uri)
                .then().log().all()
                .extract().response();

        return response;

    }
}

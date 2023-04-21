package api.test;

import api.endpoints.EndPoints;
import api.payload.Credentials;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;

public class TestEndPoints {
    static Credentials credentials;
    String token;

    @BeforeSuite
    public static void setup() {
        credentials = new Credentials();
        credentials.setEmail("merchant@foodics.com");
        credentials.setPassword("123456");
    }

    //login without token
    @Test(priority = 1)
    public void login() {
        Response response = EndPoints.login(token);
        response.then().body("$", hasKey("message"));
        Assert.assertEquals(401, response.statusCode());
        Assert.assertEquals(response.jsonPath().getString("message").equals("Unauthenticated."),true);
    }

    //get token
    @Test(priority = 2)
    public void getToken() {
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("email", credentials.getEmail());
        bodyParams.put("password", credentials.getPassword());
        String payload = new Gson().toJson(bodyParams);
        Response response = EndPoints.getToken(payload);
        response.then().body("$", hasKey("token"));
        token = response.jsonPath().getString("token");
        Assert.assertEquals(200, response.statusCode());
    }

    //login with token
    @Test(priority = 3)
    public void loginWithToken() {
        Response response = EndPoints.login(token);
        Assert.assertEquals(200, response.statusCode());
    }

}

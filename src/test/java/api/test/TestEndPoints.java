package api.test;

import api.endpoints.EndPoints;
import api.payload.Credentials;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

@Epic("REST API Test Login  using TestNG")
@Feature("Test Login With null and correct Bearer token")
public class TestEndPoints {
    static Credentials credentials;
    String token;

    @BeforeSuite
    public static void setup() {
        credentials = new Credentials();
        credentials.setEmail("merchant@foodics.com");
        credentials.setPassword("123456");
    }

    @Test(priority = 1, description = "Login with Bearer token equal null")
    @Story("GET Request with Token equal null")
    @Description("Test Description : Verify that user can't login without token")
    public void login() {
        Response response = EndPoints.login(token);
        response.then()
                .statusCode(401)
                .and()
                .assertThat()
                .body("$", hasKey("message"))
                .body("message", notNullValue())
                .body("message", equalTo("Unauthenticated."));

    }

    @Test(priority = 2, description = "Make request to get bearer token")
    @Story("POST Request to get Bearer token")
    @Description("Test Description : Verify that message is returned when make request with valid email and password")
    public void getToken() {
        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("email", credentials.getEmail());
        bodyParams.put("password", credentials.getPassword());
        String payload = new Gson().toJson(bodyParams);
        Response response = EndPoints.getToken(payload);
        token = response.jsonPath().getString("token");
        response.then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("$", hasKey("token"))
                .body("token", notNullValue());
    }

    @Test(priority = 3, description = "Login with valid Bearer token")
    @Story("GET Request with valid access Token")
    @Description("Test Description : Verify that user can login with valid token")
    public void loginWithToken() {
        Response response = EndPoints.login(token);
        response.then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("$", hasKey("user"))
                .body("user", notNullValue())
                .body("user.onboard_request", nullValue())
                .body("user.merchant.id", equalTo("6d0423e8-72b9-4d26-a0a3-c835487381a5"))
                .body("user.merchant.reference", equalTo("ME000001"))
                .body("user.merchant.business_type", equalTo(2))
                .body("user.merchant.business_reference", equalTo("289597"))
                .body("user.merchant.solo_id", nullValue())
                .body("user.merchant.business_name", equalTo("FOODICS"))
                .body("user.merchant.business_name_localized", equalTo("فودكس"))
                .body("user.merchant.commercial_registration", equalTo("2051049000"))
                .body("user.merchant.commercial_registration_expiration", equalTo("2024-10-04T00:00:00.000000Z"))
                .body("user.merchant.unified_national_number", equalTo("7012409004"))
                .body("user.merchant.mcc", equalTo(5814))
                .body("user.merchant.settlement_enabled", equalTo(true))
                .body("user.merchant.settlement_disabled_reason", nullValue())
                .body("user.merchant.total_terminals", equalTo(90))
                .body("user.merchant.active_terminals", equalTo(87))
                .body("user.merchant.beneficiary_name", equalTo("ABDULLAH KHAWAJI"))
                .body("user.merchant.mada_fee", equalTo("2% + 2 SAR"))
                .body("user.merchant.credit_card_fee",equalTo("0% + 0 SAR"))
                .body("user.merchant.amex_fee",equalTo("0% + 0 SAR"))
                .body("user.merchant.is_active", equalTo(true))
                .body("user.merchant.is_approved", equalTo(true))
                .body("user.merchant.created_at", equalTo("2020-03-17 16:03:31"))
                .body("user.merchant.updated_at", equalTo("2023-01-19 13:02:01"))
                .body("user.id", equalTo("1deb74be-77fa-4eec-8980-de3116f37251"))
                .body("user.name", equalTo("Test Foodics"))
                .body("user.national_id", nullValue())
                .body("user.email", equalTo("merchant@foodics.com"))
                .body("user.mobile_dial_code", equalTo("966"))
                .body("user.mobile_number", equalTo("559072407"))
                .body("user.birth_date", nullValue())
                .body("user.gender", nullValue())
                .body("user.preferred_language", equalTo("ar"))
                .body("user.eKYC.is_suspicious", equalTo(false))
                .body("user.eKYC.is_completed", equalTo(false))
                .body("user.eKYC.is_mobile_number_verified", equalTo(false))
                .body("user.eKYC.is_national_id_verified", equalTo(false))
                .body("user.eKYC.is_commercial_registration_verified", equalTo(true))
                .body("user.eKYC.is_email_verified", equalTo(false))
                .body("user.birth_country", nullValue())
                .body("user.residence_country", nullValue())
                .body("user.source_of_income", nullValue())
                .body("user.profession", nullValue())
                .body("user.is_owner", equalTo(true))
                .body("user.is_contact_user", equalTo(true))
                .body("user.is_active", equalTo(true))
                .body("user.created_at", equalTo("2021-02-14 09:18:20"));
    }

}

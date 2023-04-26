package api.test;

import api.endpoints.EndPoints;
import api.payload.Auth;
import api.payload.EKYC;
import api.payload.Merchant;
import api.payload.User;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

@Epic("REST API Test Login  using TestNG")
@Feature("Test Login With null and correct Bearer token")
public class AuthEndPoints {
    static Auth auth;
    User user;
    Merchant merchant;
    EKYC ekyc;
    String token;

    @BeforeSuite
    public static void setup() {
        auth = new Auth();
        auth.setEmail("merchant@foodics.com");
        auth.setPassword("123456");
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
        bodyParams.put("email", auth.getEmail());
        bodyParams.put("password", auth.getPassword());
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
        //setting user values
        user = new User();
        merchant = new Merchant();
        ekyc = new EKYC();
        user.setOnboard_request(response.jsonPath().getString("user.onboard_request"));
        merchant.setId(response.jsonPath().getString("user.merchant.id"));
        merchant.setReference(response.jsonPath().getString("user.merchant.reference"));
        merchant.setBusiness_type(response.jsonPath().getInt("user.merchant.business_type"));
        merchant.setBusiness_reference(response.jsonPath().getString("user.merchant.business_reference"));
        merchant.setSolo_id(response.jsonPath().getString("user.merchant.solo_id"));
        merchant.setBusiness_name(response.jsonPath().getString("user.merchant.business_name"));
        merchant.setBusiness_name_localized(response.jsonPath().getString("user.merchant.business_name_localized"));
        merchant.setCommercial_registration(response.jsonPath().getString("user.merchant.commercial_registration"));
        merchant.setCommercial_registration_expiration(response.jsonPath().getString("user.merchant.commercial_registration_expiration"));
        merchant.setUnified_national_number(response.jsonPath().getString("user.merchant.unified_national_number"));
        merchant.setMcc(response.jsonPath().getInt("user.merchant.mcc"));
        merchant.setSettlement_enabled(response.jsonPath().getBoolean("user.merchant.settlement_enabled"));
        merchant.setSettlement_disabled_reason(response.jsonPath().getString("user.merchant.settlement_disabled_reason"));
        merchant.setTotal_terminals(response.jsonPath().getInt("user.merchant.total_terminals"));
        merchant.setActive_terminals(response.jsonPath().getInt("user.merchant.active_terminals"));
        merchant.setBeneficiary_name(response.jsonPath().getString("user.merchant.beneficiary_name"));
        merchant.setMada_fee(response.jsonPath().getString("user.merchant.mada_fee"));
        merchant.setCredit_card_fee(response.jsonPath().getString("user.merchant.credit_card_fee"));
        merchant.setAmex_fee(response.jsonPath().getString("user.merchant.amex_fee"));
        merchant.setIs_active(response.jsonPath().getBoolean("user.merchant.is_active"));
        merchant.setIs_approved(response.jsonPath().getBoolean("user.merchant.is_approved"));
        merchant.setCreated_at(response.jsonPath().getString("user.merchant.created_at"));
        merchant.setUpdated_at(response.jsonPath().getString("user.merchant.updated_at"));
        user.setMerchant(merchant);
        user.setId(response.jsonPath().getString("user.id"));
        user.setName(response.jsonPath().getString("user.name"));
        user.setNational_id(response.jsonPath().getString("user.national_id"));
        user.setEmail(response.jsonPath().getString("user.email"));
        user.setMobile_dial_code(response.jsonPath().getString("user.mobile_dial_code"));
        user.setMobile_number(response.jsonPath().getString("user.mobile_number"));
        user.setBirth_date(response.jsonPath().getString("user.birth_date"));
        user.setGender(response.jsonPath().getString("user.gender"));
        user.setPreferred_language(response.jsonPath().getString("user.preferred_language"));
        ekyc.setIs_suspicious(response.jsonPath().getBoolean("user.eKYC.is_suspicious"));
        ekyc.setIs_completed(response.jsonPath().getBoolean("user.eKYC.is_completed"));
        ekyc.setIs_mobile_number_verified(response.jsonPath().getBoolean("user.eKYC.is_mobile_number_verified"));
        ekyc.setIs_national_id_verified(response.jsonPath().getBoolean("user.eKYC.is_national_id_verified"));
        ekyc.setIs_commercial_registration_verified(response.jsonPath().getBoolean("user.eKYC.is_commercial_registration_verified"));
        ekyc.setIs_email_verified(response.jsonPath().getBoolean("user.eKYC.is_email_verified"));
        user.setEkyc(ekyc);
        user.setBirth_country(response.jsonPath().getString("user.birth_country"));
        user.setResidence_country(response.jsonPath().getString("user.residence_country"));
        user.setBirth_country(response.jsonPath().getString("user.birth_country"));
        user.setSource_of_income(response.jsonPath().getString("user.source_of_income"));
        user.setProfession(response.jsonPath().getString("user.profession"));
        user.setIs_owner(response.jsonPath().getBoolean("user.is_owner"));
        user.setIs_contact_user(response.jsonPath().getBoolean("user.is_contact_user"));
        user.setIs_active(response.jsonPath().getBoolean("user.is_active"));
        user.setCreated_at(response.jsonPath().getString("user.created_at"));
        System.out.println("******************************"+user.getIs_active()+"******************************");
        System.out.println("******************************"+user.getIs_contact_user()+"******************************");
        System.out.println("******************************"+user.getMerchant().getIs_active()+"******************************");
        System.out.println("******************************"+user.getMerchant().getAmex_fee()+"******************************");
        System.out.println("******************************"+user.getMerchant().getReference()+"******************************");
        System.out.println("******************************"+user.getEkyc().getIs_email_verified()+"******************************");
        System.out.println("******************************"+user.getEkyc().getIs_national_id_verified()+"******************************");
        System.out.println("******************************"+user.getEkyc().getIs_completed()+"******************************");
        System.out.println("******************************"+user.getEkyc().getIs_suspicious()+"******************************");

        response.then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("$", hasKey("user"))
                .body("user", notNullValue())
                .body("user.onboard_request", equalTo(user.getOnboard_request()))
                .body("user.merchant.id", equalTo(user.getMerchant().getId()))
                .body("user.merchant.reference", equalTo(user.getMerchant().getReference()))
                .body("user.merchant.business_type", equalTo(user.getMerchant().getBusiness_type()))
                .body("user.merchant.business_reference", equalTo(user.getMerchant().getBusiness_reference()))
                .body("user.merchant.solo_id", equalTo(user.getMerchant().getSolo_id()))
                .body("user.merchant.business_name", equalTo(user.getMerchant().getBusiness_name()))
                .body("user.merchant.business_name_localized", equalTo(user.getMerchant().getBusiness_name_localized()))
                .body("user.merchant.commercial_registration", equalTo(user.getMerchant().getCommercial_registration()))
                .body("user.merchant.commercial_registration_expiration", equalTo(user.getMerchant().getCommercial_registration_expiration()))
                .body("user.merchant.unified_national_number", equalTo(user.getMerchant().getUnified_national_number()))
                .body("user.merchant.mcc", equalTo(user.getMerchant().getMcc()))
                .body("user.merchant.settlement_enabled", equalTo(user.getMerchant().getSettlement_enabled()))
                .body("user.merchant.settlement_disabled_reason", equalTo(user.getMerchant().getSettlement_disabled_reason()))
                .body("user.merchant.total_terminals", equalTo(user.getMerchant().getTotal_terminals()))
                .body("user.merchant.active_terminals", equalTo(user.getMerchant().getActive_terminals()))
                .body("user.merchant.beneficiary_name", equalTo(user.getMerchant().getBeneficiary_name()))
                .body("user.merchant.mada_fee", equalTo(user.getMerchant().getMada_fee()))
                .body("user.merchant.credit_card_fee", equalTo(user.getMerchant().getCredit_card_fee()))
                .body("user.merchant.amex_fee", equalTo(user.getMerchant().getAmex_fee()))
                .body("user.merchant.is_active", equalTo(user.getMerchant().getIs_active()))
                .body("user.merchant.is_approved", equalTo(user.getMerchant().getIs_approved()))
                .body("user.merchant.created_at", equalTo(user.getMerchant().getCreated_at()))
                .body("user.merchant.updated_at", equalTo(user.getMerchant().getUpdated_at()))
                .body("user.id", equalTo(user.getId()))
                .body("user.name", equalTo(user.getName()))
                .body("user.national_id",equalTo(user.getNational_id()))
                .body("user.email", equalTo(user.getEmail()))
                .body("user.mobile_dial_code", equalTo(user.getMobile_dial_code()))
                .body("user.mobile_number", equalTo(user.getMobile_number()))
                .body("user.birth_date", equalTo(user.getBirth_date()))
                .body("user.gender", equalTo(user.getGender()))
                .body("user.preferred_language", equalTo(user.getPreferred_language()))
                .body("user.eKYC.is_suspicious", equalTo(user.getEkyc().getIs_suspicious()))
                .body("user.eKYC.is_completed", equalTo(user.getEkyc().getIs_completed()))
                .body("user.eKYC.is_mobile_number_verified", equalTo(user.getEkyc().getIs_mobile_number_verified()))
                .body("user.eKYC.is_national_id_verified", equalTo(user.getEkyc().getIs_national_id_verified()))
                .body("user.eKYC.is_commercial_registration_verified", equalTo(user.getEkyc().getIs_commercial_registration_verified()))
                .body("user.eKYC.is_email_verified", equalTo(user.getEkyc().getIs_email_verified()))
                .body("user.birth_country", equalTo(user.getBirth_country()))
                .body("user.residence_country", equalTo(user.getResidence_country()))
                .body("user.source_of_income", equalTo(user.getSource_of_income()))
                .body("user.profession", equalTo(user.getProfession()))
                .body("user.is_owner", equalTo(user.getIs_owner()))
                .body("user.is_contact_user", equalTo(user.getIs_contact_user()))
                .body("user.is_active", equalTo(user.getIs_active()))
                .body("user.created_at", equalTo(user.getCreated_at()));

    }

}

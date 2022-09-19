import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTest extends BaseTest {

    //baseUri
    public static String baseUri = "https://rara-ms-oms-brs.dev.rara.delivery";

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = baseUri;

        //headers
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("TenantToken","22222");
        hm.put("AccountNumber","44444");
        hm.put("BusinessName","5555");
        hm.put("ServiceId","2222");
        hm.put("ServiceType","56666");

        given().headers(hm)
                .when().log().all()
                .get("/api/v1/order/1234456866098/123454323")

        .then()
                .assertThat().statusCode(200)
                .body("message", equalTo("Get order details"))
                .and().body("status",equalTo("success"))
                .log().all();


    }
}

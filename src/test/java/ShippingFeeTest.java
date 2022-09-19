import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ShippingFeeTest {

    public static String baseURI = "https://rara-ms-oms-brs.dev.rara.delivery";

    @Test
    public void shippingFeeByWeight(){
        RestAssured.baseURI=baseURI;

        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("TenantToken","142345");
        hm.put("AccountNumber","SERVICE_FEE_WEIGHT");
        hm.put("BusinessName","Dasnic");
        hm.put("ServiceId","SER1001");
        hm.put("ServiceType","INSTANT01");

        Response response = given().headers(hm)
                .log().all()
                .body("{\n" +
                        "   \n" +
                        "    \"weight\":9.6\n" +
                        "    \n" +
                        "}")
                .when().post("/api/v1/order/shipping-fee")
                .then().statusCode(200)
                .log().all()
                .extract().response();
        //System.out.println(response.asString());

    }
}

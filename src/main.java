import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class main {
    public static void main(String[] args) {
        //Variables needed to log onto API
        String baseUri = "https://magento.abox.co.za/rest/V1/";

        String loginPath = "integration/admin/token";
        String productCatalogPath = "products";
        String apiUserName = "training_api_user";
        String apiPassword = "PtkekYqgRZW8pCVN";
        String sessionToken = "";

        //get session token using rest assured

        sessionToken =
                given()
                        .baseUri(baseUri)
                        .basePath(loginPath)
                        .queryParam("username", apiUserName)
                        .queryParam("password", apiPassword)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .body().asString();
        System.out.println(sessionToken.toString());
    }
}
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static com.sun.javafx.fxml.expression.Expression.lessThan;
import static io.restassured.RestAssured.given;

public class search_DigitalWatch {

    private static String sessionToken ="puwjklaodr0dg47ky09r9romywev6oue";

    public static String baseUri = "https://magento.abox.co.za/rest/V1/";

    public static void main(String[] args) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", sessionToken);

        RequestSpecification  request =given()
                .headers(headers)
                .baseUri(baseUri)
                .basePath("search")
                .queryParam("searchCriteria[requestName]","quick_search_container")
                .queryParam("searchCriteria[filter_groups][0][filters][0][field]","search_term")
                .queryParam("searchCriteria[filter_groups][0][filters][0][field]","Search_DigitalWatch");


        Response response = request.when().get();

        String responseString = response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .assertThat()
                .body
                        .extract()
                        .body().asString();
        System.out.println("Response String is: "
                + responseString);





    }

}

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
public class Search_DigitalWatch {
    private  static String sessionToken ="t3cqquyhj4auihcfcvypcme999br6mf5";
    public static String baseUri = "https://magento.abox.co.za/rest/V1/";
    public static void main(String[]args){
        Map<String, String> headers = new HashMap<>(); //Hash Map.
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", sessionToken);
        RequestSpecification request = given()
                .headers(headers)
                .baseUri(baseUri)
                .basePath("search")
                .queryParam("searchCriteria[requestName]","quick_search_container")
                .queryParam("searchCriteria[filter_groups][0][filters][0][field]","search_term")
                .queryParam("searchCriteria[filter_groups][0][filters][0][value]","digital watch");
        Response response = request.when().get();
        String responseString;
        responseString = response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .assertThat()
                .body("total_count",equalTo(9))
                .extract()
                .body().asString();
        System.out.println("Response String is: " + responseString);
    }
    // Project for API
//===============
    // Take the code we worked on
    // and convert it to cucumber-gherkin format
    // Given that the customer is on the Home page
    //And enters a product name in the search field
    //When the customers clicks the search icon to search
    //Then the system should return a list of search results
}
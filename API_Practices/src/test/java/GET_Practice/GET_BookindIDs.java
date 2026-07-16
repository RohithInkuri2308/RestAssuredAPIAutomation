package GET_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_BookindIDs {
	 public static void main(String[] args) {
	 Response res = RestAssured
             .given()
             .when()
             .get("https://restful-booker.herokuapp.com/booking");
	 
	 String body = res.getBody().asString();

     System.out.println("Response Body: " + body);
     System.out.println("Status Code: " + res.getStatusCode());

	 }
}

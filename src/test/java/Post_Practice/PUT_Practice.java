package Post_Practice;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class PUT_Practice {

	public static void main(String[] args) {
//		String token =
//				RestAssured
//				    .given()
//				    .contentType("application/json")
//				    .body("{\"username\":\"admin\",\"password\":\"password123\"}")
//				.when()
//				    .post("https://restful-booker.herokuapp.com/auth")
//				.then()
//				    .statusCode(200)
//				    .extract()
//				    .path("token");
//
//				System.out.println("Token: " + token);

				int bookingID=3490;
		Map<String, Object> bookingDates = new HashMap<>();
		bookingDates.put("checkin", "2024-02-01");
		bookingDates.put("checkout", "2024-02-10");

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("firstname", "RohithSharma");   
		requestBody.put("lastname", "Inkuri");
		requestBody.put("totalprice", 2000);
		requestBody.put("depositpaid", true);
		requestBody.put("bookingdates", bookingDates);
		requestBody.put("additionalneeds", "Breakfast");

		RestAssured
		    .given()
		    .baseUri("https://restful-booker.herokuapp.com")
		    .contentType("application/json")
		 //   .header("Cookie", "token=" + token)  
		    .body(requestBody)
		.when()
		    .put("/booking/"+bookingID)
		.then()
		    .statusCode(403)
		    .log().all();

	}

}

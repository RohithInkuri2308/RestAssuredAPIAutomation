package Post_Practice;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_Booking {

	public static void main(String[] args) {
		
		Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-02-01");
        bookingDates.put("checkout", "2024-02-10");
        
		Map<String, Object>requestbody=new HashMap<String, Object>();
		requestbody.put("firstname", "Rohith");
		requestbody.put("lastname", "Inkuri");
		requestbody.put("totalprice", 2000);
		requestbody.put("depositpaid", true);
		requestbody.put("bookingdates", bookingDates);
		requestbody.put("additionalneeds", "BreakFast");
		
		Response res=RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.header("Content-Type", "application/json")
				.body(requestbody)
                .when()
                .post("/booking")
				.then()
				.statusCode(201)
				.extract()
				.response();

        System.out.println("Response:");
        res.prettyPrint();
	}

}

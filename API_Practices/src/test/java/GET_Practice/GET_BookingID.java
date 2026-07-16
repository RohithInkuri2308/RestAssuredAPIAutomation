package GET_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_BookingID {

	public static void main(String[] args) {
		Response res=RestAssured
				.given()
				.pathParam("bookingid", 3490)
				.when()
				.get("https://restful-booker.herokuapp.com/booking/{bookingid}");
				
				
		String body=res.getBody().asString();
		System.out.println(body);
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		System.out.println(res.getStatusLine());
	}

}

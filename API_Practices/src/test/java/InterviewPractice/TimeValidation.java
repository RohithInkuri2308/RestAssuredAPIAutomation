package InterviewPractice;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TimeValidation extends RequestSpec_Base{

	public static void main(String[] args) {
		Response res=RestAssured
				.given()
				.spec(reqspec)
				.when()
                .get("users")
                .then().statusCode(200)
                .time(lessThan(2000L),TimeUnit.MILLISECONDS)
                .extract().response();
		System.out.println("Responded below 2000ms");
	}

}

package InterviewPractice;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsers extends RequestSpec_Base{
	public static void main(String args[]) {
		
		
		Response res=RestAssured
			.given().spec(reqspec)
            .when()
            .get("users/13")
            .then()
            .statusCode(200)
            .extract()
            .response();
		
		int id=res.jsonPath().getInt("id");
		String name=res.jsonPath().getString("name");
		String email=res.jsonPath().getString("email");
		
		
		List<String>names=RestAssured
				.given()
				.spec(reqspec)
				.when()
				.get("users")
				.then()
				.extract()
				.path("name");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		
		System.out.println("All names: "+names);
	}
}

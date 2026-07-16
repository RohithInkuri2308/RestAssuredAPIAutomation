package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class JWTtoken {

	String baseURL = "https://dummyjson.com";
	String token;

	@Test(priority = 1)
	public void generateJWTToken() {

		RestAssured.baseURI = baseURL;

		Map<String, String> payload = new HashMap<>();
//		payload.put("username", "emilys");
//		payload.put("password", "emilyspass");
		
		payload.put("username", "kminchelle");
		payload.put("password", "0lelplR");
		
		Response response =
				given()
				.contentType("application/json")
				.body(payload)
				.log().all()
				.when()
				.post("/auth/login")	
				.then()
				.log().all()
				.statusCode(200)
				.extract().response();

		// Extract JWT Token
		token = response.jsonPath().getString("token");

		System.out.println("Generated Token: " + token);
	}

	@Test(priority = 2, dependsOnMethods = "generateJWTToken")
	public void createProductWithJWT() {

		RestAssured.baseURI = baseURL;

		Map<String, Object> requestBody = new HashMap<>();

		requestBody.put("title", "iPhone 15");
		requestBody.put("description", "Test product");
		requestBody.put("price", 999);

		given()
		.header("Content-Type", "application/json")
		.header("Authorization", "Bearer " + token)
		.body(requestBody)
		.when()
		.post("/products/add")
		.then()
		.statusCode(201)
		.body("title", equalTo("iPhone 15"));

		System.out.println("Product created successfully with JWT!");
	}
}




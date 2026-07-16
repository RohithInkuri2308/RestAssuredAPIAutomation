package InterviewPractice;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenPractice extends RequestSpec_Base{

	public static void main(String[] args) {
		Response res = null;
		Map<String,String>UserData=new LinkedHashMap<String, String>();
		UserData.put("name","Chiru");
		UserData.put("email","chiru@gmail.com");
		UserData.put("role","user");
		UserData.put("password","chiru@123");
		String token=RestAssured
				.given()
				.spec(reqspec)
				.body(UserData)
				.when()
				.post("users")
				.then()
				.statusCode(201)
				.extract()
				.path("accessToken");

		System.out.println("Token: "+token);
		
		RestAssured
		.given()
		.spec(reqspec)
		.header("Authorization","Bearer" +token)
		.when()
		.get("users")
		.then()
		.statusCode(200)
		.extract().response();
		
		System.out.println("Response:");
		res.prettyPrint();

	}

}

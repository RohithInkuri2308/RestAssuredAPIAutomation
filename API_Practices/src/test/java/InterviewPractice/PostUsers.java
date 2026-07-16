package InterviewPractice;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostUsers extends RequestSpec_Base {

	public static void main(String[] args) {

		Map<String,String>userData=new LinkedHashMap<String, String>();
		userData.put("name","PavanKalyan");
		userData.put("email","Pk@gmail.com");
		userData.put("role","user");
		userData.put("password","mahesh@123");
		Response res=RestAssured	
				.given()
				.spec(reqspec)
				.body(userData)
				.when()
				.post("users")
				.then()
				.statusCode(201)
				.extract()
				.response();

		System.out.println("Response:");
		res.prettyPrint();

	}

}

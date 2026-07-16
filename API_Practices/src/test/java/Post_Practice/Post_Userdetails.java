package Post_Practice;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post_Userdetails {

	public static void main(String[] args) {
		
		Map<String, Object>map=new HashMap<>();
		map.put("id", 7);
		map.put("email", "abc@jaffa.com");
		map.put("role", "user");
		map.put("password", "jaffa@123");
		
		Response res=RestAssured
				.given()
				.baseUri("http://localhost:2308")
				.header("Content-Type","application/json")
				.body(map)
				.when()
				.post("/users");
		System.out.println(res.statusCode());

	}

}

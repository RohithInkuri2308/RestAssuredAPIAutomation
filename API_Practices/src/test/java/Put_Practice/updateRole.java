package Put_Practice;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class updateRole {

	public static void main(String[] args) {
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("email", "abc@jaffa.com");
		map.put("role", "admin");
		map.put("password", "abc@5435");
		
		Response res=RestAssured
				.given().baseUri("http://localhost:2308")
				.contentType("application/json")
				.body(map)
				.when()
				.put("/users/7")
				;
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());

	}

}

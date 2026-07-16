package Post_Practice;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1 {

	public static void main(String[] args) {
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("name","raghu");
		map.put("email","raghu@gmail.com");
		map.put("password","raghu@123");
		map.put("role","tester");
		
		Response res=RestAssured
				.given()
				.baseUri("http://localhost:2308")
				.header("Content-Type", "application/json")
				.body(map)
				.when()
				.post("/users")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.response();
		
		System.out.println(res.statusCode());
				

	}

}

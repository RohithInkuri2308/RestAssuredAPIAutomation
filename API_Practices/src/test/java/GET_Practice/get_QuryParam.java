package GET_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class get_QuryParam {

	public static void main(String[] args) {
		Response res=RestAssured
		.given()
		.baseUri("http://localhost:2308/")
		.queryParam("id_gte", 1)
		.queryParam("id_lte", 6)
		.when()
		.get("users")
		.then()
		.statusCode(200).extract().response();
		
		System.out.println(res.asString());
	}

}

package GET_Practice;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Assertion {

	public static void main(String[] args) {
		Response res=RestAssured
				.given()
				.baseUri("http://localhost:2308/")
				.when()
				.get("users/3")
				.then()
				.extract().response();
		
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(res.getStatusCode(),200);
		sa.assertNotNull(res.jsonPath().getString("name"));
		sa.assertNotNull(res.jsonPath().getString("id"));
		sa.assertTrue(res.jsonPath().getString("email").contains("@"),"Invalid Email");
		
		sa.assertAll();
		System.out.println("All data is correct");
				
	}

}

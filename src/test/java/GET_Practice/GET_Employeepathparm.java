package GET_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Employeepathparm {
	public static void main(String args[]) {
		Response res=RestAssured
				.given()
				.pathParam("id",14)
				.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/{id}");
		
		String body=res.getBody().asString();
		System.out.println(body);
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		System.out.println(res.getStatusLine());
	}

}

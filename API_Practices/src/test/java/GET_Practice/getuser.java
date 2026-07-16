package GET_Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getuser {

	public static void main(String[] args) {
		
             Response res = RestAssured
                     .given()
                     .when()
                     .get("http://localhost:2308/users/1");
        	 
        	 String body = res.getBody().asString();

             System.out.println("Response Body: " + body);
             System.out.println("Status Code: " + res.getStatusCode());
	}

}

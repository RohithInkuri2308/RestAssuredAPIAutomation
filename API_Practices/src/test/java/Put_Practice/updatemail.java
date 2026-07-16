package Put_Practice;


import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class updatemail {
     public static void main(String args[]) {
    	 
       	 Map<String, Object> request = new HashMap<>();
    	 request.put("name", "alicekumar");
         request.put("email", "alice@inphosis.com");
        
         Response response = RestAssured
                 .given()
                     .baseUri("http://localhost:2308/")
                     .contentType("application/json")
                     .body(request)
                 .when()
                     .patch("users/11");

         
         System.out.println("Status Code: " + response.getStatusCode());
     }
 
	
}

package Post_Practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POJO extends BaseTest{
	
	@Test
	public void PostDatausingPOJO() {
		User newUser=new User("Charlie","Charlie1@test.com","Charle@123");
		
	Response response=given(authSpec)
		.contentType(ContentType.JSON)
		.body(newUser)
		.when()
		.post("users")
		.then()
		.statusCode(201)
		.extract().response();
	
	int id=response.jsonPath().getInt("id");
	System.out.println("Created user ID: "+id);
		
		User fetch=given(authSpec)
				.when()
				.get("users/"+id)
				.then()
				.statusCode(200)
				.extract()
				.as(User.class);
		
		System.out.println("Name: "+fetch.getName());
		System.out.println("Email:"+fetch.getEmail());
		
		assertEquals(fetch.getName(),"Charlie");
				
		
		
	}
	
	
    
}

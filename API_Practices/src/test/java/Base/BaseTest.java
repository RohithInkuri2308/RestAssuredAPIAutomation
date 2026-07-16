package Base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {


	 protected RequestSpecification authSpec;
		
		@BeforeClass
		public void setUp() {
			RestAssured.baseURI="http://localhost:2308/";
			
			authSpec=new RequestSpecBuilder()
		            .setBaseUri("http://localhost:2308/")
		            .setContentType("application/json")
		            .build();
		}
	
	}



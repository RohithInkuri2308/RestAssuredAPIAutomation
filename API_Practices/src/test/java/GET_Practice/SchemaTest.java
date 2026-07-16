package GET_Practice;

import org.testng.annotations.Test;

import Base.BaseTest;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaTest extends BaseTest{

	@Test
	public void testsingleUserSchema() {
		given(authSpec)
		.when()
		.get("users/12")
		.then()
		.statusCode(200)
		.body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
		
		System.out.println("schema validation passed for used id 12");
		
	}

	
}

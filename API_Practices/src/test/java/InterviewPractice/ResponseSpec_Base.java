package InterviewPractice;

import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec_Base {

	public static ResponseSpecification resSpec=new ResponseSpecBuilder()

			.expectStatusCode(200)
			.expectHeader("Content-Type","application/Json")
			.build();
}

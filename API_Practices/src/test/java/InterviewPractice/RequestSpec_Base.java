package InterviewPractice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec_Base {


	public static RequestSpecification reqspec=new RequestSpecBuilder()
			.setBaseUri("http://localhost:2308/")
			.addHeader("Content-Type","application/json")
			.build();
}

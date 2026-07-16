package InterviewPractice;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getUsersmethod {

	public static void main(String[] args) {
		Response res;
		Header h1=new Header("Accept","application/json");
		res=RestAssured.given().header(h1)
				.get("http://localhost:2308/users");
		JsonPath path=res.jsonPath();
		List<String>allnames=path.getList("name");
		for(int i=0;i<allnames.size();i++) {
			System.out.println("Name: "+allnames.get(i));
		}

	}

}

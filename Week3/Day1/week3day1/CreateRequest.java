package week3day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRequest {
	
	@Test
	public void create() {
		RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		RequestSpecification input = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.when()
		.body("{\r\n"
				+ "    \"short_description\": \"Updated Short Description\"\r\n"
				+ "}");
		
		Response resp = input.post();
		
		int statucCode = resp.statusCode();
		System.out.println("Status code is: " + statucCode);
		resp.prettyPrint();
	}
	
}

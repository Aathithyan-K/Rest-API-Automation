package week3day2;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import week3day2.chaining.BaseClass;

public class CreateIncident extends BaseClass {
	
	@Test
	public void create() {
		
		
		//Add Request
		
		 reqSpec = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.when().body("{\r\n"
				+ "    \"short_description\": \"test description\",\r\n"
				+ "    \"work_notes\": \"created by\"\r\n"
				+ "}");
		
		// Send Request 
		
		 response = reqSpec.post();
		//	response.then().assertThat().statusCode(Matchers.equalTo(200));
		 sys_ID = response.jsonPath().get("result.sys_id");
		 
		  incNum = response.jsonPath().get("result.number");
		System.out.println("The Extracted Sysid is -------"+sys_ID);
		
		int statusCode = response.statusCode();
		
		response.then().assertThat().statusCode(Matchers.equalTo(201));
		
	}

}

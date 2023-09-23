package week3day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void get() {
		RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		RequestSpecification queryParam = RestAssured.given()
		.queryParam("sysparm_fields", "short_description,sys_id");
		
		Response response = queryParam.get();
		response.prettyPrint();
	}
	
}

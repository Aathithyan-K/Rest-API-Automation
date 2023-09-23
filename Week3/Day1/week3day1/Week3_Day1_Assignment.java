package week3day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Week3_Day1_Assignment {
	
	@Test
	public void getAllRequest() {
		RestAssured.baseURI = "https://dev169546.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		Map<String, String> queryParms = new HashMap<String, String>();
		queryParms.put("sysparm_fields", "short_description,sys_id");
		queryParms.put("sysparm_limit", "10");
		
		RequestSpecification params = RestAssured.given()
		.queryParams(queryParms);
		
		Response response = params.get();
		
		response.prettyPrint();
	}
	
}

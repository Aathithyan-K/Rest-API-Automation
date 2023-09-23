package week3day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleQueryParam {
	
	@Test
	public void mutliGet() {
		RestAssured.baseURI = "https://dev169546.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		Map<String, String> queryParam = new HashMap<String, String>();
		queryParam.put("sysparm_fields", "short_description,sys_id");
		queryParam.put("sysparm_limit", "1");
		
		RequestSpecification queryParams = RestAssured.given()
		.queryParams(queryParam);
		
		Response response = queryParams.get();
		response.prettyPrint();
	}
}

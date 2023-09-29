package week3day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import week3day2.chaining.BaseClass;

public class GetAllIncidentsValidateDescription extends BaseClass{
	
	@Test(dependsOnMethods = "week3day2.CreateIncident.create")
	public void getIncident() {
		
		reqSpec = RestAssured.given()
		.contentType("application/json");
		
		response = reqSpec.get();

		JsonPath jsonPath = response.jsonPath();
		List<String> lstSysId = jsonPath.getList("result.sys_id"); 
		
		// Get the first one
		sys_ID = lstSysId.get(0);
		System.out.println(sys_ID);

	
	}

}

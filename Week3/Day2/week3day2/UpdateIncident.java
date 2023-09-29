package week3day2;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import week3day2.chaining.BaseClass;

public class UpdateIncident extends BaseClass {

	@Test(dependsOnMethods = "week3day2.CreateIncident.create") 
	public void update() {


		// Add Request

		reqSpec = RestAssured.given()
				.contentType("application/json")
				.when()
				.body("{\"short_description\":\"Updated via RestAssured\"}");

		//Send Request

		response = reqSpec.put("/"+sys_ID);

		response.prettyPrint();
		
		int statusCode = response.statusCode();
		
		response.then().assertThat().statusCode(Matchers.equalTo(200));

	}

}


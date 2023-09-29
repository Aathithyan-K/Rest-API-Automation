package week3day2;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import week3day2.chaining.BaseClass;

public class FileDataStatusCodeValidation extends BaseClass{
	
	@Test
	public void FileDataImportAndValidation() {
RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		RequestSpecification input = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.when()
		.body("{\r\n"
				+ "    \"short_description\": \"Sample short description.\"\r\n"
				+ "}");
		
		Response resp = input.put("/" +sys_ID);
		
		int statucCode = resp.statusCode();
		System.out.println("Status code is: " + statucCode);
		resp.prettyPrint();
		
		resp.then()
		.assertThat()
		.statusCode(Matchers.equalTo(200));
	}
}

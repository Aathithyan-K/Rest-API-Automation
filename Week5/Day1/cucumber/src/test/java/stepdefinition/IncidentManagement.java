package stepdefinition;

import java.io.File;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagement {

	public static String sys_Id;
	public static RequestSpecification reqSpec;
	public static Response resp;
	
	
	@Given("Set the endpoint")
	public void setEndPoint() {
		RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
	}
	
	@Given("Set the Auth")
	public void setAuthentication() {
		RestAssured.authentication=RestAssured.basic("admin", "mnGdG3T@M9-a");
	}
	
	@When("Create Incident with String Body {string}")
	public void createIncident(String body) {
		reqSpec=RestAssured.given()
				.contentType("application/json")
				.body(body);
		resp=reqSpec.post();
	}
	
	@When("Create Incident with File {string}")
	public void createMoreIncident(String fileName) {
		File file = new File("./src/test/resources/"+fileName);
		reqSpec = RestAssured.given()
				.contentType("application/json")
				.body(file);
		resp = reqSpec.post();
		sys_Id = resp.jsonPath().get("result.sys_id");
	}
	
	@When("Update Incident with File {string}")
	public void updateIncident(String fileName) {
		File file = new File("./src/test/resources/"+fileName);
		reqSpec = RestAssured.given()
				.contentType("application/json")
				.body(file);
		resp = reqSpec.put("/"+sys_Id);
	}
	
	@When("Get Incidents Request")
	public void getIncident() {
		resp=RestAssured.get("/"+sys_Id);
	}
	
	@When("Delete Incident")
	public void deleteIncident() {
		
		resp=RestAssured.delete("/"+sys_Id);
		
	}
	
	@Then("Validate the status code {int}")
	public void validateStatusCode(int statusCode) {
		resp.then()
		.assertThat()
		.statusCode(statusCode);
	}
	
}

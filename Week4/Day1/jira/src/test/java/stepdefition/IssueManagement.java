package stepdefition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IssueManagement {

	public static RequestSpecification req;
	public static Response resp;
	public static String sysId;
	
	@Given("Set the endpoint")
	public void set_the_endpoint() {
		RestAssured.baseURI = "https://aathithyan-kaliyamoorthy.atlassian.net/rest/api/2/issue/";
	}
	@Given("User Authentication")
	public void user_authentication() {
		RestAssured.authentication = RestAssured.preemptive().basic("aathithyankaliyamoorthy@gmail.com", "ATATT3xFfGF06PD_zYSrVmUappgX2yhldhagXwYwS5bvCDs9nrLAwuzswDwBGiqa3dfYe3ic5a5BInXTmiA7zwTLXIYW5_0I6waiHyKPDGIKzwPEjoVcaeLFoaYt5E8l-1JS6Xeff0Cglir2r87MZ9y7_ZLH56luyEIZADX8u_tzAMto117yn4M=03956C33");
	}
	@When("Create Issue")
	public void create_issue() {
		req = RestAssured.given()
				.contentType("application/json")
				.body("{\r\n"
						+ "  \"fields\": {\r\n"
						+ "    \"project\": {\r\n"
						+ "      \"key\": \"RES\"\r\n"
						+ "    },\r\n"
						+ "    \"summary\": \"create issue in REST API project\",\r\n"
						+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API by Aathithyan\",\r\n"
						+ "    \"issuetype\": {\r\n"
						+ "      \"name\": \"Bug\"\r\n"
						+ "    }\r\n"
						+ "  }\r\n"
						+ "}");
		resp = req.post();
		
		sysId = resp.jsonPath().get("id");
		System.out.println("Jira Issue ID: " + sysId);
		
		resp.prettyPrint();
	}
	
	@When("Retrieve the request")
	public void retrieve_the_request() {
		System.out.println("Jira Issue ID: " + sysId);
	    resp = req.get(sysId);
	    resp.prettyPrint();
	}
	
	@When("Update the request (.*)$")
	public void update_the_request(String reqBody) {
		System.out.println("Jira Issue ID: " + sysId);
		req.given()
		.contentType("application/json")
		.body(reqBody);
		resp = req.put(sysId);
	    resp.prettyPrint();
	}
	
	@Then("Validate Status Code {int}")
	public void validate_status_code(Integer status) {
		int statusCode = resp.statusCode();
		System.out.println("Status Code: " + statusCode);
		if(status==statusCode) {
			System.out.println("Issue Created Successfully!");
		}
	}
}

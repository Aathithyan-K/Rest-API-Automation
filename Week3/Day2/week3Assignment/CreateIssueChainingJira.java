package week3Assignment;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateIssueChainingJira extends BaseChainingJira {
	
	@Test
	public void createIssue() {
		System.out.println("CreateIssueChainingJira Class CreateIssue() Running");
		File file = new File("./src/test/resources/CreateIssue.json");
		
		req = RestAssured.given()
			.contentType("application/json")
			.when()
			.body(file);
		
		resp = req.post();
		
		int statusCode = resp.getStatusCode();
		
		issueId = resp.jsonPath().get("id");
		resp.then().assertThat().statusCode(Matchers.equalTo(201));
		
		System.out.println("Jira Issue ID: " + issueId);
		System.out.println("Status Code: " + statusCode);
		System.out.println(resp.prettyPrint());
	}

}

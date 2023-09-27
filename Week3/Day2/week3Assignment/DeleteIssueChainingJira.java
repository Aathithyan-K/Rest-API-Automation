package week3Assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssueChainingJira extends BaseChainingJira{

	@Test(dependsOnMethods = "week3Assignment.CreateIssueChainingJira.createIssue")
	public void deleteIssue() {
		System.out.println("DeleteIssueChainingJira Class deleteIssue() Running");
		req = RestAssured.given()
				.contentType("application/json");
		
		resp = req.delete(issueId);
		
		System.out.println("Status Code: " +resp.getStatusCode());
		
		resp.then().assertThat().statusCode(Matchers.equalTo(204));
	}
}

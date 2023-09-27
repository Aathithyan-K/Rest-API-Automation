package week3Assignment;

import java.io.File;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;


public class UpdateIssueChainingJira extends BaseChainingJira{

	
	@Test(dependsOnMethods = "week3Assignment.CreateIssueChainingJira.createIssue")
	public void updateIssue() {
		System.out.println("UpdateIssueChainingJira Class updateIssue() Running");
		
		File file = new File("./src/test/resources/UpdateIssue.json");
		System.out.println("Jira Issue ID: " + issueId);
		
		req = RestAssured.given()
				.contentType("application/json")
				.when()
				.body(file);
		
		resp = req.put("/"+issueId);
		
		int statusCode = resp.getStatusCode();
		System.out.println("Issue ID: " + issueId);
		System.out.println("Status code: " + statusCode);
		resp.then().assertThat().statusCode(Matchers.equalTo(204));
		resp.prettyPrint();
	}
	
}

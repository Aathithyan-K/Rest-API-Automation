package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;

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
	
	
//	@Given("Set the endpoint")
//	public void set_the_endpoint() {
//		RestAssured.baseURI = "https://aathithyan-kaliyamoorthy.atlassian.net/rest/api/2/issue/";
//	}
//	@Given("User Authentication")
//	public void user_authentication() {
//		RestAssured.authentication = RestAssured.preemptive().basic("aathithyankaliyamoorthy@gmail.com", "ATATT3xFfGF06PD_zYSrVmUappgX2yhldhagXwYwS5bvCDs9nrLAwuzswDwBGiqa3dfYe3ic5a5BInXTmiA7zwTLXIYW5_0I6waiHyKPDGIKzwPEjoVcaeLFoaYt5E8l-1JS6Xeff0Cglir2r87MZ9y7_ZLH56luyEIZADX8u_tzAMto117yn4M=03956C33");
//	}
	
	@When("Create Issue")
	public void create_issue() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		System.out.println("https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/"+prop.getProperty("issue"));
		System.out.println("Base URI: " + RestAssured.baseURI);
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
		resp = req.post("/" + prop.getProperty("issue"));
		
		sysId = resp.jsonPath().get("id");
		System.out.println("Jira Issue ID: " + sysId);
		
		System.out.println("Create Request Status Code: " + resp.getStatusCode());
		
//		resp.prettyPrint();
		System.out.println("End of the Create Request");
	}
	
	@Given("Jira Set the endpoint")
	public void jira_set_the_endpoint() throws FileNotFoundException, IOException {
		System.out.println("Start of the Set End point for Get All Request");
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		System.out.println("URL: " + "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+prop.getProperty("search")+"/");
		
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/"+prop.getProperty("search")+"/";
		
		System.out.println("End of the Set End point for Get All Request");
	}
	
	@When("Retrieve All the requests")
	public void retrieve_all_the_requests() throws FileNotFoundException, IOException {
	    
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		System.out.println("Start of the Get All Request");
		
		req = RestAssured.given()
				.queryParam("jql", "project=RestAPIAutomation");
	    resp = req.get("/"+prop.getProperty("search"));
//	    resp.prettyPrint();
	    
	    System.out.println("Get All Request Status Code: " + resp.getStatusCode());
	    
	    System.out.println("End of the Get All Request");
	    
	}
	
	@When("Retrieve the request")
	public void retrieve_the_request() throws FileNotFoundException, IOException {
		System.out.println("Start of the Get Request");
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		System.out.println("Jira Issue ID: " + sysId);
	    resp = req.get(prop.getProperty("issue")+"/"+sysId);
	    resp.prettyPrint();
	    
	    System.out.println("Get Request Status Code: " + resp.getStatusCode());
	    
	    System.out.println("End of the Get Request");
	}
	
	@When("Update the request (.*)$")
	public void update_the_request(String reqBody) throws FileNotFoundException, IOException {
		File file = new File("./src/test/resources/"+reqBody);
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		System.out.println("Start of the Update Request");
		
		System.out.println("Request Body: " + file);
		System.out.println("Jira Issue ID: " + sysId);
		req.given()
		.contentType("application/json")
		.body(file);
		resp = req.put(prop.getProperty("issue")+"/"+sysId);
	    
	    System.out.println("Update Request Status Code: " + resp.getStatusCode());
	    
	    String contentType = resp.contentType();
	    System.out.println("Content Type: " + contentType);
	    
	    resp.then().assertThat().contentType("application/json");
	    String[] list = contentType.split(";");
	    if(list[0].equals("application/json")) {
	    	System.out.println("Content Type Matched");
	    }
	    else {
	    	System.out.println("Content Type Mismatched");
	    }
	    
	    System.out.println("End of the Update Request");
	}
	
	@When("Delete Issue")
	public void delete_issue() throws FileNotFoundException, IOException {
		System.out.println("Start of the Delete Request");
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		
		System.out.println("Jira Issue ID: " + sysId);
	    resp = req.delete(prop.getProperty("issue")+"/"+sysId);
//	    resp.prettyPrint();
	    
	    System.out.println("Get Request Status Code: " + resp.getStatusCode());
	    
	    System.out.println("End of the Delete Request");
	}
	
	
	@Then("Validate Status Code {int}")
	public void validate_status_code(Integer status) {
		
		System.out.println("Start of the Status Validation");
		
		int statusCode = resp.statusCode();
		System.out.println("Status Code: " + statusCode);
		if(status==statusCode) {
			System.out.println("Issue Created Successfully!");
		}
		resp.then().assertThat().statusCode(Matchers.equalTo(status));
		
		System.out.println("End of the Status Validation");
	}
}

package week3day2.chaining;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static String sys_ID;
	public RequestSpecification reqSpec;
	public static Response response;
	public static String incNum;
	
	@BeforeMethod
	public void setUp() {
		
		// End point
		RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
		
		//Authentication
		
         RestAssured.authentication=RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		//RestAssured.authentication=RestAssured.preemptive().basic("jirausername", "jirakey");
		
		
		
	}

}
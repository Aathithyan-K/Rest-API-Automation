package week3day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateDeleteRequestSuccess {
	
	@Test
	public void deleteValidate() {
		RestAssured.baseURI="https://dev169546.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "mnGdG3T@M9-a");
		
		Response resp = RestAssured.delete("/fde647442fa1311081e256f62799b62e");
		
		int statucCode = resp.statusCode();
		System.out.println("Status code is: " + statucCode);
		resp.prettyPrint();
	}
}

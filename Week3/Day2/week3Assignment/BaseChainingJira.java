package week3Assignment;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseChainingJira {

	public static String issueId;
	public static RequestSpecification req;
	public static Response resp;
	
	@BeforeMethod
	public void preCondition() {
		System.out.println("BaseChainingJira Class preCondition() Running");
		RestAssured.baseURI = "https://aathithyan-kaliyamoorthy.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().basic("aathithyankaliyamoorthy@gmail.com", "ATATT3xFfGF06PD_zYSrVmUappgX2yhldhagXwYwS5bvCDs9nrLAwuzswDwBGiqa3dfYe3ic5a5BInXTmiA7zwTLXIYW5_0I6waiHyKPDGIKzwPEjoVcaeLFoaYt5E8l-1JS6Xeff0Cglir2r87MZ9y7_ZLH56luyEIZADX8u_tzAMto117yn4M=03956C33");
		
		
	}
}

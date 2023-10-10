package tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateIncident_NegativeTestcase extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident with Rest Assured";
		testDescription = "Create a new Incident and Verify response Code";
		nodes = "Incident";
		authors = "Shan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
		//for reports		
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(authors);
		svcTest.assignCategory(category);	
		RestAssured.authentication = RestAssured.basic("admin","test123");
		RestAssured.baseURI = "https://"+ConfigurationManager.configuration().server()+"/"+ConfigurationManager.configuration().resources()+"/"; 
	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {		

		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().incident());
		verifyResponseCode(response, ConfigurationManager.configuration().unAuthorizedUser());
		response.prettyPrint();

	}


}





















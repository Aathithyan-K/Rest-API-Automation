package tests.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateIncident_Demo extends RESTAssuredBase{
	
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

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) throws FileNotFoundException, IOException {		
		
		Response response =
		postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().incident());
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPost());
		response.prettyPrint();
	}


}





















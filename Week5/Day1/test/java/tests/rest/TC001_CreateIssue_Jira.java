package tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;

public class TC001_CreateIssue_Jira extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Issue in Jira";
		testDescription = "Create a new Issue and Verify response Code";
		nodes = "Issue";
		authors = "Aathithyan";
		category = "REST";
		//dataProvider
		dataFileName = "CreateIssue";
		dataFileType = "JSON";
	}
	
	@Test(dataProvider = "fetchData")
	public void createIssue(File file) throws FileNotFoundException, IOException {		
		
		Response response =
		postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().issue());
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPost());
		issue_id = response.jsonPath().get("id");
	}

}

package tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;

public class TC003_GetIssue_Jira extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Get Issue in Jira";
		testDescription = "Get Issue and Verify response Code";
		nodes = "Issue";
		authors = "Aathithyan";
		category = "REST";
		//dataProvider
		dataFileName = "GetIssue";
		dataFileType = "JSON";
	}
	
	@Test(dependsOnMethods = "tests.rest.TC001_CreateIssue_Jira.createIssue")
	public void getIssue() throws FileNotFoundException, IOException {		
		
		Response response = get(ConfigurationManager.configuration().issue()+"/"+issue_id);
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforGet());
	}
}

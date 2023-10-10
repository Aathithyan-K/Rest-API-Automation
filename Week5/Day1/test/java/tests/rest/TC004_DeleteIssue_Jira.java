package tests.rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;

public class TC004_DeleteIssue_Jira extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Delete Issue in Jira";
		testDescription = "Delete Issue and Verify response Code";
		nodes = "Issue";
		authors = "Aathithyan";
		category = "REST";
		//dataProvider
		dataFileName = "DeleteIssue";
		dataFileType = "JSON";
	}
	
	@Test(dependsOnMethods = "tests.rest.TC001_CreateIssue_Jira.createIssue")
	public void deleteIssue() throws FileNotFoundException, IOException {		
		
		Response response = get(ConfigurationManager.configuration().issue()+"/"+issue_id);
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforDelete());
	}
}

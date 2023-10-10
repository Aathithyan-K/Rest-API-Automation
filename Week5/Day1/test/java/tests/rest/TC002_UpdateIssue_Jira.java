package tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;

public class TC002_UpdateIssue_Jira extends RESTAssuredBase{

	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update Issue in Jira";
		testDescription = "Update Issue and Verify response Code";
		nodes = "Issue";
		authors = "Aathithyan";
		category = "REST";
		//dataProvider
		dataFileName = "UpdateIssue";
		dataFileType = "JSON";
	}
	
	@Test(dataProvider = "fetchData", dependsOnMethods = "tests.rest.TC001_CreateIssue_Jira.createIssue")
	public void updateIssue(File file) throws FileNotFoundException, IOException {		
		
		Response response =
		putWithBodyParam(file, ConfigurationManager.configuration().issue()+"/"+issue_id);
		System.out.println("Response for update");
		response.prettyPrint();
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPut());
	}
}

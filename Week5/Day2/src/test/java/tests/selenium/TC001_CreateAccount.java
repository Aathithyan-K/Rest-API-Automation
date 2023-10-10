package tests.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import freemarker.template.Configuration;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateAccount extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create Account";
		testDescription = "Create Account and Verify response Code";
		nodes = "Accounts";
		authors = "Aathithyan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001_Accounts";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void updateIncident(File file) throws FileNotFoundException, IOException {		
		
             
	Response response = postWithHeader(id,file,ConfigurationManager.configuration().accounts());
    verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPost());
	}


}





















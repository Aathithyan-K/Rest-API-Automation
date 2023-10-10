package pages.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;
import lib.selenium.PreAndPost;

public class CreateNewIncident extends PreAndPost{
	
	public CreateNewIncident(EventFiringWebDriver driver, ExtentTest test) throws InterruptedException {	
		this.driver = driver;
		this.test = test;
		Thread.sleep(6000);
		//driver.switchTo().defaultContent();
		WebElement newButton = (WebElement) driver.executeScript("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"#gsft_main\")");
		//WebElement iframe = newButton.findElement(By.cssSelector("driver.findElement(By.cssSelector('.sysverb_new'));"));
		//driver.switchTo().frame("gsft_main");
		driver.switchTo().frame(newButton);
		PageFactory.initElements(driver,this);
		
	}
	
	//private WebElement newButton = (WebElement) driver.executeScript("return document.querySelector(\"#sysverb_new\")");
	
	
	
	@FindBy(id="incident.number") 
	private WebElement eleIncidentNumber;	
	
	@FindBy(id="sys_display.incident.caller_id")
	private WebElement eleCallerId;	
	
	@FindBy(how=How.ID,using="incident.short_description")
	private WebElement eleShortDescription;

	
	public CreateNewIncident clickNewButton() {
		driver.findElement(By.id("sysverb_new")).click();
		return this;
	}
	
	public CreateNewIncident getIncidentNumber() {	
		incidentNumber = getAttribute(eleIncidentNumber,"value");
		return this;
	}	

	public CreateNewIncident selectUser(String data) {
		typeAndChoose(eleCallerId, data);
		return this;
	}	
	
	public CreateNewIncident typeShortDescription(String data) {
		type(eleShortDescription, data);
		return this;		
	}
	
	public CreateNewIncident clickSubmit() {
		WebElement eleSubmit = locateElement("sysverb_insert");
		click(eleSubmit);
		return this;		
	}
	
}

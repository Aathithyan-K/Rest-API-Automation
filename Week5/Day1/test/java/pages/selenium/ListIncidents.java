package pages.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;
import lib.selenium.PreAndPost;

public class ListIncidents extends PreAndPost{
	
	public ListIncidents(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("gsft_main");
		WebElement newButton = (WebElement) driver.executeScript("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"#gsft_main\")");
		//WebElement iframe = newButton.findElement(By.cssSelector("driver.findElement(By.cssSelector('.sysverb_new'));"));
		//driver.switchTo().frame("gsft_main");
		driver.switchTo().frame(newButton);
		PageFactory.initElements(driver,this);
	}
	 
	@FindBy(xpath="(//input[@class='form-control'])[1]") 
	private WebElement eleSearch;	
	
	@FindBy(xpath="//span[@id='incident_hide_search']//select") 
	private WebElement eleSearchDD;	
	
	public ListIncidents typeAndEnterSearch(String data) throws InterruptedException {	
		typeAndEnter(eleSearch,data);
		return this;
	}	
	
	public ListIncidents selectSearchDD(String data) {	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectDropDownUsingVisibleText(eleSearchDD, data);
		return this;
	}	
	
	
}

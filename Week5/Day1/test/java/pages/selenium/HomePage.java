package pages.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;
import lib.selenium.PreAndPost;

public class HomePage extends PreAndPost{

	public HomePage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;	
		driver.switchTo().defaultContent();
		PageFactory.initElements(driver, this);
	}		

	public HomePage searchUsingFilter(String value) throws InterruptedException {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		shadowDOMClick("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"#all\")");
		Thread.sleep(3000);
		shadowDOMClick("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu:nth-child(1)\").shadowRoot.querySelector(\"nav > div.sn-polaris-nav.all.can-animate.keyboard-navigatable > div.sn-polaris-nav-header.all.can-animate > div.sn-polaris-nav-header-controls.pin > button > now-icon\").shadowRoot.querySelector(\"svg\")");
		shadowDOMClick("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu:nth-child(1)\").shadowRoot.querySelector(\"#filter\")");
		Thread.sleep(3000);
		shadowDomtype(("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu:nth-child(1)\").shadowRoot.querySelector(\"#filter\")"),value);
		return this; 
	}	
	
	
	@FindBy(linkText="Create New")
	//WebElement eleCreateNew = (WebElement) this.driver.executeScript("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu.can-animate.is-main-menu.is-open\").shadowRoot.querySelector(\"nav > div.sn-polaris-nav.all.can-animate.keyboard-navigatable > div.sn-tree-menu.sn-polaris-nav-content > div.sn-polaris-tab-content.-left.is-visible.can-animate > div > sn-collapsible-list:nth-child(1)\").shadowRoot.querySelector(\"div > div > ul > li:nth-child(1) > span > a > span > span.label > mark\")");	
	String eleCreateNew = " return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu.can-animate.is-main-menu.is-open\").shadowRoot.querySelector(\"nav > div.sn-polaris-nav.all.can-animate.keyboard-navigatable > div.sn-tree-menu.sn-polaris-nav-content > div.sn-polaris-tab-content.-left.is-visible.can-animate > div > sn-collapsible-list:nth-child(1)\").shadowRoot.querySelector(\"div > div > ul > li:nth-child(1) > span > a > span > span.label > mark\")";
	public CreateNewIncident clickCreateNew() throws InterruptedException {		
		try {
			Thread.sleep(5000);
		click(eleCreateNew);
		} catch (InterruptedException e) {
		}
		return new CreateNewIncident(driver, test); 
	}	
	

	@FindBy(linkText="Open")
	//WebElement eleOpen;
	String eleOpen = " return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout\").shadowRoot.querySelector(\"div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header\").shadowRoot.querySelector(\"nav > div > sn-polaris-menu.can-animate.is-main-menu.is-open\").shadowRoot.querySelector(\"nav > div.sn-polaris-nav.all.can-animate.keyboard-navigatable > div.sn-tree-menu.sn-polaris-nav-content > div.sn-polaris-tab-content.-left.is-visible.can-animate > div > sn-collapsible-list:nth-child(2)\").shadowRoot.querySelector(\"div > div > ul > li > span > a > span > span > mark\")";
	public ListIncidents clickOpen() {		
		click(eleOpen);
		return new ListIncidents(driver, test); 
	}	
	
}











package com.ShearCircle.TestScenarios;

import org.testng.annotations.Test;

import com.ShearCircle.ObjectRepository.SubscriberElementLocaters;
import com.ShearCircle.ShearCirclePageComponents.Customer_Registration_Page_Components;
import com.ShearCircle.Utilities.CommonFunctions;
import com.ShearCircle.Utilities.StaticVariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class CustomerModule extends StaticVariables {
	public String TestDataPath;
	CommonFunctions cfn = new CommonFunctions();
	
	@BeforeClass
	@Parameters("browser")
	public void beforeclass(@Optional("chrome") String browser) throws IOException, InterruptedException {
		TestDataPath = cfn.TestDataPathOf("SubscriberTestData.properties");
		Browser = browser;
		cfn.GetAndOpenBrowser(browser);
	}

	@AfterMethod
	public void StatusScreenShots(ITestResult testResult) throws IOException, InterruptedException {
		cfn.ScreenshotOnPassFail(testResult);
		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	@Test
	public void CustomerSubscriber() throws IOException {
		Customer_Registration_Page_Components CR = new Customer_Registration_Page_Components();		
		CR.launchbowser_application();
		CR.Customer_Registration();		
	}
	
		
	@Test
	public void ProfessionalSubscriber() throws IOException {
		Customer_Registration_Page_Components CR = new Customer_Registration_Page_Components();			
		CR.Professional_Registration();
	}


}

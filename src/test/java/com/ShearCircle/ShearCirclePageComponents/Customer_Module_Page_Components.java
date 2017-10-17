package com.ShearCircle.ShearCirclePageComponents;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.ShearCircle.ObjectRepository.Customer_Module_Page_Objects;
import com.ShearCircle.ObjectRepository.Login_page_objects;
import com.ShearCircle.Utilities.StaticVariables;
import com.ShearCircle.Utilities.Web_Browser;

public class Customer_Module_Page_Components extends StaticVariables {
	
	//public static WebDriver driver;
	public Customer_Module_Page_Objects SCRegistration;
	public Login_page_objects Login;
	public Web_Browser browser;	
	String TestDataPath = null;
	public Customer_Module_Page_Components() throws IOException {			
		browser = new Web_Browser(driver);
		//System.out.println(driver.getWindowHandle());
		TestDataPath = browser.TestDataPathOf("CustomerTestData.properties");
		SCRegistration = PageFactory.initElements(driver, Customer_Module_Page_Objects.class);
		Login = PageFactory.initElements(driver, Login_page_objects.class);
	}
	
	public void launchbowser_application(){
		String baseUrl = null;
	    try {   
	    	//System.out.println(driver.getWindowHandle());
	    	browser.loaddata(TestDataPath);
	    	baseUrl = browser.getdata("TestBedURL");
		    driver.get(baseUrl + "");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    
		    String apptitle = driver.getTitle();
		    if (apptitle.equalsIgnoreCase(baseUrl)){
		    System.out.println("Browser Tilte:"+apptitle);     
		    }		    
			if(browser.elmentisdisplayed(Login.ShearCircle_Image)) {
				 System.out.println("ShearCircle Image displayed");
			 }else {
				 System.out.println("ShearCircle Image not displayed");
			 }
			  
		  }catch(Exception e){
				  System.out.println("Exception: "+e); 
		  }	
	}	
	
	public void Customer_Registration(){
		String FirstName = null;
		String LastName = null;
		String customerEmail = null;
		String Password = null;
		browser.loaddata(TestDataPath);
		FirstName = browser.getdata("FirstName");
		LastName = browser.getdata("LastName");
		customerEmail = browser.getdata("customerEmail");
		Password = browser.getdata("Password");
		
		try{
			if(browser.elmentisdisplayed(Login.JoinOurCircle_Link)) {
				browser.reportscomtep("Passed", "Verify JoinCircle link is displayed"  , "JoinCircle link should be displayed", "JoinCircle link is displayed");
				browser.click(Login.JoinOurCircle_Link);
				//browser.wait(5);
				if(browser.elmentisdisplayed(SCRegistration.CR_customerJoinCircle_Link)){
					browser.reportscomtep("Passed", "Verify Customer JoinCircle link is displayed"  , "Customer JoinCircle link should be displayed", "Customer JoinCircle link is displayed");
					browser.click(SCRegistration.CR_customerJoinCircle_Link);
					//browser.wait(5);
					if(browser.elmentisdisplayed(SCRegistration.CR_JoinNow_Header)){
						
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_FirstName_textbox, "FirstName textbox");
						browser.sendkeys(SCRegistration.CR_FirstName_textbox,FirstName);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_LastName_textbox, "LastName textbox");
						browser.sendkeys(SCRegistration.CR_LastName_textbox,LastName);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_Email_textbox, "Email textbox");
						browser.sendkeys(SCRegistration.CR_Email_textbox,customerEmail);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_Password_textbox, "Password textbox");
						browser.sendkeys(SCRegistration.CR_Password_textbox,Password);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_ReEnterPassword_textbox, "ReEnteredPassword textbox");
						browser.sendkeys(SCRegistration.CR_ReEnterPassword_textbox,Password);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_Termsofservice_checkbox, "Termsofservice checkbox");
						browser.check_Checkbox(SCRegistration.CR_Termsofservice_checkbox);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_billingagrement_checkbox, "billingagrement Checkbox");
						browser.check_Checkbox(SCRegistration.CR_billingagrement_checkbox);
						browser.Verify_elmentisdisplayed_Report(SCRegistration.CR_joinourcircle_button, "JoinCircle Button");
						browser.click(SCRegistration.CR_joinourcircle_button);
						
					}
				}else {
					browser.reportscomtep("Failed", "Verify Customer JoinCircle link is displayed"  , "Customer JoinCircle link should be displayed", "Customer JoinCircle link not displayed");
				}
			}else {
				browser.reportscomtep("Failed", "Verify JoinCircle link is displayed"  , "JoinCircle link should be displayed", "JoinCircle link not displayed");
			}
			
		}catch(Exception e){
			System.out.println("Error description: " + e.getStackTrace() );
		}			
		
	}
	
	
	public void Professional_Registration(){
		
		String FirstName = null;
		String LastName = null;
		String ProfessionalEmail = null;
		String Password = null;
		String BusinessName = null;
		String Subdomain = null;
		browser.loaddata(TestDataPath);
		FirstName = browser.getdata("FirstName");
		LastName = browser.getdata("LastName");
		BusinessName = browser.getdata("BusinessName");
		Password = browser.getdata("Password");
		ProfessionalEmail = browser.getdata("ProfessionalEmail");
		Subdomain = browser.getdata("Subdomain");
		try {	
		
		if(browser.elmentisdisplayed(Login.JoinOurCircle_Link)) {
			browser.reportscomtep("Passed", "Verify JoinCircle link is displayed"  , "JoinCircle link should be displayed", "JoinCircle link is displayed");
			browser.click(Login.JoinOurCircle_Link);
			//browser.wait(5);
			if(browser.elmentisdisplayed(SCRegistration.CR_customerJoinCircle_Link)){
				browser.reportscomtep("Passed", "Verify Professional JoinCircle link is displayed"  , "Professional JoinCircle link should be displayed", "Professional JoinCircle link is displayed");
				browser.click(SCRegistration.CR_ProfessionalJoinCircle_Link);
				//browser.wait(5);
				if(browser.elmentisdisplayed(SCRegistration.CR_JoinNow_Header)){
					
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_FirstName_textbox, "FirstName textbox");
					browser.sendkeys(SCRegistration.PF_FirstName_textbox,FirstName);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_LastName_textbox, "LastName textbox");
					browser.sendkeys(SCRegistration.PF_LastName_textbox,LastName);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_Email_textbox, "Email textbox");
					browser.sendkeys(SCRegistration.PF_Email_textbox,ProfessionalEmail);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_businessName_textbox, "buisiness textbox");
					browser.sendkeys(SCRegistration.PF_businessName_textbox,BusinessName);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_Subdomain_textbox, "Subdomain textbox");
					browser.sendkeys(SCRegistration.PF_Subdomain_textbox,Subdomain);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_Password_textbox, "Password textbox");
					browser.sendkeys(SCRegistration.PF_Password_textbox,Password);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_ReEnterPassword_textbox, "ReEnteredPassword textbox");
					browser.sendkeys(SCRegistration.PF_ReEnterPassword_textbox,Password);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_Termsofservice_checkbox, "Termsofservice checkbox");
					browser.check_Checkbox(SCRegistration.PF_Termsofservice_checkbox);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_billingagrement_checkbox, "billingagrement Checkbox");
					browser.check_Checkbox(SCRegistration.PF_billingagrement_checkbox);
					browser.Verify_elmentisdisplayed_Report(SCRegistration.PF_joinourcircle_button, "JoinCircle Button");
					browser.click(SCRegistration.PF_joinourcircle_button);
				}
			}else {
				browser.reportscomtep("Failed", "Verify Professional JoinCircle link is displayed"  , "Professional JoinCircle link should be displayed", "Professional JoinCircle link not displayed");
			}
		}else {
			browser.reportscomtep("Failed", "Verify JoinCircle link is displayed"  , "JoinCircle link should be displayed", "JoinCircle link not displayed");
		}
		}catch(Exception e) {
			System.out.println("Error description: " + e.getStackTrace() );
		}
					
	}
}

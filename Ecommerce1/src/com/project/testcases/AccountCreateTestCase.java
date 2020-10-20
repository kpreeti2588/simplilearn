package com.project.testcases;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.project.pages.CreateAccount;
import com.project.pages.HomePage;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class AccountCreateTestCase extends Init {

CreateAccount ca = null;
HomePage hp =null;
Alert alert = null;
	
	@BeforeMethod
	public void init() throws IOException, InterruptedException {			
		ca = new CreateAccount(driver);
		hp = new HomePage(driver);
		
		hp.clickSignIn();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="getFormData")
	public void SuccessCreateAccount(Hashtable<String,String> data) throws InterruptedException {
	   ca.enterEmail(data.get("Email"));
	   ca.clickCreateButton();
	   Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account","Redirected to correct URL");
	   
	   Thread.sleep(2000);
	   ca.enterPersonalInfo(data.get("Title"),data.get("FirstName"),data.get("LastName"), data.get("Email"), data.get("Password"), Integer.parseInt(data.get("Day")), Integer.parseInt(data.get("Month")), Integer.parseInt(data.get("Year")), data.get("NewsletterSignup"), data.get("SpecialOffer"));
	
	   ca.enterAddress(data.get("FirstName"),data.get("LastName"), data.get("Company"), data.get("Address1"), data.get("Address2"), data.get("City"), data.get("State"),Integer.parseInt(data.get("Zip")), data.get("Country"),data.get("AddInfo"),data.get("HomePhone"),data.get("MobilePhone"), data.get("Alias"));
	   
	   ca.clickRegister();
	   Thread.sleep(2000);
	   
	   Assert.assertEquals(HomePage.getAccountText(), "My account"," Account is successfully created");
	   
	   Assert.assertEquals(hp.getAccountName(), data.get("FirstName")+" "+data.get("LastName"),"Account Name matched ");
	   
	   System.out.println("User Account is created successfully");
	   	   
	}
	

	@Test(dataProvider="errorinData")
	public void ErrorCreateAccount_Country(Hashtable<String,String> data) throws InterruptedException {
		   ca.enterEmail(data.get("Email"));
		   ca.clickCreateButton();
		   Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account","Redirected to correct URL");
		   
		   Thread.sleep(3000);
		   ca.enterPersonalInfo(data.get("Title"),data.get("FirstName"),data.get("LastName"), data.get("Email"), data.get("Password"), Integer.parseInt(data.get("Day")), Integer.parseInt(data.get("Month")), Integer.parseInt(data.get("Year")), data.get("NewsletterSignup"), data.get("SpecialOffer"));
		
		   ca.enterAddress(data.get("FirstName"),data.get("LastName"), data.get("Company"), data.get("Address1"), data.get("Address2"), data.get("City"), data.get("State"),Integer.parseInt(data.get("Zip")), data.get("Country"),data.get("AddInfo"),data.get("HomePhone"),data.get("MobilePhone"), data.get("Alias"));
		   ca.clickRegister();
		   Thread.sleep(2000);
		   
		   if(ca.getAlertText()!=null) {
			   if( data.get("Country")=="") {
			   System.out.println(ca.getAlertText());
			   Assert.assertTrue(ca.getAlertText()!=null,"Alert message is present");
			   }
			   else if(data.get("Zip").length()<4) {
				   System.out.println(ca.getAlertText());
				   System.out.println("Test case passed");	
				   Assert.assertTrue(data.get("Zip").length()<4,"Number of digits in zip code is less than 4");
			   }
		   }
		   else {
			   Assert.fail("alert is not present");
		   }	
	}
		
	
	@DataProvider
	public Object[][] getFormData() throws IOException{		
        ExcelReader reader = new ExcelReader();		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath +"/src/com/project/testdata";
		String filename = "EcomTestData.xlsx";
		String sheetname = "FormDataTestSet";		
		return reader.ReadExcelToArray(filepath, filename, sheetname);		
	}
	
	@DataProvider
	public Object[][] errorinData() throws IOException{		
        ExcelReader reader = new ExcelReader();		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath +"/src/com/project/testdata";
		String filename = "EcomTestData.xlsx";
		String sheetname = "errorData";		
		return reader.ReadExcelToArray(filepath, filename, sheetname);		
	}
	

}

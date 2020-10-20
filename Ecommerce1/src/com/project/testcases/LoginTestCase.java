package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pages.CreateAccount;
import com.project.pages.HomePage;
import com.project.pages.SignIn;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class LoginTestCase extends Init{
	
    SignIn si = null;
	HomePage hp =null;
	CreateAccount ca =null;
		

		@BeforeMethod
		public void initTest() throws IOException, InterruptedException {	
			si = new SignIn(driver);
			hp = new HomePage(driver);
			ca =new CreateAccount(driver);
			
			hp.clickSignIn();
			Thread.sleep(2000);
		}
		
	
		@Test(dataProvider="getSignInData")
		public void LoginwithValidCredentials(Hashtable<String,String> data) throws InterruptedException {
			si.enterEmailforSignIn(data.get("Email"));
			si.enterPasswordforSignIn(data.get("Password"));
			si.clickSignIn();
			Thread.sleep(1000);
			Assert.assertEquals(HomePage.getAccountText(), "My account"," Login is successful");
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");			
			System.out.println("User has been logged in successfully");
		}
		

		@Test(dataProvider="ErrorSignInData")
		public void LoginwithInvalidCredential(Hashtable<String,String> data) throws InterruptedException {
			si.enterEmailforSignIn(data.get("Email"));
			si.enterPasswordforSignIn(data.get("Password"));
			si.clickSignIn();
			Thread.sleep(1000);
			if(ca.getAlertText()!=null) {
				   System.out.println(ca.getAlertText());
				   Assert.assertTrue(ca.getAlertText()!=null,"Alert message is present");
				   }
		    else {
				   Assert.fail("alert is not present");
			   }				
		}
		
		@Test(dataProvider="getSignInData")
		public void verifyLogoff(Hashtable<String,String> data) throws InterruptedException {
			si.enterEmailforSignIn(data.get("Email"));
			si.enterPasswordforSignIn(data.get("Password"));
			si.clickSignIn();
			Thread.sleep(1000);
			Assert.assertEquals(HomePage.getAccountText(), "My account"," Login is successful");
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			
			hp.clickSignout();
			Thread.sleep(2000);

			Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account","Redirected to correct URL");
			Assert.assertEquals(HomePage.getAccountText().trim(), "Authentication"," User logged out successfully");			
		}
		
		
		@DataProvider
		public Object[][] getSignInData() throws IOException{		
	        ExcelReader reader = new ExcelReader();		
			String ProjectPath = System.getProperty("user.dir");
			String filepath = ProjectPath +"/src/com/project/testdata";
			String filename = "EcomTestData.xlsx";
			String sheetname = "LoginTestSet";		
			return reader.ReadExcelToArray(filepath, filename, sheetname);		
		}
		
		@DataProvider
		public Object[][] ErrorSignInData() throws IOException{		
	        ExcelReader reader = new ExcelReader();		
			String ProjectPath = System.getProperty("user.dir");
			String filepath = ProjectPath +"/src/com/project/testdata";
			String filename = "EcomTestData.xlsx";
			String sheetname = "ErrorLoginTestSet";		
			return reader.ReadExcelToArray(filepath, filename, sheetname);		
		}
		
}

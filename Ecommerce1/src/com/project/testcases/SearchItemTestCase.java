package com.project.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pages.CreateAccount;
import com.project.pages.HomePage;
import com.project.pages.SignIn;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class SearchItemTestCase extends Init {
	
	SignIn si = null;
	HomePage hp =null;
	CreateAccount ca =null;
			
		@BeforeMethod
		public void init() throws IOException, InterruptedException {	
			si = new SignIn(driver);
			hp = new HomePage(driver);
			ca =new CreateAccount(driver);
			
			hp.clickSignIn();
			Thread.sleep(2000);
		}


		@Test(dataProvider="SearchItemData")
		public void validateCountofSearchItem(Hashtable<String,String> data) throws InterruptedException {
			hp.SearchItem(data.get("ItemName"));
			hp.clickSearchButton();
			try {
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");		
			}
			catch(Exception e) {
				System.out.println("Message get displayed");
				hp.getTextSearchMessage();			
			}			
		}
		
	
		@Test
		public void validateCountofSearchItem() throws InterruptedException {
			hp.SearchItem("");
			hp.clickSearchButton();
			try {
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");		
			}
			catch(Exception e) {
				System.out.println("Message get displayed for blank keyword");
				hp.getTextSearchMessageforBlankKeyword();			
			}			
		}
		
		@Test(dataProvider="SearchItemData")
		public void validateListCountwithValidCred(Hashtable<String,String> data) throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(data.get("ItemName"));
			hp.clickSearchButton();
			try {
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");		
			}
			catch(Exception e) {
				System.out.println("Message get displayed");
				hp.getTextSearchMessage();			
			}			
		}
		
		@Test
		public void validateListValidCred() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem("");
			hp.clickSearchButton();
			try {
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");		
			}
			catch(Exception e) {
				System.out.println("Message get displayed for blank keyword");
				hp.getTextSearchMessageforBlankKeyword();		
			}			
		}
		
		@DataProvider
		public Object[][] SearchItemData() throws IOException{		
	        ExcelReader reader = new ExcelReader();		
			String ProjectPath = System.getProperty("user.dir");
			String filepath = ProjectPath +"/src/com/project/testdata";
			String filename = "EcomTestData.xlsx";
			String sheetname = "SearchItem";		
			return reader.ReadExcelToArray(filepath, filename, sheetname);		
		}

}

package com.project.testcases;

import java.io.File;
import java.io.IOException;

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

public class ManufacturerTestCase extends Init {
	
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
		
		@Test
		public void validateManufacturer() throws IOException, InterruptedException {
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");
			
			String manufacturername = hp.clickManufacturer().trim().toUpperCase();
			Assert.assertTrue(hp.getHeading().contains(manufacturername),"Correct product of Manufacturer is getting displayed ");
		}
		
		
		@Test
		public void validateManufacturerwithLogin() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();
			int count = Integer.parseInt(hp.countItem());
			System.out.println("Number of search items "+ count );
			Assert.assertEquals(count, hp.getCountofSearchResult(), "Items are getting enlisted succesfully");
			
			String manufacturername = hp.clickManufacturer().trim().toUpperCase();
			Assert.assertTrue(hp.getHeading().contains(manufacturername),"Correct product of Manufacturer is getting displayed ");
		}
		

		

}

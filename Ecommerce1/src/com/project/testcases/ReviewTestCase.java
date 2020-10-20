package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pages.HomePage;
import com.project.pages.ReviewPage;
import com.project.pages.SignIn;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class ReviewTestCase extends Init{
	
	SignIn si = null;
	HomePage hp = null;
	ReviewPage rp = null;
	
			
		@BeforeMethod
		public void init() throws IOException, InterruptedException {
			si = new SignIn(driver);
			hp = new HomePage(driver);
			rp = new ReviewPage(driver);
			
			hp.clickSignIn();
			Thread.sleep(2000);
		}
			
		
		@Test(dataProvider="ReviewData")  
		public void testReview( Hashtable<String,String> data) throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();			
			hp.clickonProductQuickView();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			hp.clickReview();
			
			rp.enterTitle(data.get("Title"));
			rp.selectStar(data.get("Star"));  	
			rp.enterComment(data.get("Comment"));
			rp.submitComment();
			Thread.sleep(10000);
			if(data.get("Comment").length()<50) {
				boolean isPresent = rp.getErrorMsg();
				System.out.println("Error message is present : "+isPresent);
				//Assert.assertTrue(isPresent, "Error Message is present");
			}				
	    	else if(data.get("Comment").isEmpty() || data.get("Title").isEmpty()) {
				boolean isPresent1 = rp.getErrorMsg();
				Assert.assertTrue(isPresent1, "Error Message is present");
			}
			Assert.assertEquals(rp.getSuccessMsg(),PropertyReader.getProperty("commentMsg"),"Comment has been posted successfully");
			rp.clickOk();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
		}
		
		
		@DataProvider
		public Object[][] ReviewData() throws IOException{		
	        ExcelReader reader = new ExcelReader();		
			String ProjectPath = System.getProperty("user.dir");
			String filepath = ProjectPath +"/src/com/project/testdata";
			String filename = "EcomTestData.xlsx";
			String sheetname = "ReviewTestData";		
			return reader.ReadExcelToArray(filepath, filename, sheetname);		
		}
		

}

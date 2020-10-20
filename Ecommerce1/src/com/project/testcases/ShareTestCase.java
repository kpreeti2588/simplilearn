package com.project.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pages.CreateAccount;
import com.project.pages.HomePage;
import com.project.pages.SignIn;
import com.project.pages.SocialPages;
import com.project.utils.PropertyReader;

public class ShareTestCase extends Init{

	SignIn si = null;
	HomePage hp = null;
	CreateAccount ca = null;
	SocialPages sp = null;
			
		@BeforeMethod
		public void init() throws IOException, InterruptedException {	
			si = new SignIn(driver);
			hp = new HomePage(driver);
			ca =new CreateAccount(driver);
			sp = new SocialPages(driver);
			
			hp.clickSignIn();
			Thread.sleep(2000);
		}
		
	
		@Test
		public void shareProductonPinterest() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();			
			hp.clickonProductQuickView();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			hp.clickonPinterest();
			String ParentWindowId = driver.getWindowHandle();
			try {
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			Assert.assertEquals(hp.getAccountName(), "Preeti Kumari","Account Name matched ");
			}
			catch(Exception e) {
				System.out.println("catch the exception");
			}
			Set<String> winid = driver.getWindowHandles();
			Iterator<String> itr = winid.iterator();
			String subwinId = "";
			while(itr.hasNext())
			{
				subwinId = itr.next().toString();
			}
			driver.switchTo().window(subwinId);
			Thread.sleep(2000);
			System.out.println("print the current URL  "+ driver.getCurrentUrl());		
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("pinterestURL")), "Focus is gone to Pinterest");
			
			sp.clickPinterestLogin();
			sp.enterPinterestEmail(PropertyReader.getProperty("pinterestemail"));
			sp.enterPinterestPwd(PropertyReader.getProperty("pinterestpassword"));
			sp.clickPinLogin();

			Assert.assertEquals(sp.getPinHomePage(), "Search", "redirected to Pinterest Home page");
			
			driver.switchTo().window(ParentWindowId);
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("baseurl")), "Come back to main shopping window successfully");		
		}
			
		@Test
		public void shareProductonGoogle() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();			
			hp.clickonProductQuickView();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			hp.clickonGoogle();
			String ParentWindowId = driver.getWindowHandle();
			try {
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			Assert.assertEquals(hp.getAccountName(), "Preeti Kumari","Account Name matched ");
			}
			catch(Exception e) {
				System.out.println("catch the exception");
			}
			Set<String> winid = driver.getWindowHandles();
			Iterator<String> itr = winid.iterator();
			String subwinId = "";
			while(itr.hasNext())
			{
				subwinId = itr.next().toString();
			}
			driver.switchTo().window(subwinId);
			Thread.sleep(2000);
			System.out.println("print the current URL  "+ driver.getCurrentUrl());		
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("googleURL")), "Focus is gone to Google Account");
			Assert.assertEquals(sp.getGoogleEmailText(),"Email or phone","Email needs to enter for login into google");
			
			driver.switchTo().window(ParentWindowId);
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("baseurl")), "Come back to main shopping window successfully");		
		}
		

		@Test
		public void shareProductonFacebook() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();			
			hp.clickonProductQuickView();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			hp.clickonFacebook();
			String ParentWindowId = driver.getWindowHandle();
			try {
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			Assert.assertEquals(hp.getAccountName(), "Preeti Kumari","Account Name matched ");
			}
			catch(Exception e) {
				System.out.println("catch the exception");
			}
			Set<String> winid = driver.getWindowHandles();
			Iterator<String> itr = winid.iterator();
			String subwinId = "";
			while(itr.hasNext())
			{
				subwinId = itr.next().toString();
			}
			driver.switchTo().window(subwinId);
			Thread.sleep(2000);
			System.out.println("print the current URL  "+ driver.getCurrentUrl());		
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("facebookURL")), "Focus is gone to Facebook Account");
			System.out.println(sp.getFbEmailText());
			Assert.assertEquals(sp.getFbEmailText(),"Email address or phone number:","Email needs to enter for login into facebook");
			
			driver.switchTo().window(ParentWindowId);
			Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("baseurl")), "Come back to main shopping window successfully");		
		}


}

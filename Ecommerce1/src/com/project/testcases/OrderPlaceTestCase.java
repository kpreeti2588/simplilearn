package com.project.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pages.CreateAccount;
import com.project.pages.HomePage;
import com.project.pages.SignIn;
import com.project.pages.SocialPages;
import com.project.utils.PropertyReader;

public class OrderPlaceTestCase extends Init{

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
		public void placeOrder() throws InterruptedException, IOException {
			si.LoginValidCredentials();
			hp.clickTshirt();
			Thread.sleep(10000);
			try {
				hp.clickAddtoCart();
				}
			catch(Exception e) {
					hp.clickCartwoFrame();
				}
			hp.clickCheckout();
			
            Assert.assertEquals(HomePage.getAccountText(), PropertyReader.getProperty("shoppingCart")," User moved to shopping Cart Summary page");
            int count = Integer.parseInt(hp.getProductCount());
            Assert.assertEquals(count, 1, "Number of product in cart matched");
            System.out.println("1 Product get added into cart");
            hp.SearchItem(PropertyReader.getProperty("dress"));
			hp.clickSearchButton();			
			hp.clickonProductQuickView();
			Assert.assertTrue(hp.LogoffAppear(), "Sign Out Button is getting displayed");
			try {
			hp.clickAddtoCart();
			}
			catch(Exception e) {
				hp.clickCartwoFrame();
			}
			Thread.sleep(5000);
			System.out.println("2 Products get added into cart");
			driver.navigate().back();
            hp.clickonProduct();
            try {
    			hp.clickAddtoCart();
    			}
    		catch(Exception e) {
    				hp.clickCartwoFrame();
    			}
            hp.clickCheckout();
            Assert.assertEquals(HomePage.getAccountText(), PropertyReader.getProperty("shoppingCart")," User moved to shopping Cart Summary page");
            int count1 = Integer.parseInt(hp.getProductCount());
          //  Assert.assertEquals(count1, 3, "Number of product in cart matched");
            System.out.println("3 Product get added into cart");
            
            hp.clickonCheckout();
            hp.addressCheckout();
            hp.clickTerms();
            
            hp.shippingCheckout();
            hp.selectPaymentMethod();
            hp.clickConfirmOrder();
            
            Assert.assertEquals(HomePage.getAccountText(), PropertyReader.getProperty("orderConfirm")," User placed the order successfully");
            Assert.assertTrue(hp.getSucessMessage().contains(PropertyReader.getProperty("orderComplete")),"Order placed successfully");
					
		}


}

package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.project.utils.PropertyReader;

public class SignIn {
	

	@FindBy(id="email")
	private WebElement emailTextBox;
	
	@FindBy(id="passwd")
	private WebElement passwordTextBox;
	
	@FindBy(id="SubmitLogin")
	private WebElement SignInbutton;
	
	WebDriver driver;
	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	HomePage hp = new HomePage(driver);
	
	public void enterEmailforSignIn(String email) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
	}
	
	public void enterPasswordforSignIn(String pwd) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(pwd);
	}
	
    public void clickSignIn() {
    	SignInbutton.click();
    }
    
    
    public void LoginValidCredentials() throws InterruptedException, IOException {
		enterEmailforSignIn(PropertyReader.getProperty("email"));
		enterPasswordforSignIn(PropertyReader.getProperty("password"));
		clickSignIn();
		Thread.sleep(1000);
		Assert.assertEquals(HomePage.getAccountText(), "My account"," Login is successful");
		
		System.out.println("User has been logged in successfully");
	}

}

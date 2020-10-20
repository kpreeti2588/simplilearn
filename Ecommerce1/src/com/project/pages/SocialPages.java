package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialPages {
	
	@FindBy(xpath="//div[@data-test-id='simple-login-button']/button")
	private WebElement PinterestLogin;
	
	@FindBy(id="email")
	private WebElement Pinterestemail;
	
	@FindBy(id="password")
	private WebElement Pinterestpwd;
	
	@FindBy(xpath="//div[@data-test-id='registerFormSubmitButton']/button/div")
	private WebElement PinLoginButton;
	
	@FindBy(name="searchBoxInput")
	private WebElement PinterestSearchBox;
	
	@FindBy(id="identifierId")
	private WebElement GoogleEmail;
	
	@FindBy(xpath="//div[@id='email_container']/div/label")
	private WebElement Fbemail;
	
	WebDriver driver;
	public SocialPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
    public void clickPinterestLogin() {
    	PinterestLogin.click();
    }
	
	public void enterPinterestEmail(String email) {
		 Pinterestemail.clear();
		 Pinterestemail.sendKeys(email);
	}
		
	public void enterPinterestPwd(String pwd) {
		Pinterestpwd.clear();
		Pinterestpwd.sendKeys(pwd);
	}
	
	public void clickPinLogin() {
		PinLoginButton.click();
	}
	
	public String getPinHomePage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("searchBoxInput")));			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return PinterestSearchBox.getAttribute("placeholder");		
	}
	
	
	public String getGoogleEmailText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return GoogleEmail.getAttribute("aria-label");
	}
	
	public String getFbEmailText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Fbemail.getText();
	}
	

}

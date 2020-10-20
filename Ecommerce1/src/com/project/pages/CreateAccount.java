package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
	
	@FindBy(id="email_create")
	private WebElement emailTextBox;
	
	@FindBy(id="SubmitCreate")
	private WebElement createAccount;
	
	/////////////////////---------Form Fillup Page-----------------/////////////////////
	
	@FindBy(css="div.radio-inline")
	private List<WebElement> TitleList;
	
	@FindBy(id="customer_firstname")
	private WebElement FirstNameTextBox;
	
	@FindBy(id="customer_lastname")
	private WebElement LastNameTextBox;
	
	@FindBy(id="email")
	private WebElement emailTextBoxDetail;
	
	@FindBy(xpath="//*[@id='passwd']")
	private WebElement password;
	
	@FindBy(css="select#days")
	private WebElement days;
	
	@FindBy(css="select#months")
	private WebElement months;
	
	@FindBy(css="select#years")
	private WebElement years;
	
	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/div[7]/label")
	private WebElement signup_newsletter;
	
	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/div[8]/label")
	private WebElement receive_specialoffer;
	
	@FindBy(id="firstname")
	private WebElement FirstName;
	
	@FindBy(id="lastname")
	private WebElement LastName;
	
	@FindBy(id="company")
	private WebElement Company;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="address2")
	private WebElement address2;
	
	@FindBy(id="city")
	private WebElement City;
	
	@FindBy(id="id_state")
	private WebElement state;
	
	@FindBy(id="postcode")
	private WebElement postcode;
	
	@FindBy(id="id_country")
	private WebElement Country;
	
	@FindBy(xpath="//*[@id='other']")
	private WebElement addinfo;
	
	@FindBy(xpath="//*[@id='phone']")
	private WebElement homephone;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	private WebElement mobilephone;
	
	@FindBy(xpath="//*[@id='alias']")
	private WebElement addalias;
	
	@FindBy(id="submitAccount")
	private WebElement register;
	
	@FindBy(xpath="//*[@id='center_column']/div")
	private WebElement alert;
	
	WebDriver driver;
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void enterEmail(String EmailId) {
		emailTextBox.clear();
		emailTextBox.sendKeys(EmailId);
	}
	
	public void clickCreateButton() {
		createAccount.click();
	}
	
	/////----------------Form Fill up page Personal Information-------------////
		
	public void enterFirstName(String firstname) {
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		LastNameTextBox.clear();
		LastNameTextBox.sendKeys(lastname);
	}
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void enterDob(int day,int month,int year) {
		Select daysDD = new Select(days);
		daysDD.selectByValue(String.valueOf(day));
		
		Select monthsDD = new Select(months);
		monthsDD.selectByIndex(month);
		
		Select yearsDD = new Select(years);
		yearsDD.selectByValue(String.valueOf(year));
	}
	
	public void enterName(String fname,String lname) {
		FirstName.clear();
		LastName.clear();
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
	}
	
	public void enterCompany(String comp) {
		Company.clear();
		Company.sendKeys(comp);
	}
	
	public void enterAddress(String add1,String add2) {
		address1.clear();
		address2.clear();
		address1.sendKeys(add1);
		address2.sendKeys(add2);
	}
	
	public void enterState(String st) {
		Select sta = new Select(state);
		sta.selectByVisibleText(st);
	}
	
	public void enterZip(int zip) {
		postcode.clear();
		postcode.sendKeys(String.valueOf(zip));
	}
	
	public void enterCountry(String con) {
		System.out.println(con);
		Select country = new Select(Country);
		if(con=="") {
			System.out.println("No country has been selected");
			country.selectByVisibleText("-");
		}
		else {
			country.selectByVisibleText(con);
		}
	} 
	
	public void enterAdditonalInfo(String info) {
		addinfo.clear();
		addinfo.sendKeys(info);
	}
	
	public void enterPhone(String home,String mobile) {
		homephone.clear();
		mobilephone.clear();
		homephone.sendKeys(home);
		mobilephone.sendKeys(mobile);
	}
	
	public void enterAlias(String alias) {
		addalias.clear();
		addalias.sendKeys(alias);
	}
	
	public void enterCity(String ci) {
		City.clear();
		City.sendKeys(ci);
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public String getAlertText() {
		return alert.getText();
	}
		
	public void enterPersonalInfo(String title, String firstname, String lastname, String Email, String password, int day, int month, int year, String signup_news, String specialoffer) {
		for (WebElement webElement : TitleList) {
			if(webElement.getText().equalsIgnoreCase(title)) {
				  webElement.click();
				  break;
				}
		}			
		enterFirstName(firstname);
		enterLastName(lastname);
		
		if(emailTextBoxDetail.getAttribute("value").equalsIgnoreCase(Email)) {
			System.out.println("Email ID is entered correctly");
		}
		else {
			System.out.println("Email Information is not matching");
		}
		
		enterPassword(password);
		enterDob(day,month,year);
		
		if(signup_news.contentEquals("Y")) {
			signup_newsletter.click();
		}
		if(specialoffer.contentEquals("Y")) {
		receive_specialoffer.click();
		}			
	}

	
	public void enterAddress(String fname, String lname, String company,String add1, String add2, String city, String state,int zip,String country,String add, String home,String mobile,String aliasadd) throws InterruptedException {
		enterName(fname,lname);
		enterCompany(company);
		enterAddress(add1,add2);
		enterCity(city);
		enterState(state);
		enterZip(zip);
		enterCountry(country);
		enterAdditonalInfo(add);
		enterPhone(home,mobile);
		enterAlias(aliasadd);		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

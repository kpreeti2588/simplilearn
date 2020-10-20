package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BMICalcStepDef {
	WebDriver driver;
	
	@Before
	public void LaunchBrowser() {
		System.out.println("Hooks- launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver  = new ChromeDriver();
	}
	
	@Before("@smoke")
	public void smokeTest() {
		System.out.println("smoke test case being executed");		
	}
	

	@After("@datadriven")
	public void dataDrivenTest() {
		System.out.println("data driven test case being executed");		
	}
	
	@Given("^The User Launches the Calorie Calculator Page1$")
	public void the_User_Launches_the_Calorie_Calculator_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get("https://www.calculator.net/calorie-calculator.html");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^The User Clicks on BMI Link$")
	public void the_User_Clicks_on_BMI_Link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Click on BMI Link");
		 driver.findElement(By.linkText("BMI")).click();
	}

	@Given("^The User Provides the age as (.+)$")
	public void the_User_Provides_the_age_as(String age) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter age ");
		WebElement ageTextBox= driver.findElement(By.id("cage"));
		ageTextBox.clear();
		ageTextBox.sendKeys(age);
	}

	@Given("^user selects the gender as (.+)$")
	public void user_selects_the_gender_as_f(String sex) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter gender");
		if(sex.equals("f"))
		driver.findElement(By.id("csex2")).click();
		else {
			driver.findElement(By.id("csex1")).click();
		}
	/*	List<WebElement> sexList = driver.findElements(By.name("csex"));
		for (WebElement sexElement : sexList) {
			if(sex.equals(sexElement.getAttribute("value"))) {
				if(!sexElement.isSelected()) {
					sexElement.click();
					break;
				}
			}
		}*/
		
	}

	@Given("^user provides the heightinch as (.+)$")
	public void user_provides_the_height_as(String heighttest) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter height");
		WebElement height = driver.findElement(By.id("cheightmeter"));
		height.clear();
		height.sendKeys(heighttest);
	}

	@Given("^the user provides the weight as (.+)$")
	public void the_user_provides_the_weight_as(String weighttext) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter weight");
		WebElement weight = driver.findElement(By.id("ckg"));
		weight.clear();
		weight.sendKeys(weighttext);
	}

	@Given("^the user clicks on the Calculate Button$")
	public void the_user_clicks_on_the_Calculate_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Calculate button is clicked");
		 driver.findElement(By.xpath("//*[@value='Calculate']")).click();
	}

	@Then("^The user is provided with BMI Value and BMI Category$")
	public void the_user_is_provided_with_BMI_Value_and_BMI_Category() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("BMI value and category is provided");
		 String bmi = driver.findElement(By.xpath("//*[@id='content']/div[4]/div/b")).getText();
		 String actualbmicategory = driver.findElement(By.xpath("//*[@id='content']/div[4]/div/font/b")).getText();
		 int indexofEq = bmi.indexOf("=");
		 int indexofKg = bmi.indexOf("kg");
		 String bmitextvalue = bmi.substring(indexofEq+1, indexofKg-1);
		 double bmivalue = Double.parseDouble(bmitextvalue);
		 String expectedbmiCategory = findExpectedBMICategory(bmivalue);
		 if(actualbmicategory.equals(expectedbmiCategory))
		    	System.out.println("Actual matches expected Category - " + expectedbmiCategory + " : " + actualbmicategory);
		    else
		    	System.out.println("Actual does not match expected Category - " + expectedbmiCategory + " : " + actualbmicategory);
	}

	private String findExpectedBMICategory(double bmi) {
		// TODO Auto-generated method stub
		String cat = "";
		if(bmi<16) {
			cat = "Severe Thinness";
		}
		else if(bmi>=16 && bmi<17)
			cat = "Moderate Thinnes";
		else if(bmi>=17 && bmi<18.5)
			cat = "Mild Thinness";
		else if(bmi>=18.5 && bmi<25)
			cat = "Normal";
			
		else if(bmi>=25 && bmi<30)
			cat = "Overweight";
			
		else if(bmi>=30 && bmi<35)
			cat = "Obese Class I";
		else if(bmi>=35 && bmi<40)
			cat = "Obese Class II";
		else if(bmi>=40)
			cat = "Obese Class III";
		return cat;
	}

	@Then("^the user verifies the BMICategory based on the BMI Value$")
	public void the_user_verifies_the_BMICategory_based_on_the_BMI_Value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User verified");
		 Thread.sleep(5000);
		
	}

	@After
	public void closeBrowser() {
		System.out.println("Hooks- Close Browser");
		driver.close();
	}
/*	@Given("^user selects the gender as m$")
	public void user_selects_the_gender_as_m() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dfd");
	}*/


}

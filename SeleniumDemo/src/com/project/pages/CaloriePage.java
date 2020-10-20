package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaloriePage {
	
	@FindBy(id="cage")
	private WebElement ageTextbox;
	
	@FindBy(name="csex")
	private List<WebElement> genderList;
	
	@FindBy(xpath="//*[@id='cheightmeter']")
	private WebElement heightTextBox;
	
	@FindBy(css="#ckg")
	private WebElement weightTextBox;

	
	WebDriver driver;
	public CaloriePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setAge(String age ) {
		ageTextbox.clear();
		ageTextbox.sendKeys(age);	
	}
	
	public String getAge() {
		return ageTextbox.getAttribute("value");	
	}
	
	public void enterCalorieDetail(String age, String sex, String height, String weight) {
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		
		for (WebElement gender : genderList) {
			if(gender.getAttribute("value").equals(sex)) {
				if(!gender.isSelected()) {
					gender.click();
					break;
				}
			}
		}
		
		heightTextBox.clear();
		heightTextBox.sendKeys(height);
		
		weightTextBox.clear();
		weightTextBox.sendKeys(weight);
		
	}
	

}

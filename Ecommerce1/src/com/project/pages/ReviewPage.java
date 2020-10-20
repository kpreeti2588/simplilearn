package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.utils.PropertyReader;

public class ReviewPage {
	
	@FindBy(xpath="//ul[@id='criterions_list']/li/div[1]/div[contains(@class,star_on)]")
	private List<WebElement> star;
	
	@FindBy(xpath="//form[@id='id_new_comment_form']/div/div[2]/input")
	private WebElement title;
	
	@FindBy(xpath="//form[@id='id_new_comment_form']/div/div[2]/textarea")
	private WebElement comment;
	
	@FindBy(id="submitNewMessage")
    private WebElement submit;
	
	@FindBy(id="new_comment_form_error")
	private WebElement errorMsg;
	
	@FindBy(css="div.fancybox-inner > p")
	private WebElement successMsg;
	
	@FindBy(css="div.fancybox-inner > p.submit")
	private WebElement okButton;
	
	WebDriver driver;
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void selectStar(String star1) {
		for (WebElement webElement : star) {
			if(webElement.getText().contentEquals(star1)) {
				webElement.click();
			}
		}		
	}
	
	public void enterTitle(String title1) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		//	if(PropertyReader.getProperty("browser").contentEquals("chrome")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='id_new_comment_form']/div/div[2]/input")));
			title.clear();
			title.sendKeys(title1);
			}
		/*	else {
				driver.navigate().to("http://automationpractice.com/index.php?controller=order");
			}*/
		//}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void enterComment(String comment1) {
		comment.clear();
		comment.sendKeys(comment1);
	}
	
	public void submitComment() {
		submit.click();
	}
    
	public boolean getErrorMsg() {
		System.out.println(errorMsg.getText());
		return errorMsg.isDisplayed();
	}
	
	public String getSuccessMsg() {
		return successMsg.getText();
	}
	
	public void clickOk() {
		okButton.click();
	}
	
}

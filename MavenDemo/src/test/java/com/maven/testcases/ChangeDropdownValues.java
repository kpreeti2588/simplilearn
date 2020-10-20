package com.maven.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ChangeDropdownValues {

	@Test
	public void changeDDvalues() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.calculator.net/calorie-calculator.html");
	
	WebElement activity =driver.findElement(By.id("cactivity"));
	
	Select d = new Select(activity);
	System.out.println("First selected option   "+ d.getFirstSelectedOption().getText());
	
	d.selectByIndex(1);
	
	Thread.sleep(2000);
	System.out.println("Second value "+d.getFirstSelectedOption().getText());
	d.selectByValue("1.725");
	
	Thread.sleep(2000);
	System.out.println("third value "+d.getFirstSelectedOption().getText());
	
	d.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
	Thread.sleep(2000);
	System.out.println("Fourth value "+d.getFirstSelectedOption().getText());
	
	List<WebElement> Options= activity.findElements(By.tagName("option"));
	for (WebElement op : Options) {
		System.out.println(op.getText());			
	}
	System.out.println("is dropdown multi select  "+ d.isMultiple());
	
	driver.close();
}
}

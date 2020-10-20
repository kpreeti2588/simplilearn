package com.maven.testcases;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalcHTTestCaseClass {
	
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "getCalorieData")
	public void CalorieCalcTest(Hashtable<String,String> data) throws InterruptedException {
		
	//	WebElement age= driver.findElement(By.id("cage"));
		WebElement age= driver.findElement(By.xpath("//*[@id='cage']"));
		age.clear();
		age.sendKeys(data.get("hage"));
		System.out.println("attribute value of name  "+age.getAttribute("name"));
		System.out.println("attribute value of id  "+age.getAttribute("id"));
		System.out.println("attribute value of css  "+age.getAttribute("class"));
		System.out.println("attribute value of type  "+age.getAttribute("type"));
		System.out.println("attribute value of value  "+age.getAttribute("value"));
		System.out.println("Tag name "+ age.getTagName());
		
		
	//	List<WebElement> genderList= driver.findElements(By.name("csex"));
		List<WebElement> genderList= driver.findElements(By.xpath("//*[@name='csex']"));
		
		for (WebElement gender : genderList) {
			if(gender.getAttribute("value").equals(data.get("sex"))) {
				if(!gender.isSelected()) {
					gender.click();
					break;
				}
			}
		}
		
		//WebElement table = driver.findElement(By.className("cinfoT"));
		
		WebElement table = driver.findElement(By.xpath("//*[@class='cinfoT']"));
		List<WebElement> rows= table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> col = row.findElements(By.tagName("td"));
			for (WebElement cols : col) {
				System.out.print(cols.getText()+" \t");
			}
			System.out.println("");
		}		
		Thread.sleep(2000);		
	}
	
	@AfterClass
	public void closeBrowser() {
		if(driver!=null) {
			System.out.println("close");
		driver.close();
		driver.quit();
		System.out.println("driver");
		}
	}

	@DataProvider
	public Object[][] getCalorieData(){
		
	//	Object[][] data = new Object[3][2];
		
		Hashtable<String,String> rec1 = new Hashtable<String,String>();		
		rec1.put("hage","35");
		rec1.put("sex", "f");
		
		Hashtable<String,String> rec2 = new Hashtable<String,String>();		
		rec2.put("hage","55");
		rec2.put("sex", "f");
		
		Hashtable<String,String> rec3 = new Hashtable<String,String>();		
		rec3.put("hage","65");
		rec3.put("sex", "f");
		
		Object[][] data = new Object[3][1];
		
		data[0][0] = rec1;
		data[1][0] = rec2;
		data[2][0] = rec3;

/*		data[0][0] = "35";
		data[0][1] = "f";
		data[1][0] = "55";
		data[1][1] = "m";
		data[2][0] = "65";
		data[2][1] = "f";*/
		return data;
	}
}

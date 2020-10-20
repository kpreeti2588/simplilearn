package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.config.EnvConfig;
import com.project.config.ObjectRepos;
import com.project.pages.CaloriePage;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class CalorieCalcPageTestCase {
	
	WebDriver driver;
	@Test(dataProvider="getCalorieData")
	public void CalorieCalcPageTest(Hashtable<String,String> data) throws Exception {
		
	//	if(PropertyReader.getProperty("browser").equalsIgnoreCase("chrome")) {
	//	if(ObjectRepos.QAEnv.browser.equalsIgnoreCase("chrome")) {
		if(EnvConfig.QAEnv.browser.equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.calculator.net/calorie-calculator.html");
	//	driver.get(PropertyReader.getProperty("appurl"));
	//	driver.get(ObjectRepos.QAEnv.appurl);
		driver.get(EnvConfig.QAEnv.appurl);
		driver.manage().window().maximize();
		
		CaloriePage cp = new CaloriePage(driver);
		
		//	cp.setAge(data.get("age"));	
		//	System.out.println(cp.getAge());
			
			// cp.ageTextbox.sendKeys(data.get("age"));    -- can not access public 
			
			cp.enterCalorieDetail(data.get("age"), data.get("sex"), data.get("height"), data.get("weight"));
			driver.close();
		}
		else {
			System.out.println("Invalid browser   "+PropertyReader.getProperty("browser"));
			throw new Exception("Invalid Browser");
		}
		
		
	}
	
	
	@DataProvider
	public Object[][] getCalorieData() throws IOException{	
		ExcelReader reader = new ExcelReader();
		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath +"/src/com/project/testdata";
		String filename = "CalorieData.xlsx";
		String sheetname = "CalorieTestSet";
		
		return reader.ReadExcelToArray(filepath, filename, sheetname);
	
	}

}

package com.project.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.project.utils.PropertyReader;

public class Init {
	
	protected static WebDriver driver = null;

	@Parameters("browser")
    @BeforeMethod
    public void chrome_extension(String browser) throws IOException
    {
    	if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//	System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		driver.get(PropertyReader.getProperty("appurl"));
		driver.manage().window().maximize();			
    }


    @AfterMethod
    public void quit(ITestResult result)
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    	try 
    	{
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));   	 
    	System.out.println("Screenshot taken");
    	} 
    	catch (Exception e)
    	{   	 
    	System.out.println("Exception while taking screenshot "+e.getMessage());
    	}   	 
    	}   	
    	if(driver!=null) {
		//	driver.close();
			driver.quit();
			System.out.println("close driver after method");
			}
    }
    
    

}

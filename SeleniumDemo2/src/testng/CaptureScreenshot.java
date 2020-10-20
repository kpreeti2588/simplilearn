package testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class CaptureScreenshot {

	WebDriver driver;
	
	@Test
	public void CaptureScreen() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		TakesScreenshot ts = (TakesScreenshot)driver; 	
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/defectScreenshot/GoogleError.png"));
		
		
	}
}

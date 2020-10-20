package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTestCase {
	//String browser = "firefox";
	DesiredCapabilities cap = null;
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void GoogleTestCase(String browser) throws MalformedURLException  {
		if(browser.equals("chrome")) {
			cap = DesiredCapabilities.chrome();
		//	cap.setPlatform(Platform.ANY);
		//	cap.setVersion("");
		}
		else if(browser.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://www.google.com");
		WebElement GoogleSearch = driver.findElement(By.name("q"));
		
		GoogleSearch.sendKeys("selenium");
		GoogleSearch.sendKeys(Keys.ENTER);
		
		
		 driver.close();	
	}
	

}

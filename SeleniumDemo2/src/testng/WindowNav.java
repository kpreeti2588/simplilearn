package testng;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowNav {
	WebDriver driver;
	
	@Test
	public void Handl_WindowNav() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String ParentWindowId = driver.getWindowHandle();
		System.out.println("ParentWindow   "+ ParentWindowId);
		
		driver.findElement(By.className("appClose")).click();
		WebElement LoginButton = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
     	Set<String> winid = driver.getWindowHandles();		
		System.out.println("Number of open windows  "+ winid.size());
		
		LoginButton.click();
		
		System.out.println("Number of open windows after clicking on Login button but before window handle "+ winid.size());
		
		winid = driver.getWindowHandles();
		
		System.out.println("Number of open windows after handle:  "+ winid.size());
		
		Iterator<String> itr = winid.iterator();
		String mainwinId = itr.next().toString();
		String subwinId = itr.next().toString();
		
		System.out.println("main window   "+ mainwinId);
		System.out.println("sub window    "+ subwinId);

		driver.switchTo().window(subwinId);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
		
		WebElement UserId = driver.findElement(By.id("User_Id"));
		UserId.sendKeys("Selenium");
		
		Thread.sleep(30000);
		driver.close();
		
		driver.switchTo().window(mainwinId);
		driver.findElement(By.id("topMnuinsurance")).click();
		
		
	}
}

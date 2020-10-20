package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CompositeMouseOp {
	
	WebDriver driver;
	
	@Test
	public void MouseOps() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement componentsMenu = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/a"));
		componentsMenu.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a")));
			WebElement printerElement = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a"));
	
			Actions actions = new Actions(driver);
			actions.moveToElement(printerElement).click().build().perform();
		}
		catch(Exception e) {
			
		}
		//driver.close();
	}

}

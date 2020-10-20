package testng;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.project.config.EnvConfig;

public class HandleAjaxSuggestion {
	WebDriver driver;
	
	@Test
	public void AjaxTest() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("s");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']/li[1]")));
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']/li"));
		
		for (WebElement element : list) {
			if(element.getText().equals("snaptube")) {
				System.out.println("inside loop");
				element.click();
				break;
			}			
		}
		}
		catch(NoSuchElementException e) {
			System.out.println("No such element exception");			
		}
		catch(InvalidSelectorException e) {
			System.out.println("Invalid Selector exception");			
		}
		catch(TimeoutException e) {
			System.out.println("Timeout exception");			
		}
	}

}

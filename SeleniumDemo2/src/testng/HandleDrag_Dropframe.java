package testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleDrag_Dropframe {
	
	WebDriver driver;
	
	@Test
	public void CaptureScreen() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(frameElement);
		
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragElement, dropElement).build().perform();
		
		String verifyDroppedmsg = dropElement.getText();
		
		if(verifyDroppedmsg.equals("Dropped!")) {
			System.out.println("Dropped successfully");
		}
		else {
			System.out.println("Dropped was not successful");
		}
		
	}	

}

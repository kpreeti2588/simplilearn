package testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.project.config.EnvConfig;

public class HandlePopups {
	
	WebDriver driver;
	@Test
	public void AlertHandling() throws InterruptedException {
			Alert alert = null;
			JavascriptExecutor js = null;
			String alertmsg = null;
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();

			driver.get(EnvConfig.QAEnv.appurl);
			driver.manage().window().maximize();
		
			try {
			js = (JavascriptExecutor)driver;
			//js.executeScript("alert('this is an information message');");
			
			alert = driver.switchTo().alert();
			alertmsg = alert.getText();
			Thread.sleep(3000);
			alert.accept();  // click on ok
				
			if(alertmsg.equals("this is an information message")) {
					System.out.println("Alert msg match found");
			}
			else {
					System.out.println("Alert msg match not found");
				}
			}
			catch(NoAlertPresentException e) {
				System.out.println("No alert present");
			}
			
			js.executeScript("confirm('Do you want to continue(y/n)?');");
				
			alert = driver.switchTo().alert();
			alertmsg = alert.getText();
			Thread.sleep(3000);
			alert.dismiss();  //Click on cancel
			
			if(alertmsg.equals("this is an information message")) {
				System.out.println("Alert msg match found");
			}
			else {
				System.out.println("Alert msg match not found");
			}
			
	}

}

package Launch;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class launch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String browser ="ie";
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			File extractPath=new File("C:\\tmp");
			InternetExplorerDriverService service = new InternetExplorerDriverService.Builder().withExtractPath(extractPath).build();

			driver = new InternetExplorerDriver(service);
		
		}
		driver.get("https://www.google.com");
		
		Thread.sleep(2000);		
		driver.close();
		
	}

}

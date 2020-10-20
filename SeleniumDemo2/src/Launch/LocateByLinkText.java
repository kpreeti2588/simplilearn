package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByLinkText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		System.out.println("title "+ driver.getTitle());
		System.out.println("URL "+ driver.getCurrentUrl());
		System.out.println("Page Source  "+ driver.getPageSource());
		
		driver.manage().window().maximize();
		
		WebElement bmiLink = driver.findElement(By.linkText("BMI"));
		bmiLink.click();
		System.out.println("title "+ driver.getTitle());
		System.out.println("URL "+ driver.getCurrentUrl());
		
		WebElement weight = driver.findElement(By.partialLinkText("Weight"));
		weight.click();
		System.out.println("title "+ driver.getTitle());
		System.out.println("URL "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("title "+ driver.getTitle());
		System.out.println("URL "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().forward();
		System.out.println("title "+ driver.getTitle());
		System.out.println("URL "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.close();
		
	}

}

package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		
		driver.manage().window().maximize();
		
		WebElement ageLabel = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[1]/tbody/tr[1]/td[1]"));
		System.out.println("Value of attribute   "+ageLabel.getText());
		
		WebElement age = driver.findElement(By.xpath("//table[@id='calinputtable']/tbody/tr[1]/td[1]"));
		
	//	WebElement age = driver.findElement(By.cssSelector("*[id='calinputtable'] > tbody > tr:nth-child(1) > td:nth-child(1)"));
	//	WebElement age = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
		System.out.println("Relative Value of attribute   "+age.getText());
		
		//WebElement testbox = driver.findElement(By.cssSelector("#cage"));
		driver.close();
		
	}

}

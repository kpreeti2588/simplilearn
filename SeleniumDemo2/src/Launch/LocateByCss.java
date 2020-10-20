package Launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		
		driver.manage().window().maximize();

		
	//	WebElement age = driver.findElement(By.cssSelector("*[id='calinputtable'] > tbody > tr:nth-child(1) > td:nth-child(1)"));
		WebElement age = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
		System.out.println("Relative Value of attribute   "+age.getText());
		
	   WebElement testbox = driver.findElement(By.cssSelector("#cage"));
	   System.out.println("value of test box   "+ testbox.getAttribute("value"));
	   
	   WebElement table = driver.findElement(By.cssSelector(".cinfoT"));
	   List<WebElement> rows= table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> col = row.findElements(By.tagName("td"));
			for (WebElement cols : col) {
				System.out.print(cols.getText()+" \t");
			}
			System.out.println("");
		}
		
		Thread.sleep(2000);		
	   
		driver.close();
	}

}

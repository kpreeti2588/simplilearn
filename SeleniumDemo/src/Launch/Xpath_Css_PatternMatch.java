package Launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Css_PatternMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		
		driver.manage().window().maximize();
		
		List<WebElement> startswithidxpath = driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));	
		
		//   ^  ---> starts-with,  * ---> contains,   $  ---> ends-with
		System.out.println("count  "+startswithidxpath.size());
		
		for (WebElement id : startswithidxpath) {
			System.out.println(id.getAttribute("id"));		
		}
		
		
		List<WebElement> containsnameheightxpath = driver.findElements(By.xpath("//*[contains(@name,'height')]"));	
		System.out.println("count of height   "+containsnameheightxpath.size());
		
		for (WebElement id : containsnameheightxpath) {
			System.out.println(id.getAttribute("name"));		
		}
		
        List<WebElement> startswithidcss = driver.findElements(By.cssSelector("[id^='c']"));	
		
		//   ^  ---> starts-with,  * ---> contains,   $  ---> ends-with
		System.out.println("count  "+startswithidcss.size());
		
		for (WebElement id : startswithidcss) {
			System.out.println(id.getAttribute("id"));		
		}
		
		
		List<WebElement> containsnameheightcss = driver.findElements(By.cssSelector("[name*='height']"));	
		System.out.println("count of height   "+containsnameheightcss.size());
		
		for (WebElement id : containsnameheightcss) {
			System.out.println(id.getAttribute("name"));		
		}
		
	}

}

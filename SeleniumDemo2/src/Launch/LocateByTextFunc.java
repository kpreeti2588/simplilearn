package Launch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocateByTextFunc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		
		WebElement activity =driver.findElement(By.id("cactivity"));
		
		
		/*   xpath = //*[@id='cactivity']/option[1]
		 *   xpath = //*[@id='cactivity']/option[@value='1.55']
		 *   xpath = //*[@id='cactivity']/option[text()='Extra Active: very intense exercise daily, or physical job']
		 *   xpath = //*[@id='cactivity']/option[contains(text(),'Active')]
		 * 
		 * 
		 * 
		 * */
		
		Select d = new Select(activity);
		System.out.println("First selected option   "+ d.getFirstSelectedOption().getText());
		
		d.selectByIndex(1);
		
		Thread.sleep(2000);
		System.out.println("Second value "+d.getFirstSelectedOption().getText());
		d.selectByValue("1.725");
		
		Thread.sleep(2000);
		System.out.println("third value "+d.getFirstSelectedOption().getText());
		
		d.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
		Thread.sleep(2000);
		System.out.println("Fourth value "+d.getFirstSelectedOption().getText());
		
		List<WebElement> Options= activity.findElements(By.tagName("option"));
		for (WebElement op : Options) {
			System.out.println(op.getText());			
		}
		System.out.println("is dropdown multi select  "+ d.isMultiple());
		
		WebElement basal = driver.findElement(By.xpath("//*[@id='cactivity']/option[1]"));
		System.out.println("basal option   "+ basal.getText());
		
		WebElement active = driver.findElement(By.xpath("//*[@id='cactivity']/option[@value='1.55']"));
		System.out.println("active option  "+active.getText());
		
		
		WebElement extraActive = driver.findElement(By.xpath("//*[@id='cactivity']/option[text()='Extra Active: very intense exercise daily, or physical job']"));
		System.out.println("Extra active option  "+active.getText());
		
		List<WebElement> activeOptions = driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
		System.out.println("count of Active options  "+  activeOptions.size());
		
		for (WebElement webElement : activeOptions) {
			System.out.println("option "+ webElement.getText());
		}
		
		driver.close();
		
	}

}

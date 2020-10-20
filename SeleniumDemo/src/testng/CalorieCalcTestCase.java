package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalcTestCase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "getCalorieData")
	public void CalorieCalcTest(String dage, String dsex) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/bmi-calculator.html");
		
	//	WebElement age= driver.findElement(By.id("cage"));
		WebElement age= driver.findElement(By.xpath("//*[@id='cage']"));
		age.clear();
		age.sendKeys(dage);
		System.out.println("attribute value of name  "+age.getAttribute("name"));
		System.out.println("attribute value of id  "+age.getAttribute("id"));
		System.out.println("attribute value of css  "+age.getAttribute("class"));
		System.out.println("attribute value of type  "+age.getAttribute("type"));
		System.out.println("attribute value of value  "+age.getAttribute("value"));
		System.out.println("Tag name "+ age.getTagName());
		
		
	//	List<WebElement> genderList= driver.findElements(By.name("csex"));
		List<WebElement> genderList= driver.findElements(By.xpath("//*[@name='csex']"));
		
		for (WebElement gender : genderList) {
			if(gender.getAttribute("value").equals(dsex)) {
				if(!gender.isSelected()) {
					gender.click();
					break;
				}
			}
		}
		
		//WebElement table = driver.findElement(By.className("cinfoT"));
		
		WebElement table = driver.findElement(By.xpath("//*[@class='cinfoT']"));
		List<WebElement> rows= table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> col = row.findElements(By.tagName("td"));
			for (WebElement cols : col) {
				System.out.print(cols.getText()+" \t");
			}
			System.out.println("");
		}		
		Thread.sleep(2000);		
	}
	
	@AfterMethod
	public void closeBrowser() {
		if(driver!=null) {
		driver.close();
		driver.quit();
		}
	}

	@DataProvider
	public Object[][] getCalorieData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "35";
		data[0][1] = "f";
		data[1][0] = "55";
		data[1][1] = "m";
		data[2][0] = "65";
		data[2][1] = "f";
		return data;
	}
}

package Launch;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/bmi-calculator.html");
		
	//	WebElement age= driver.findElement(By.id("cage"));
		WebElement age= driver.findElement(By.xpath("//*[@id='cage']"));
		age.clear();
		age.sendKeys("45");
		System.out.println("attribute value of name  "+age.getAttribute("name"));
		System.out.println("attribute value of id  "+age.getAttribute("id"));
		System.out.println("attribute value of css  "+age.getAttribute("class"));
		System.out.println("attribute value of type  "+age.getAttribute("type"));
		System.out.println("attribute value of value  "+age.getAttribute("value"));
		System.out.println("Tag name "+ age.getTagName());
		
		
	//	List<WebElement> genderList= driver.findElements(By.name("csex"));
		List<WebElement> genderList= driver.findElements(By.xpath("//*[@name='csex']"));
		
		for (WebElement gender : genderList) {
			if(gender.getAttribute("value").equals("f")) {
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
		driver.close();
		
		
	}

}

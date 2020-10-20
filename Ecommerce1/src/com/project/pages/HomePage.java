package com.project.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.project.utils.PropertyReader;

import net.sf.saxon.exslt.Math;

public class HomePage {
	
	@FindBy(css="a.login")
	private WebElement loginLink;
	
	@FindBy(css="span.navigation_page")
	private static WebElement homeaccount;
	
	@FindBy(css="a.account")
	private WebElement userName; 
	
	@FindBy(css="a.logout")
	private WebElement logout;
	
	@FindBy(id="search_query_top")
	private WebElement Searchtextbox;
	
	@FindBy(name="submit_search")
	private WebElement SearchButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/div[2]/div[2]")
	private WebElement getItemText;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	private WebElement Blankmessage;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	private List<WebElement> ListofItems;	
	
	@FindBy(xpath=" //*[@id='manufacturers_block_left']/div/ul/li/a")
	private WebElement manufacturer;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	private WebElement manufacturerHeading;
	
	@FindBy(css="button.btn.btn-default.btn-pinterest")
	private WebElement Pinterest;
	
	@FindBy(css="button.btn.btn-default.btn-google-plus")
	private WebElement google;
	
	@FindBy(css="button.btn.btn-default.btn-facebook")
	private WebElement facebook;
	
	@FindBy(xpath="//button/span")
	private WebElement addtoCart;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button/span")
	private WebElement addCartwoframe;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
	private WebElement continueShopping;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	private WebElement checkout;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirt;
	
	@FindBy(xpath="//*[@id='cart_title']/span/span")
	private WebElement CartProduct;

	@FindBy(css="a.sf-with-ul")
	private WebElement Women;
	
	@FindBy(xpath="//*[@id='subcategories']/ul/li[1]/div[1]/a")
	private WebElement tops;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div/a[1]")
	private WebElement singleproduct;
		
	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]")
	private WebElement proceedtoCheckout;
	
	@FindBy(xpath="//*[@id='center_column']/form/p/button")
	private WebElement addressCheckout;
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//*[@id='form']/p/button")
	private WebElement shippingCheckout;
	
	@FindBy(xpath="//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
	private WebElement paymentMethod;
	
	@FindBy(xpath="//*[@id='cart_navigation']/button")
	private WebElement confirmOrder;
	
	@FindBy(xpath="//*[@id='center_column']/p[1]")
	private WebElement successMessage;
	
	@FindBy(xpath="//*[@id='product_comments_block_extra']/ul/li/a")
	private WebElement review;

	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickSignIn() {
		loginLink.click();
	}
	
	public static String getAccountText() {
		return homeaccount.getText();
	}
	
	public String getAccountName() {
		return userName.getText();
		
	}
	
	public boolean LogoffAppear() {
		return logout.isDisplayed();
	}
	
	public void clickSignout() {
		logout.click();
	}
	
	public void SearchItem(String value) throws InterruptedException {
		Thread.sleep(1000);
		Searchtextbox.clear();
		Searchtextbox.sendKeys(value);
	}
	
	public void clickSearchButton() {
		SearchButton.click();
	}
	
	public String countItem() {
		String value = getItemText.getText().trim();
		System.out.println(value);
		int value1= value.indexOf("of")+2;
		int value2= value.indexOf("items");
		String count = value.substring(value1, value2).trim();
		return count;
	}
	
	public void getTextSearchMessage() {
		if(Blankmessage.isDisplayed()) {
		System.out.println(Blankmessage.getText());
		Assert.assertTrue(Blankmessage.getText().contains("No results were found for your search"), "Message is displaying correctly");				
		}
	}
	
	public void getTextSearchMessageforBlankKeyword() {
		if(Blankmessage.isDisplayed()) {
		System.out.println(Blankmessage.getText());	
		Assert.assertTrue(Blankmessage.getText().contains("Please enter a search keyword"), "Message is displaying correctly for blank keyword");
		}
	}
	
	public int getCountofSearchResult() {
		return ListofItems.size();
	}
	
	public String clickManufacturer() {
		String value=manufacturer.getText();
		manufacturer.click();
		return value;
	}
	
	public String getHeading() {
		System.out.println(manufacturerHeading.getText());
		return manufacturerHeading.getText();
	}
	
	public void clickonProductQuickView() throws InterruptedException {
		int value = (int) ((Math.random())*getCountofSearchResult());	
		if(value==0) {
			value=value+1;
			}
		String path= "//*[@id='best-sellers_block_right']/div/ul/li["+value+"]/a/img";

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			WebElement product= driver.findElement(By.xpath(path));
			product.click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}					
	}
	
	public void clickonPinterest() throws InterruptedException {
		Thread.sleep(2000);	
		Pinterest.click();
	}
	
	public void clickonGoogle() throws InterruptedException {
		Thread.sleep(2000);
		google.click();
	}
	
	public void clickonFacebook() throws InterruptedException {
		Thread.sleep(2000);
		facebook.click();
	}
	
	public void clickAddtoCart() throws InterruptedException {	
		driver.switchTo().frame(0);
		Thread.sleep(10000);
		addtoCart.click();
	}
	
	public void clickCartwoFrame() throws InterruptedException {
		Thread.sleep(10000);
		addCartwoframe.click();
	}
	
	public void clickTshirt() {
		tshirt.click();
		driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")).click();
	}
	
	public void clickContinueShopping() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")));
			continueShopping.click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void clickCheckout( ) throws InterruptedException {		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			if(PropertyReader.getProperty("browser").contentEquals("chrome")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")));
			checkout.click();
			}
			else {
				driver.navigate().to("http://automationpractice.com/index.php?controller=order");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public String getProductCount() {
		String value = CartProduct.getText();
		int end = value.indexOf("Product");	
		String val1 = value.substring(0, end-1);
		return val1;
	}
	
    public void clickonProduct() throws InterruptedException, IOException {
    	Women.click();
    	tops.click(); 	
    	List<WebElement> product = driver.findElements(By.xpath("//*[@id='subcategories']/ul/li"));
    	for (WebElement webElement : product) {
			if(webElement.getText().contentEquals("BLOUSES")) {
				webElement.click();						
			}
		}
    	clickonProductQuickView1();
    }
    
    public void clickonProductQuickView1() throws InterruptedException, IOException { 	
     	if(PropertyReader.getProperty("browser").contentEquals("chrome")) {
         Thread.sleep(2000);  	
    	 singleproduct.click();
     	}
     	else {
     		 WebElement element = driver.findElement(By.cssSelector("a.product_img_link"));
     		 scrollTo(element);
             JavascriptExecutor js = ((JavascriptExecutor) driver);
             js.executeScript("arguments[0].click();",element);
     	}
    	
    }
    
    public void scrollTo(WebElement x) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", x);
        }
    
    public void clickonCheckout() throws InterruptedException {
    	proceedtoCheckout.click();
    	Thread.sleep(1000);
    }
    
    public void addressCheckout() throws InterruptedException {
    	addressCheckout.click();
    	Thread.sleep(1000);
    }
    
    public void clickTerms() {
    	terms.click();
    }
    
    public void shippingCheckout() throws InterruptedException {
    	shippingCheckout.click();
    	Thread.sleep(1000);   	
    }
    
    public void selectPaymentMethod() throws InterruptedException {
		paymentMethod.click();
    	Thread.sleep(10000);
    }
    
    public void clickConfirmOrder() {
    	confirmOrder.click();
    }
    
    public String getSucessMessage() {
    	return successMessage.getText();
    }
    
    public void clickReview() {
    	review.click();
    
    }
	 
}

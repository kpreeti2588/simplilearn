package testng;

import org.testng.annotations.Test;

public class TestNGExample {
	
	@Test(priority=1)
	public void validateLogin() {
		System.out.println("Logged in ");
		
	}
	
	@Test(priority=4)
	public void LogOff() {
		System.out.println("Logged Off ");
		
	}
	
	@Test(priority=3)
	public void Reporting() {
		System.out.println("Reporting");
		
	}
	
	@Test(priority=2)
	public void AccountEnquiry() {
		System.out.println("Account Enquiry");
		
	}

}

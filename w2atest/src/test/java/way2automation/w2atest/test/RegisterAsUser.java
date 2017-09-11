package way2automation.w2atest.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import way2automation.w2atest.pageObjects.RegistrationPage;
import way2automation.w2atest.resources.Base;



public class RegisterAsUser extends Base {
	
	@BeforeMethod
	public void loginValid()
	{
	LoginAsValidUser vu = new LoginAsValidUser();
	vu.login(TEST_USER, TEST_PASSWORD);
	WebDriverWait w = new WebDriverWait(driver,10);
	WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(5)>ul>li>a")));
	testItem.click();
	}
	
	@Test
	public void registerUser() 
	{
	   RegistrationPage rp = new RegistrationPage(driver);
	  //verify on Registration page
	  Assert.assertTrue(rp.isPageOpen());
	  
	  rp.setFirstName("Amanda");
	  rp.setLastName("Fernandes");
	  rp.setMaritalStatus("Married");
	  rp.setHobby("Cricket");
	  rp.setPhone("703.333.4567");
	  rp.setEmail("dcunhaa@yahoo.com");
	  rp.setUsername("amandaferns");
	  rp.setPassword("mypassword");
	  rp.setCPassword("mypassword");
	  rp.setAboutYou("I love cricket and live on the west coast");
	  rp.selectCountry("India");
	  rp.selectMonth("1");
	  rp.selectDay("1");
	  rp.selectYear("2014");
	  try {
		rp.uploadFile("/Users/admin/amandaprofilepic.jpg");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  rp.clickSubmitBtn();
	}
}

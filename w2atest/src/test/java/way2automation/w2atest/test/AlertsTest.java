package way2automation.w2atest.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;



public class AlertsTest extends Base {
	
	@BeforeMethod	
	public void loginValid()
	{
	LoginAsValidUser vu = new LoginAsValidUser();
	vu.login(TEST_USER, TEST_PASSWORD);
	//Navigate to the page
	WebDriverWait w = new WebDriverWait(driver,10);
	WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(6)>ul>li>a")));
	testItem.click();
	}	
	
  @Test
  public void alertTest() 
  {
	
	  //test Simple Alert
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  driver.findElement(By.tagName("button")).click();
	  Assert.assertTrue(driver.switchTo().alert().getText().equals("I am an alert box!"));
	  driver.switchTo().alert().accept();
	  driver.switchTo().defaultContent();

	  //test Input Alert
	  driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
	  driver.switchTo().frame(1);
	  //w.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
	  driver.findElement(By.tagName("button")).click();
	  String name = "Amanda";
	  driver.switchTo().alert().sendKeys(name);
	  driver.switchTo().alert().accept();
	  //Verify Input entered in Alert was accepted
	  Assert.assertTrue(driver.findElement(By.id("demo")).getText().equals("Hello "+name+"! How are you today?"));
	  driver.switchTo().defaultContent();
	  
  }
}

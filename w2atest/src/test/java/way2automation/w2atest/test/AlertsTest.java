package way2automation.w2atest.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;



public class AlertsTest extends Base {
  @Test
  @Parameters({"username","password","name"})
  public void f(String userN,String userP, String name) throws InterruptedException 
  {
	  LoginAsValidUser vu = new LoginAsValidUser();
	  vu.login(userN, userP);

	  //Navigate to the Alerts page
	  WebDriverWait w = new WebDriverWait(driver,10);
	  WebElement alertItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(6)>ul>li>a")));

	  alertItem.click();
	  //verify on Alert page
	  Assert.assertTrue(driver.findElement(By.cssSelector("h1.heading:nth-of-type(1)")).getText().equals("Alert"));
	  
	  //test Simple Alert
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  driver.findElement(By.tagName("button")).click();
	  Assert.assertTrue(driver.switchTo().alert().getText().equals("I am an alert box!"));
	  driver.switchTo().alert().accept();
	  driver.switchTo().defaultContent();

	  //test Input Alert
	  driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
	
	  driver.switchTo().frame(1);
	  w.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
	  driver.findElement(By.tagName("button")).click();
	  
	  driver.switchTo().alert().sendKeys(name);
	  driver.switchTo().alert().accept();
	  //Verify Input entered in Alert was accepted
	  Assert.assertTrue(driver.findElement(By.id("demo")).getText().equals("Hello "+name+"! How are you today?"));
	  driver.switchTo().defaultContent();
	  
  }
}

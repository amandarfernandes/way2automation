package way2automation.w2atest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;

public class DynamicButtons extends Base {

	@Test
	@Parameters({"username","password"})
	public void f(String userN,String userP) {
		//login as a valid user 
		LoginAsValidUser vu = new LoginAsValidUser();
		vu.login(userN, userP);
		
		  //Navigate to the Dynamic Buttons page
		  WebDriverWait w = new WebDriverWait(driver,10);
		  WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(4)>ul>li:nth-of-type(1)>a")));

		  testItem.click();
		  //verify on Dynamic Buttons page
		  Assert.assertTrue(driver.findElement(By.cssSelector("h1.heading:nth-of-type(1)")).getText().equals("Submit Button Clicked"));
		  
		  //test dynamic  button with constant starting id
		  driver.switchTo().frame(0);
		  driver.findElement(By.xpath(".//input[@type=\"text\"]")).sendKeys("test1");
		  driver.findElement(By.xpath(".//input[@type=\"button\"]")).click();
		  Assert.assertTrue(driver.findElement(By.xpath(".//input[starts-with(@id,'submit')]")).isEnabled());
		  driver.switchTo().defaultContent();
		  
		  driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
		  driver.switchTo().frame(1);
		  driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Test 2");
		  driver.findElement(By.xpath(".//input[@type=\"button\"]")).click();
		  Assert.assertTrue(driver.findElement(By.cssSelector("input[id$='1111']")).isEnabled());
		  
		  driver.switchTo().defaultContent();
		  driver.findElement(By.cssSelector("a[href*='tab-3']")).click();
		  driver.switchTo().frame(2);
		  driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Test 3");
		  driver.findElement(By.xpath(".//input[@id='1111']")).click();
		  Assert.assertTrue(driver.findElement(By.cssSelector("input[type='button'][name='submit']")).isEnabled());
		  
	}
}

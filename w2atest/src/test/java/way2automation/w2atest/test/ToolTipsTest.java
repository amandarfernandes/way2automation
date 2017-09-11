package way2automation.w2atest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;

public class ToolTipsTest extends Base{

	@BeforeMethod	
	public void loginValid()
	{
	LoginAsValidUser vu = new LoginAsValidUser();
	vu.login(TEST_USER, TEST_PASSWORD);
	//Navigate to the page
	WebDriverWait w = new WebDriverWait(driver,10);
	WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(2)>ul>li:nth-child(7)>a")));
	testItem.click();
	}

@Test
	public void TTTest1() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href*='tab-1']")).click();
		driver.switchTo().frame(0);	
		
		WebElement tt1 = driver.findElement(By.cssSelector("p:nth-of-type(1)>a"));
		Actions a = new Actions(driver);
		a.clickAndHold(tt1).perform();
		//a.moveToElement(tt1).build().perform();
		WebElement ttText1 = driver.findElement(By.cssSelector("div[id^='ui-id-']"));
		System.out.println(ttText1.getText());
		Assert.assertEquals(ttText1.getText(),"That's what this widget is");	
		
		WebElement tt2 = driver.findElement(By.cssSelector("p:nth-of-type(2)>a"));
		//a.clickAndHold().moveToElement(tt2);
		//a.moveToElement(tt2).build().perform();
		a.clickAndHold(tt2).perform();
		//WebDriverWait w = new WebDriverWait(driver, 15);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='tooltip']")));
		Thread.sleep(3000);
		WebElement ttText2 = driver.findElement(By.cssSelector("div[role='tooltip']"));
		System.out.println(ttText2.getText());
		Assert.assertEquals(ttText2.getText(),"ThemeRoller: jQuery UI's theme builder application");	
		
		WebElement tt3 = driver.findElement(By.id("age"));
		a.moveToElement(tt3).build().perform();
		Thread.sleep(3000);
		WebElement ttText3 = driver.findElement(By.cssSelector("div[id^='ui-id-']"));
		System.out.println(ttText3.getText());
		Assert.assertEquals(ttText3.getText(),"We ask for your age only for statistical purposes.");	

		driver.switchTo().defaultContent();
	}


@Test
public void TTTest2() throws InterruptedException {

	driver.switchTo().defaultContent();
	driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
	driver.switchTo().frame(1);	
	
	WebElement tt1 = driver.findElement(By.cssSelector("p:nth-of-type(2)>a#show-option"));
	Actions a = new Actions(driver);
	//a.clickAndHold(tt1).perform();
	a.moveToElement(tt1).build().perform();
	Thread.sleep(2000);
	WebElement ttText1 = driver.findElement(By.cssSelector("div[role='tooltip']"));
	System.out.println("Tool Tip Text is - "+ttText1.getText());
	Assert.assertEquals(ttText1.getText(),"slide down on show");	
	
	WebElement tt2 = driver.findElement(By.cssSelector("a#hide-option"));
	a.moveToElement(tt2).build().perform();
	Thread.sleep(2000);
	WebElement ttText2 = driver.findElement(By.cssSelector("div[role='tooltip']"));
	System.out.println(ttText2.getText());
	Assert.assertEquals(ttText2.getText(),"explode on hide");	
	
	WebElement tt3 = driver.findElement(By.cssSelector("a#open-event"));
	a.moveToElement(tt3).build().perform();
	Thread.sleep(2000);
	WebElement ttText3 = driver.findElement(By.cssSelector("div[id^='ui-id-']"));
	System.out.println(ttText3.getText());
	Assert.assertEquals(ttText3.getText(),"move down on show");	
	
	driver.switchTo().defaultContent();
}
}

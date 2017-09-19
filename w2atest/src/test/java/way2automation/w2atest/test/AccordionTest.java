package way2automation.w2atest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import way2automation.w2atest.resources.Base;
import way2automation.w2atest.resources.Log;

public class AccordionTest extends Base {
	
	
	@BeforeMethod
	public void login() throws InterruptedException {
		driver = InitializeDriver();
		Log.info("Driver Initialized");
		LoginAsValidUser vu = new LoginAsValidUser();
		vu.login(TEST_USER,TEST_PASSWORD);
		Log.info("Logged into way2automation site");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.row > div:nth-child(2) > ul> li:nth-child(1) > a")).click();
		Log.info("Navigated to Accordion Page");
		
	}
	
	@Test
	public void accordionTest1() throws InterruptedException {
		//System.out.println("Test");
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-1']")).click();
			
		driver.switchTo().frame(0);
		Log.info("Verifying Default Accordion");
		WebElement tab1H = driver.findElement(By.id("ui-id-1"));
		WebElement tab1C = driver.findElement(By.id("ui-id-2"));
		
		WebElement tab2H = driver.findElement(By.id("ui-id-3"));
		WebElement tab2C = driver.findElement(By.id("ui-id-4"));
		
		WebElement tab3H = driver.findElement(By.id("ui-id-5"));
		WebElement tab3C = driver.findElement(By.id("ui-id-6"));
		
		WebElement tab4H = driver.findElement(By.id("ui-id-7"));
		WebElement tab4C = driver.findElement(By.id("ui-id-8"));

		Assert.assertTrue(tab1C.isDisplayed());
		Log.info("Verified tab 1 content is displayed by default");
		Assert.assertFalse(tab2C.isDisplayed());
		Assert.assertFalse(tab3C.isDisplayed());
		Assert.assertFalse(tab4C.isDisplayed());
		Log.info("Verified tabs 2,3,4 content are not displayed by default");
		tab2H.click();
		Log.info("Select tab 2");
		Thread.sleep(2000);
		Assert.assertTrue(tab2C.isDisplayed());
		Assert.assertFalse(tab1C.isDisplayed());		
		Assert.assertFalse(tab3C.isDisplayed());
		Assert.assertFalse(tab4C.isDisplayed());	
		Log.info("Verified tab 2 is displayed and tabs 1,3,4 content are not displayed by default");
		tab3H.click();
		Thread.sleep(2000);
		Assert.assertTrue(tab3C.isDisplayed());
		Assert.assertFalse(tab1C.isDisplayed());		
		Assert.assertFalse(tab2C.isDisplayed());
		Assert.assertFalse(tab4C.isDisplayed());	
		Log.info("Verified tab 3 is displayed and tabs 1,2,4 content are not displayed by default");
	}
	
	@Test
	public void accordionTest2() throws InterruptedException {

		
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-2']")).click();
		Log.info("Selected 2nd Accordian type");
		driver.switchTo().frame(1);
		
		WebElement tab1H = driver.findElement(By.id("ui-id-1"));
		WebElement tab1C = driver.findElement(By.id("ui-id-2"));
		
		WebElement tab2H = driver.findElement(By.id("ui-id-3"));
		WebElement tab2C = driver.findElement(By.id("ui-id-4"));
		
		WebElement tab3H = driver.findElement(By.id("ui-id-5"));
		WebElement tab3C = driver.findElement(By.id("ui-id-6"));
		
		WebElement tab4H = driver.findElement(By.id("ui-id-7"));
		WebElement tab4C = driver.findElement(By.id("ui-id-8"));

		WebElement toggleBtn = driver.findElement(By.id("toggle"));
		
		AssertJUnit.assertTrue(tab1C.isDisplayed());
		AssertJUnit.assertFalse(tab2C.isDisplayed());		
		AssertJUnit.assertFalse(tab3C.isDisplayed());
		AssertJUnit.assertFalse(tab4C.isDisplayed());
		Log.info("Verified default open tab");
		System.out.println(tab1H.getAttribute("class"));
		List<WebElement> iconTest = driver.findElements(By.cssSelector("h3 > span"));
		System.out.println(iconTest.size());
		AssertJUnit.assertEquals(iconTest.size(),4);
		toggleBtn.click();
		Log.info("Clciked on toggle button ");
		System.out.println(tab1H.getAttribute("class"));
		Log.info("Accordion classes are "+ tab1H.getAttribute("class"));
		iconTest = driver.findElements(By.cssSelector("h3 > span"));
		System.out.println(iconTest.size());
		Log.info("Icon spans present -"+iconTest.size());
		AssertJUnit.assertEquals(iconTest.size(),0);
		Log.info("Verified accordion icons removed");
		tab2H.click();
		Thread.sleep(2000);
		AssertJUnit.assertTrue(tab2C.isDisplayed());
		AssertJUnit.assertFalse(tab1C.isDisplayed());		
		AssertJUnit.assertFalse(tab3C.isDisplayed());
		AssertJUnit.assertFalse(tab4C.isDisplayed());	
		Log.info("Verified accordion behavior on second group");
		tab3H.click();
		Thread.sleep(2000);
		AssertJUnit.assertTrue(tab3C.isDisplayed());
		AssertJUnit.assertFalse(tab1C.isDisplayed());		
		AssertJUnit.assertFalse(tab2C.isDisplayed());
		AssertJUnit.assertFalse(tab4C.isDisplayed());	
		Log.info("Verified accordion behavior on third group");
	}
	
}

package way2automation.w2atest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;

public class DropdownsTest extends Base{

	@BeforeMethod
	public void loginValid()
	{
	LoginAsValidUser vu = new LoginAsValidUser();
	vu.login(TEST_USER, TEST_PASSWORD);
	WebDriverWait w = new WebDriverWait(driver,10);
	WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(4)>ul>li:nth-child(2)>a")));
	testItem.click();
	}
	
	
	@Test
	public void selectTest() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href*='tab-1']")).click();
		driver.switchTo().frame(0);	
		Select cntryDropdown = new Select(driver.findElement(By.tagName("select")));
		cntryDropdown.selectByVisibleText("Cambodia");
		Assert.assertEquals(cntryDropdown.getFirstSelectedOption().getText(),"Cambodia");
		cntryDropdown.selectByValue("Bolivia");;
		Assert.assertEquals(cntryDropdown.getFirstSelectedOption().getText(),"Bolivia");
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void dynamicSelectTest1() {

		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
		driver.switchTo().frame(1);	
		driver.findElement(By.cssSelector("input")).clear();
		String srchItem = "ind", selectedCountry="India";
		driver.findElement(By.cssSelector("input")).sendKeys(srchItem);
		List <WebElement> cntryList = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		for (WebElement country:cntryList) {
			String expected=country.getText().toLowerCase();
			Assert.assertTrue(expected.contains(srchItem.toLowerCase()));
		}
		for (WebElement country:cntryList) {
				if (country.getText().equals(selectedCountry)) {
				country.click();
				break;
			}
		}
		System.out.println("text entered -"+driver.findElement(By.cssSelector("input")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.cssSelector("input")).getAttribute("value"),selectedCountry);
		driver.switchTo().defaultContent();
	}	
	
	@Test
	public void dynamicSelectTest2() throws InterruptedException {
				  
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href*='tab-2']")).click();
		driver.switchTo().frame(1);	
		String selectedCountry = "India";
		//driver.findElement(By.cssSelector("input")).clear();
		driver.findElement(By.cssSelector("a[title='Show All Items']")).click();
		List <WebElement> cntryList = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		for (WebElement country:cntryList) {
			
			if (country.getText().equals(selectedCountry)) {
				country.click();
				break;
			}
		}
		//Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("input")).getAttribute("value"),selectedCountry);	
		driver.switchTo().defaultContent();
	}	
}


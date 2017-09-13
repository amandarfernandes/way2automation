package way2automation.w2atest.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;

public class FrameWindowTest extends Base{

	@BeforeMethod
	public void login() {
		LoginAsValidUser vu = new LoginAsValidUser();
		vu.login(TEST_USER, TEST_PASSWORD);
		//Navigate to the page
		WebDriverWait w = new WebDriverWait(driver,10);
		WebElement testItem = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='row']>div:nth-child(3)>ul>li>a")));
		testItem.click();	
		
	}
	
	@Test
	public void framesTest1() {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-1']")).click();
		
		driver.switchTo().frame(0);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("New Browser Tab")).click();
		
		Set<String> wHandles = driver.getWindowHandles();
		Iterator<String> i = wHandles.iterator();
		
		String pWindow = i.next();
		String cWindow = i.next();
		
		driver.switchTo().window(cWindow);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "jQuery UI Datepicker - Default functionality");
		driver.switchTo().window(pWindow);
		Assert.assertEquals(driver.getTitle(), "Welcome");;
	
	}
	
	@Test
	public void framesTest2() {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-2']")).click();
		
		driver.switchTo().frame(1);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Open New Seprate Window")).click();
		
		Set<String> wHandles = driver.getWindowHandles();
		Iterator<String> i = wHandles.iterator();
		System.out.println("No. of wondows - "+wHandles.size());
		
		String pWindow = i.next();
		String cWindow = i.next();
		
		driver.switchTo().window(cWindow);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Open New Seprate Window");
		driver.switchTo().window(pWindow);
		Assert.assertEquals(driver.getTitle(), "Welcome");;
	}

	@Test
	public void framesTest3() {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-3']")).click();
		
		driver.switchTo().frame(2);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Open Frameset Window")).click();
		
		Set<String> wHandles = driver.getWindowHandles();
		Iterator<String> i = wHandles.iterator();
		System.out.println("No. of wondows - "+wHandles.size());
		
		String pWindow = i.next();
		String cWindow = i.next();
		
		driver.switchTo().window(cWindow);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "HTML Frames - Example 1");
		
		List<WebElement> numFrames = driver.findElements(By.tagName("frame"));
		System.out.println("Num Frames:"+numFrames.size());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("topFrame");
	
		System.out.println(driver.findElement(By.tagName("body")).getCssValue("background-color"));	
		Assert.assertEquals(driver.findElement(By.tagName("body")).getCssValue("background-color"), "rgba(151, 163, 193, 1)");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentFrame");
		System.out.println(driver.findElement(By.tagName("body")).getCssValue("background-color"));	
		Assert.assertEquals(driver.findElement(By.tagName("body")).getCssValue("background-color"), "rgba(102, 153, 102, 1)");
		
		driver.switchTo().defaultContent();
		driver.switchTo().window(pWindow);
		Assert.assertEquals(driver.getTitle(), "Welcome");;
	}
	
	@Test
	public void framesTest4() {
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href$='tab-4']")).click();
		
		driver.switchTo().frame(3);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Open multiple pages")).click();
		
		Set<String> wHandles = driver.getWindowHandles();
		Iterator<String> i = wHandles.iterator();
		System.out.println("No. of wondows - "+wHandles.size());
		String pWindow = i.next();
		while (i.hasNext()) {
			String cWindow = i.next();
			//Open Window
			driver.switchTo().window(cWindow);
			String linkText = "Open Window-";
			System.out.println(driver.findElement(By.partialLinkText(linkText)).getText());
			Assert.assertTrue(driver.findElement(By.partialLinkText(linkText)).getText().contains("Open Window-"));
		}
		driver.switchTo().window(pWindow);
		Assert.assertEquals(driver.getTitle(), "Welcome");;
	
	}
	
}

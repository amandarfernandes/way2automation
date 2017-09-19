package way2automation.w2atest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import way2automation.w2atest.resources.Base;

public class draggableTest extends Base {
	
	@BeforeMethod	
	public void loginValid() throws InterruptedException
	{
	LoginAsValidUser vu = new LoginAsValidUser();
	vu.login(TEST_USER, TEST_PASSWORD);
	Thread.sleep(5000);
	new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[1]/ul/li[1]/a/figure/img"))));
	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[1]/ul/li[1]/a/figure/img")).click();
	//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href *= 'tab-1'"))));
	}
	
	@Test
	public void draggableTest1() {
		
		driver.switchTo().defaultContent();
		//System.out.println("Test");
		driver.findElement(By.cssSelector("a[href *= 'tab-1']")).click();
		
		driver.switchTo().frame(0);
		
		Actions a = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		Point oldlocation = draggable.getLocation();
		System.out.println("Original x: "+oldlocation.getX()+"Original y: "+oldlocation.getY());
		
		a.dragAndDropBy(draggable, 105, 100).perform();
		Point location = draggable.getLocation();
		System.out.println("x: "+location.getX()+" y: "+location.getY());
		Assert.assertEquals(location.getX(), oldlocation.getX()+105);
		
		//draggable.
	}
	
}

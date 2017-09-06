package way2automation.w2atest.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


import way2automation.w2atest.resources.Base;



public class LoginAsValidUser extends Base {
  
	@Test (dataProvider="getUser")
	public void login(String userN, String userP) {
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		WebDriverWait w = new WebDriverWait(driver,10);
		
		//navigate to login overlay from register overlay
		WebElement signIn=w.until(ExpectedConditions.elementToBeClickable(By.linkText("Signin")));
		signIn.click();
		
		//login as valid user in login overlay
		WebElement loginBtn=w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='login']/form/div/div[2]/input")));
		driver.findElement(By.xpath("//div[@id='login']/form/fieldset[1]/input")).sendKeys(userN);
		driver.findElement(By.xpath("//div[@id='login']/form/fieldset[2]/input")).sendKeys(userP);
		loginBtn.click();
		AssertJUnit.assertTrue(driver.getTitle().equals("Welcome to the Test Site"));
  }

	@DataProvider
	public Object[][] getUser() {
		Object[][] user = new Object[1][2];
		user[0][0] ="afernandes";
		user[0][1] ="amanda23";
		return user;
	}
}
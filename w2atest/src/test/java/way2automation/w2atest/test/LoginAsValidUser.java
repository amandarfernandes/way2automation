package way2automation.w2atest.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import way2automation.w2atest.resources.Base;
import way2automation.w2atest.resources.Log;
import way2automation.w2atest.pageObjects.HomePage;



public class LoginAsValidUser extends Base {
    static WebDriver driver;
    
	@BeforeMethod
	public void setup() {
		driver = InitializeDriver();
		driver.get(URL);
	}
	
	@Test (dataProvider="getUser")
	public void login(String userN, String userP) {
		
		//navigate to login overlay from register overlay
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();
		
		//login as valid user in login overlay
		hp.setusername(userN);
		hp.setpassword(userP);
		hp.clickLoginBtn();
		Log.info(driver.getTitle());
		//AssertJUnit.assertTrue(hp.isLoginValid());
  }

	@DataProvider
	public Object[][] getUser() {
		Object[][] user = new Object[2][2];
		user[0][0] ="afernandes";
		user[0][1] ="amanda23";
		
		user[1][0] = "sss";
		user[1][1] = "pass";
		return user;
	}
}
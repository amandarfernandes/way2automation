package way2automation.w2atest.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import way2automation.w2atest.resources.Base;
import way2automation.w2atest.resources.Log;

//private By signupLnk = By.linkText("Signup");
//private By title = By.tagName("h3");
public class LoginTest extends Base{
	WebDriver driver;

	private @FindBy(linkText="Signin") WebElement signinLnk;
	
	private @FindBy (css="div#login > form > h3") WebElement title;
	private @FindBy(css="div#login > form > fieldset:nth-of-type(1) > input") WebElement username;
	private @FindBy(css="div#login > form > fieldset:nth-of-type(2) > input") WebElement password;
	private @FindBy(css="div#login > form > div > div.span_1_of_4 > input.button") WebElement loginBtn;

	@Test
	public void tryLogin() {
		driver = InitializeDriver();
		driver.get(URL);
		Log.info("On Homepage of way2automation");
		
		PageFactory.initElements(driver, this);
		
		signinLnk.click();
		Log.info("Selected sign in option");
		String expected = "LOGIN";
		String actual = title.getText();
		Log.info("Popup Title: "+actual);
		Assert.assertEquals(expected, actual);
		
		username.clear();
		username.sendKeys("afernandes");
		Log.info("Logging in as afernandes");
		password.clear();
		password.sendKeys("amanda23");
		
		loginBtn.click();
		
		
	}
}

package way2automation.w2atest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import way2automation.w2atest.resources.Log;

public class HomePage {
	
	//locators
	//private static WebDriver driver;

	private final WebDriver driver;

	//locators for Signup Popup
	private @FindBy(linkText="Signin") WebElement signinLnk;
	
	//locators for login popup
	private @FindBy (css="div#login > form > h3") WebElement loginTitle;
	private @FindBy(css="div#login > form > fieldset:nth-of-type(1) > input") WebElement username;
	private @FindBy(css="div#login > form > fieldset:nth-of-type(2) > input") WebElement password;
	private @FindBy(css="div#login > form > div > div.span_1_of_4 > input.button") WebElement loginBtn;
	
	//locators for navigating to indiviual elements pages
	private @FindBy() WebElement draggable;
	private @FindBy() WebElement droppable;
	private @FindBy() WebElement resizable;
	private @FindBy() WebElement selectable;
	private @FindBy() WebElement sortable;
	private @FindBy() WebElement accordion;
	private @FindBy() WebElement autocomplete;
	private @FindBy() WebElement datepicker;
	private @FindBy() WebElement menu;
	private @FindBy() WebElement slider;
	private @FindBy() WebElement tabs;
	private @FindBy() WebElement tooltips;
	private @FindBy() WebElement frames;
	private @FindBy() WebElement dropdowns;
	private @FindBy() WebElement buttons;
	private @FindBy(css="img[src*='registration']") WebElement registration;
	private @FindBy(css="img[src*='alert']") WebElement alert;
	
	
	public void navigateToItem(String item)
	{
		
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(alert));
		if (item.equals("alert"))
		{
			alert.click();
			Log.info("Navigating to Alerts Page");
		} else if (item.equals("registration")) {
			registration.click();
		}
			
	}
	
	public boolean isLoginValid() {
		return driver.getTitle().equals("Welcome to the Test Site"); 
	}
	
	
	public void setusername(String uname) {
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(loginBtn));
		username.clear();
		username.sendKeys(uname);
		Log.info("Username entered: "+uname);
		
	}
	
	public void setpassword(String pword) {
		password.clear();
		password.sendKeys(pword);
		Log.info("Password Entered: "+pword);
	}
	
	public void clickLoginBtn() {
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		Log.info("Clicked Login Button!");
	}

	public void clickSignIn() {
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(signinLnk));
		signinLnk.click();
		Log.info("Selected the Signin link on the Registration popup");
	}

	public HomePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		Log.info("Instantiated the Homepage Form page Objects");
	}

}

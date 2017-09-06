package way2automation.w2atest.pageObjects;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	private WebDriver driver;
	
	//locators
	private By firstName = By.cssSelector("form#register_form fieldset:nth-of-type(1) p input[name='name']"); 
	private By lastName = By.cssSelector("form#register_form fieldset:nth-of-type(1) p:nth-of-type(2) input");
	private By maritalStatus = By.xpath("//input[@name='m_status']");
	private By hobby = By.xpath("//input[@name='hobby']");
	private By title = By.cssSelector("h1.heading:nth-of-type(1)");
	private By phone = By.cssSelector("input[name='phone']");
	private By username = By.cssSelector("input[name='username']");
	private By email = By.cssSelector("input[name='email']");
	private By password = By.cssSelector("input[name='password']");
	private By cpassword = By.cssSelector("input[name='c_password']");
	private By about = By.xpath("//label[contains(text(),'About Yourself')]/following-sibling::textarea");
	private By country = By.xpath("//label[contains(text(),'Country')]/following-sibling::select");;
	private By month = By.xpath("//label[contains(text(),'Date of Birth')]/following-sibling::div[1]/select");
	private By day  = By.xpath("//label[contains(text(),'Date of Birth')]/following-sibling::div[2]/select");
	private By year  = By.xpath("//label[contains(text(),'Date of Birth')]/following-sibling::div[3]/select");
	private By submitBtn = By.cssSelector("input[type='submit']");
	private By uploadF = By.xpath("//input[@type='file']");
	
	public void uploadFile(String uf) throws InterruptedException 
	{
		driver.findElement(uploadF).sendKeys(uf);
			
	}
	
	public void clickSubmitBtn() {
		driver.findElement(submitBtn).click();
	}
	
	public void selectCountry(String c) {
		Select cntry = new Select(driver.findElement(country));
		cntry.selectByVisibleText(c);
	}
	
	public void selectMonth(String m) {
		Select mnth = new Select(driver.findElement(month));
		mnth.selectByVisibleText(m);
	}
	
	public void selectDay(String d) {
		Select dy = new Select(driver.findElement(day));
		dy.selectByVisibleText(d);
	}
	
	public void selectYear(String y) {
		Select yr = new Select(driver.findElement(year));
		yr.selectByVisibleText(y);
	}
	
	
	public void setAboutYou(String ay) {
		driver.findElement(about).clear();
		driver.findElement(about).sendKeys(ay);
	}
	
	public void setPhone(String ph)
	{
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(ph);
	}
	
	public void setUsername(String un)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(un);
	}
	
	public void setEmail(String e)
	{
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(e);
	}
	
	public void setPassword(String passwd)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(passwd);
	}
	
	public void setCPassword(String passwd)
	{
		driver.findElement(cpassword).clear();
		driver.findElement(cpassword).sendKeys(passwd);
	}
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	public void setFirstName(String fname)
	{
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void setMaritalStatus(String mState)
	{
		List<WebElement> m_states = driver.findElements(maritalStatus); 
		System.out.println("Marital Status: "+m_states.size());
		Iterator<WebElement> i = m_states.iterator();
		
		while (i.hasNext())
		{
			WebElement m = i.next();
			if (m.findElement(By.xpath("..")).getText().equals(mState)) {
				m.click();
			}
		}
	}
	
	public void setHobby(String myHobby)
	{
		List<WebElement> hobbies = driver.findElements(hobby); 
		System.out.println("hobbies: "+hobbies.size());
		Iterator<WebElement> i = hobbies.iterator();
		
		while (i.hasNext())
		{
			WebElement aHobby = i.next();
			if (aHobby.findElement(By.xpath("..")).getText().equals(myHobby)) {
				aHobby.click();
			}
		}
	}
	
	public boolean isPageOpen() {
		return driver.findElement(title).getText().equals("Registration");
	}
	
	
}

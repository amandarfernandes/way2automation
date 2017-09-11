package way2automation.w2atest.resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	public static final String TEST_USER="afernandes";
	public static final  String TEST_PASSWORD="amanda23";
	
	public static WebDriver driver;

	@BeforeMethod
	public void InitializeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/admin/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}
}

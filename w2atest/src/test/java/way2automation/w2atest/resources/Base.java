package way2automation.w2atest.resources;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

	public static WebDriver driver;
	
	@BeforeClass
	public void InitializeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/admin/selenium/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

/*	@AfterClass
	public void tearDown() {
		driver.close();
		driver=null;
	}
	*/
}

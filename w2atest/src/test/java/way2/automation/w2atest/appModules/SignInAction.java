package way2.automation.w2atest.appModules;

import org.openqa.selenium.WebDriver;

import way2automation.w2atest.pageObjects.HomePage;
import way2automation.w2atest.resources.Base;

public class SignInAction {

	public static void execute(WebDriver driver,String item) {
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();
		
		hp.setusername(Base.TEST_USER);
		hp.setpassword(Base.TEST_PASSWORD);
		hp.clickLoginBtn();
		hp.navigateToItem(item);
	}
}
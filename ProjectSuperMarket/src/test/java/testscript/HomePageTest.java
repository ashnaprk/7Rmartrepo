package testscript;

import java.awt.AWTException;
//import java.awt.Robot;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {
	HomePage homepage;

	@Test
	public void verifylogout() throws AWTException

	{
		LoginPage login = new LoginPage(driver);
		login.enterUserNameAndPassWordfield("admin", "admin");
		homepage = login.loginButton();
		homepage.adminButton().logoutButton();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "Logout failes");
	}
}
